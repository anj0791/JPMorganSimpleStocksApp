/**
 * 
 */
package com.jpmorgan.simple.stocks.service;

import java.util.Map;

import com.jpmorgan.simple.stocks.model.Stock;

/**
 * This service provides methods to calculate GBCE All Share index and to get
 * stocks data.
 * 
 * @author Veeranjaneyulu Sivaratri
 *
 */
public interface SimpleStocksService {
	public double calculateGBCEAllShareIndex();
	public Map<String, Stock> getStocksDataBase();
}
