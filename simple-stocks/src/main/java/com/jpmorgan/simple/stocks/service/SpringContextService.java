/**
 * 
 */
package com.jpmorgan.simple.stocks.service;

import org.springframework.context.ApplicationContext;

import com.jpmorgan.simple.stocks.service.impl.SpringContextServiceImpl;

/**
 * This service loads Spring Application Context and provides an instance of the
 * application context.
 * 
 * @author Veeranjaneyulu Sivaratri
 *
 */
public interface SpringContextService {
	public static final ApplicationContext SPRING_CONTEXT = SpringContextServiceImpl.getSpringContext();
}
