/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbvr.isda.cdm.controller;

import cbvr.isda.cdm.util.LogFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zeyarhtike
 */

@RestController
public class AliveController {
    
    
    private static final Logger LOG = LogFactory.createLogger(AliveController.class );
    
    @RequestMapping(value = "/alive")
    public ResponseEntity<?> alive(){
        LOG.info("alive() - "+Thread.currentThread().getName());
        return ResponseEntity.ok("OK");
    }
    
}
