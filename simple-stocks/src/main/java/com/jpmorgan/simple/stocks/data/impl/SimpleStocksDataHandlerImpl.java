/**
 * 
 */
package com.jpmorgan.simple.stocks.data.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jpmorgan.simple.stocks.data.SimpleStocksDataHandler;
import com.jpmorgan.simple.stocks.model.Stock;
import com.jpmorgan.simple.stocks.model.StockType;

/**
 * This class creates a Map with hard coded set of stocks. The Map will be used
 * as the stocks database for this application.
 * 
 * @author Veeranjaneyulu Sivaratri
 *
 */
@Repository("simpleStocksDataHandlerImpl")
public class SimpleStocksDataHandlerImpl implements SimpleStocksDataHandler {

	// This is in memory database of stocks
	private Map<String, Stock> stocksDataBase = new HashMap<>();

	/**
	 * This constructor populates the HashMap (database for this application)
	 * with hard coded stocks
	 */
	public SimpleStocksDataHandlerImpl() {
		// create in memory stocks
		Stock tea = new Stock("TEA", StockType.COMMON, 0, 0.0, 100);
		Stock pop = new Stock("POP", StockType.COMMON, 8, 0.0, 100);
		Stock ale = new Stock("ALE", StockType.COMMON, 23, 0.0, 60);
		Stock gin = new Stock("GIN", StockType.PREFERRED, 8, 2.0, 100);
		Stock joe = new Stock("JOE", StockType.COMMON, 13, 0.0, 250);
		stocksDataBase.put(tea.getStockId(), tea);
		stocksDataBase.put(pop.getStockId(), pop);
		stocksDataBase.put(ale.getStockId(), ale);
		stocksDataBase.put(gin.getStockId(), gin);
		stocksDataBase.put(joe.getStockId(), joe);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jpmorgan.simple.stocks.data.SimpleStocksDataHandler#getStocksDataBase
	 * ()
	 */
	@Override
	public Map<String, Stock> getStocksDataBase() {
		return stocksDataBase;
	}

}
