package com.example.demo.interceptor;

import com.example.demo.entity.PersonEntity;
import com.example.demo.enumerators.StaticValues;
import com.example.demo.wrapper.RequestWrapper;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonInterceptor extends GenericInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestWrapper requestWrapper = new RequestWrapper(request);
        String requestData = requestWrapper.getBody();
        String uri = requestWrapper.getRequestURI();
        PersonEntity data = new Gson().fromJson(requestData, PersonEntity.class);
        boolean isError = false;
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String type = StaticValues.JSON_TYPE_OBJECT.toString();
        String msg = "";
        String operation = uri.contains("create") ?
                StaticValues.MSG_CRUD_CREATE.toString() : StaticValues.MSG_CRUD_UPDATE.toString();
        if(!StringUtils.hasLength(data.getName()) || !StringUtils.hasLength(data.getCi())
                || !StringUtils.hasLength(data.getAddress()) || !StringUtils.hasLength(data.getGender())
                || !StringUtils.hasLength(data.getLastname()) || data.getCity() == 0
                || !StringUtils.hasLength(String.valueOf(data.getCity()))){
            isError = true;
            msg = StaticValues.MSG_EMPTY_DATA.toString();
        }
        else if (data.getGender().length() > 1){
            isError = true;
            msg = StaticValues.MSG_PERSON_GENDER_ERROR.toString();
        }
        else if (data.getCi().length() > 11 || data.getCi().length() < 6){
            isError = true;
            msg = StaticValues.MSG_PERSON_CI_ERROR.toString();
        }
        else if (!data.getCi().matches("[0-9]+")){
            isError = true;
            msg = StaticValues.MSG_PERSON_CI_NUMBER_ERROR.toString();
        }
        if (isError){
            formatJSONResponseError(response, type, msg, status, operation);
            return false;
        }
        return true;
    }
}
