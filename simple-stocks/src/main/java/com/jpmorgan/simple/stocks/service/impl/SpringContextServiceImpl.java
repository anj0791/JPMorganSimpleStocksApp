/**
 * 
 */
package com.jpmorgan.simple.stocks.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpmorgan.simple.stocks.service.SpringContextService;

/**
 * This singleton service implementation class loads the Spring Application
 * Context.
 * 
 * @author Veeranjaneyulu Sivaratri
 *
 */

public class SpringContextServiceImpl implements SpringContextService {
	private static final Logger logger = LoggerFactory.getLogger(SpringContextServiceImpl.class);
	private static ApplicationContext springContext = null;

	private SpringContextServiceImpl() {
		SpringContextServiceImpl.springContext = new ClassPathXmlApplicationContext("SimpleStocksAppContext.xml");
		logger.info("Spring Application Context loaded.");
	}

	private static class SpringContextContainer {
		{
			new SpringContextServiceImpl();
		}
	}

	public static ApplicationContext getSpringContext() {
		new SpringContextContainer();
		return SpringContextServiceImpl.springContext;
	}

}
