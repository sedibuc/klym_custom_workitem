package com.klym.kbpm.shared.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klym.kbpm.shared.exception.KbpmException;
import com.klym.kbpm.shared.model.ResponseWrapper;

public class RestClient {
    
    public static void executeRequest(String url_str, ResponseWrapper cr) {
        URL url;
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader in = null;
        HttpURLConnection con = null;

        try {
            url = new URL(url_str);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setInstanceFollowRedirects(false);

            cr.setResponseCode(con.getResponseCode());
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            cr.setData(mapper.readValue(content.toString(), Map.class)); 
            cr.setJsonData(new JSONObject(content.toString()));
            cr.setJsonString(content.toString());
        } catch (MalformedURLException e) {
            throw new KbpmException(e, KbpmException.Errors.MalformedURL, "Error en la URL");
        } catch (IOException e) {
            throw new KbpmException(e, KbpmException.Errors.IO, "Error en la escritura");
        } catch (Exception e) {
            throw new KbpmException(e, KbpmException.Errors.Generic, "Error genérico");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // internal error won't be handled, just printed
                    e.printStackTrace();
                }
            }
            if (con != null) {
                con.disconnect();
            }
        }
    }
}
