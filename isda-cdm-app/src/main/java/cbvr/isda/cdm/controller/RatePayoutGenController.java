/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbvr.isda.cdm.controller;

import cbvr.isda.cdm.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.regnosys.cdm.example.InterestRatePayoutCreation;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapper;
import java.util.Map;
import org.isda.cdm.InterestRatePayout;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zeyarhtike
 */

@RestController
public class RatePayoutGenController {
    
    
    @GetMapping(value = "/fixedRatePayout/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(){
        
        try{
            InterestRatePayout fixedRatePayout = InterestRatePayoutCreation.getFixedRatePayout();
            ObjectMapper rosettaObjectMapper = RosettaObjectMapper.getDefaultRosettaObjectMapper();
            String json = rosettaObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fixedRatePayout);

            return ResponseEntity.ok(JsonUtil.stringToMap(Map.class, json));
        
        }catch(Exception ex){
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping(value = "/fixedRatePayout/post")
    public ResponseEntity<?> postFixedRatePayout(@RequestBody(required = true)Map obj){
        
        try{
            
            //String json=obj.get("contract").toString();
            
            ObjectMapper rosettaObjectMapper = RosettaObjectMapper.getDefaultRosettaObjectMapper();
            //InterestRatePayout deserializedObject = JsonUtil.stringToMap(InterestRatePayout.class, json);
            Object def = obj.get("className");
            Object pl = obj.get("payload");
            
            
            String className = def != null ? def.toString() : InterestRatePayout.class.getName();
            
            System.out.println("className: "+className);
            Class clazz=Class.forName(className);
            
            String json = pl != null ? JsonUtil.toJsonString(pl):JsonUtil.toJsonString(obj);
            Object deserializedObject = rosettaObjectMapper.readValue(json, clazz);

            System.out.println(deserializedObject);
            return ResponseEntity.ok(deserializedObject);
        }catch(Exception ex){
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
}
