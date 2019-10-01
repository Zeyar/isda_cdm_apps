/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbvr.isda.cdm.util;

import com.google.gson.Gson;

/**
 *
 * @author zeyarhtike
 */
public class JsonUtil {
    public static <T> T stringToMap(Class<T> clazz,String jsonString){        
        Gson gson=new Gson();
        return gson.fromJson(jsonString, clazz);
    }
    
    public static String toJsonString(Object obj){        
        Gson gson=new Gson();
        String result=gson.toJson(obj);
        return result;
    }
}
