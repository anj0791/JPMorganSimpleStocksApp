/**
 * 
 */
package com.jpmorgan.simple.stocks.data;

import java.util.Map;

import com.jpmorgan.simple.stocks.model.Stock;

/**
 * Database handler
 * 
 * @author Veeranjaneyulu Sivaratri
 */
public interface SimpleStocksDataHandler {


	/**
	 * Gets the database which is a Map of stocks
	 * @return
	 */
	public Map<String, Stock> getStocksDataBase();

}
