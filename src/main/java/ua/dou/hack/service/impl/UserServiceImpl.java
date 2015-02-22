package ua.dou.hack.service.impl;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dou.hack.domain.Resume;
import ua.dou.hack.domain.User;
import ua.dou.hack.repository.UserRepository;
import ua.dou.hack.repository.common.Operations;
import ua.dou.hack.service.UserService;
import ua.dou.hack.service.common.AbstractService;
import ua.dou.hack.utils.ResponseUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mocker on 21.02.15 at 18:09.
 */

@Service
@Transactional
@PropertySource("classpath:client.properties")
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {

    @Autowired
    private Environment env;

    @Autowired
    private ResponseUtils responseUtils;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected Operations<User, Integer> getRepository() {
        return userRepository;
    }

    @Override
    public void saveAccessToken(String code, HttpServletResponse response) {
        HttpPost httpPost = new HttpPost("https://www.linkedin.com/uas/oauth2/accessToken");
        ArrayList<BasicNameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("grant_type", "authorization_code"));
        parameters.add(new BasicNameValuePair("code", code));
        parameters.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/rest/oauth/saveToken/"));
        parameters.add(new BasicNameValuePair("client_id", env.getProperty("client.key")));
        parameters.add(new BasicNameValuePair("client_secret", env.getProperty("client.secret")));
        String json = responseUtils.getEntity(httpPost, parameters);

        JSONObject jsonObject = null;
        String accessToken = null;
        Integer expiresIn = null;
        try {
            jsonObject = new JSONObject(json);
            accessToken = jsonObject.getString("access_token");
            expiresIn = jsonObject.getInt("expires_in");
            Cookie cookie = new Cookie("access_token", accessToken);
            cookie.setMaxAge(expiresIn);
            cookie.setPath("/");
            response.addCookie(cookie);
            createUser(accessToken, expiresIn);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createUser(String accessToken, int expIn) {
        HttpGet httpGet = new HttpGet("https://api.linkedin.com/v1/people/~?format=json");

        httpGet.addHeader("Authorization", "Bearer " + accessToken);
        String entity = responseUtils.getEntity(httpGet);

        try {
            JSONObject jsonObject = new JSONObject(entity);
            Matcher m = Pattern.compile("\"url\":.+?id=(\\d+)").matcher(entity);
            if (!m.find())
                throw new Exception("no user id");

            int userId = Integer.parseInt(m.group(1));
            User user = userRepository.find(userId);

            if (user == null) {
                String name = jsonObject.getString("firstName");
                String lastName = jsonObject.getString("lastName");
                user = new User(userId, accessToken, name, lastName);

                updateUserExpiryDate(user, expIn);

                create(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean isTokenOld(String accessToken) {
        User user = userRepository.findByToken(accessToken);
        if (user == null)
            return true;
        Timestamp expiryDate = user.getExpiryDate();
        return expiryDate.compareTo(new Date()) < 0;
    }

    @Override
    public String getShortLink(String accessToken) {
        User user = userRepository.findByToken(accessToken);
        List<Resume> resumes = user.getResumes();
        String link = null;
        if (!resumes.isEmpty()) {
            link = resumes.get(0).getLink();
        } else {
            link = user.getId().toString();
        }
        return link;
    }

    @Override
    public User findByToken(String accessToken) {
        return userRepository.findByToken(accessToken);
    }

    private void updateUserExpiryDate(User user, int expIn) {
        Calendar instance = Calendar.getInstance();
        long expTime = instance.getTime().getTime() + expIn * 1000;
        user.setExpiryDate(new Timestamp(expTime));
    }
}
