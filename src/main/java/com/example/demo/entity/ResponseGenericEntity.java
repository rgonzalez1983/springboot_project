package com.example.demo.entity;

import com.example.demo.enumerators.StaticKeys;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class ResponseGenericEntity<T> {

    public Object convertResponse(String type, String message, int statusCode, String crudOperation, T entity) {
        Object response;
        if (type.equalsIgnoreCase("MAP")) {
            response = new HashMap();
            ((HashMap) response).put(StaticKeys.MESSAGE.toString(), message);
            ((HashMap) response).put(StaticKeys.STATUS_CODE.toString(), statusCode);
            ((HashMap) response).put(StaticKeys.CRUD_OPERATION.toString(), crudOperation);
            if (entity != null) {
                ((HashMap) response).put(StaticKeys.DATA.toString(), entity);
            }
        }
        else{
            response = new JSONObject();
            ((JSONObject) response).put(StaticKeys.MESSAGE.toString(), message);
            ((JSONObject) response).put(StaticKeys.STATUS_CODE.toString(), statusCode);
            ((JSONObject) response).put(StaticKeys.CRUD_OPERATION.toString(), crudOperation);
            if (entity != null) {
                ((JSONObject) response).put(StaticKeys.DATA.toString(), entity);
            }
        }
        return response;
    }
}
