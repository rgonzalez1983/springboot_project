package com.example.demo.interceptor;

import com.example.demo.entity.ResponseGenericEntity;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GenericInterceptor {

    public void formatJSONResponseError(HttpServletResponse response, String type, String msg, int status, String op) throws IOException {
        JSONObject map = (JSONObject) new ResponseGenericEntity<>().convertResponse(type, msg, status, op, null);
        response.getWriter().write(map.toJSONString());
        response.setContentType("application/json");
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
