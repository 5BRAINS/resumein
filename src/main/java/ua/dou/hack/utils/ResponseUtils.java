package ua.dou.hack.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  21.02.15.
 */
@Component
public class ResponseUtils {
    public String getEntity(HttpPost request,
                            List<BasicNameValuePair> parameters) {
        String entity = null;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            request.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
            HttpResponse response = httpClient.execute(request);
            entity = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }
}
