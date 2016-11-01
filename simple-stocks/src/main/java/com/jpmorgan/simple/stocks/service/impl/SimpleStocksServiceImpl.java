/**
 * 
 */
package com.jpmorgan.simple.stocks.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jpmorgan.simple.stocks.data.SimpleStocksDataHandler;
import com.jpmorgan.simple.stocks.model.Stock;
import com.jpmorgan.simple.stocks.service.SimpleStocksService;

/**
 * This is the Simple Stocks Service implementation class.
 * 
 * @author Veeranjaneyulu Sivaratri
 *
 */
@Service("simpleStocksServiceImpl")
public class SimpleStocksServiceImpl implements SimpleStocksService {

	@Resource(name = "simpleStocksDataHandlerImpl")
	private SimpleStocksDataHandler simpleStocksDataHandler;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jpmorgan.simple.stocks.service.SimpleStocksService#
	 * calculateGBCEAllShareIndex()
	 */
	@Override
	public double calculateGBCEAllShareIndex() {
		double allShareIndex = 0.0;
		Map<String, Stock> stocksDataBase = simpleStocksDataHandler.getStocksDataBase();

		for (Stock stock : stocksDataBase.values()) {
			allShareIndex += stock.lastTradedPrice();
		}
		return Math.pow(allShareIndex, 1.0 / stocksDataBase.size());
	}

	@Override
	public Map<String, Stock> getStocksDataBase() {
		return simpleStocksDataHandler.getStocksDataBase();
	}
}
