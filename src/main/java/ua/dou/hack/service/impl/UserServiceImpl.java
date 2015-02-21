package ua.dou.hack.service.impl;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dou.hack.domain.User;
import ua.dou.hack.repository.UserRepository;
import ua.dou.hack.repository.common.Operations;
import ua.dou.hack.service.UserService;
import ua.dou.hack.service.common.AbstractService;
import ua.dou.hack.utils.ResponseUtils;

import java.util.ArrayList;

/**
 * mocker on 21.02.15 at 18:09.
 */

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {
    @Autowired
    private ResponseUtils responseUtils;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected Operations<User, Integer> getRepository() {
        return userRepository;
    }

    @Override
    public void saveAccessToken(String code) {
        HttpPost httpPost = new HttpPost("https://www.linkedin.com/uas/oauth2/accessToken");
        ArrayList<BasicNameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("grant_type", "authorization_code"));
        parameters.add(new BasicNameValuePair("code", code));
        parameters.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/rest/oauth/saveToken/"));
        parameters.add(new BasicNameValuePair("client_id", ""));
        parameters.add(new BasicNameValuePair("client_secret", ""));
        String json = responseUtils.getEntity(httpPost, parameters);
        JSONObject jsonObject = null;
        String accessToken = null;
        try {
            jsonObject = new JSONObject(json);
            accessToken = jsonObject.getString("access_token");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
