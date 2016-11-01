package com.jpmorgan.simple.stocks.service.impl;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jpmorgan.simple.stocks.model.Stock;
import com.jpmorgan.simple.stocks.service.SimpleStocksService;
import com.jpmorgan.simple.stocks.service.SpringContextService;

public class SimpleStocksServiceImplTest {
	private static ApplicationContext context = SpringContextService.SPRING_CONTEXT;
	private static SimpleStocksService simpleStocksService = null;
	private static Map<String, Stock> allStocks = null;
	
	@BeforeTest
	public void setUp(){
		simpleStocksService = (SimpleStocksService) context.getBean("simpleStocksServiceImpl");
		allStocks = simpleStocksService.getStocksDataBase();
	}
	
  @Test
  public void calculateGBCEAllShareIndex() {
	  double index = simpleStocksService.calculateGBCEAllShareIndex();
		String indexStr = String.format("%2.2f", index);
		Assert.assertEquals(indexStr, "0.00");
  }

  @Test
  public void getStocksDataBase() {
	  allStocks = simpleStocksService.getStocksDataBase();
	  Assert.assertNotNull(allStocks);
  }
}
