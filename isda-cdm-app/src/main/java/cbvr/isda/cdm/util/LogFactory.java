/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbvr.isda.cdm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author zeyarhtike
 */
public class LogFactory {
    
    public static final Logger createLogger(Class clz){
        return LoggerFactory.getLogger(clz);
    }    
    
}
