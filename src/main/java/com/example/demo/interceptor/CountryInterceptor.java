package com.example.demo.interceptor;

import com.example.demo.entity.CountryEntity;
import com.example.demo.enumerators.StaticValues;
import com.example.demo.wrapper.RequestWrapper;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryInterceptor extends GenericInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestWrapper requestWrapper = new RequestWrapper(request);
        String requestData = requestWrapper.getBody();
        String uri = requestWrapper.getRequestURI();
        CountryEntity data = new Gson().fromJson(requestData, CountryEntity.class);
        boolean isError = false;
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String type = StaticValues.JSON_TYPE_OBJECT.toString();
        String msg = "";
        String operation = uri.contains("create") ?
                StaticValues.MSG_CRUD_CREATE.toString() : StaticValues.MSG_CRUD_UPDATE.toString();
        if(!StringUtils.hasLength(data.getName())){
            isError = true;
            msg = StaticValues.MSG_EMPTY_DATA.toString();
        }
        if (isError){
            formatJSONResponseError(response, type, msg, status, operation);
            return false;
        }
        return true;
    }
}
