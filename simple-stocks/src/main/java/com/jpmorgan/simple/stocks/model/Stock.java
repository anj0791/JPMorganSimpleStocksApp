/**
 * 
 */
package com.jpmorgan.simple.stocks.model;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * This class represents a Stock model object and also provides methods to
 * calculate dividend, p/e ratio and ticker price.
 * 
 * @author Veeranjaneyulu Sivaratri
 *
 */
public class Stock {
	private String stockId;
	private StockType stockType;
	private int lastDividend;
	private double fixedDividendPercent;
	private int parValue;
	private TreeMap<Date, Trade> trades;

	/**
	 * Stock constructor
	 * 
	 * @param stockId
	 * @param stockType
	 * @param lastDividend
	 * @param fixedDividendPercent
	 * @param parValue
	 */
	public Stock(String stockId, StockType stockType, int lastDividend, double fixedDividendPercent, int parValue) {
		this.stockId = stockId;
		this.stockType = stockType;
		this.lastDividend = lastDividend;
		this.fixedDividendPercent = fixedDividendPercent;
		this.parValue = parValue;
		this.trades = new TreeMap<Date, Trade>();
	}

	/**
	 * Calculates dividend yield of the stock
	 * 
	 * @return dividendYield
	 */
	public double calculateDividendYield() {
		double dividendYield = 0.0;
		double stockTickerPrice = calculateStockTickerPrice();
		if (stockTickerPrice != 0.0) {
			if (stockType == StockType.COMMON) {
				dividendYield = lastDividend / stockTickerPrice;
			} else {
				dividendYield = (fixedDividendPercent * parValue) / stockTickerPrice;
			}
		}
		return dividendYield;
	}

	/**
	 * Calculates P/E ratio of the stock.
	 * 
	 * @return peRatio
	 */
	public double calculatePERatio() {
		double peRatio = 0.0;
		double stockTickerPrice = calculateStockTickerPrice();
		double dividendYield = this.calculateDividendYield();
		if (stockTickerPrice > 0.0 && dividendYield > 0.0) {
			peRatio = stockTickerPrice / dividendYield;
		}
		return peRatio;
	}

	/**
	 * Calculates Ticker Price of the stock.
	 * 
	 * @return tickerPrice
	 */
	public double calculateStockTickerPrice() {

		Date currentTimeStamp = new Date();
		Date currentTimeMinus15Mins = new Date(currentTimeStamp.getTime() - (15 * 60 * 1000));
		SortedMap<Date, Trade> tradesInLast15Mins = this.trades.tailMap(currentTimeMinus15Mins);
		double totalStockPrice = 0.0;
		int totalQuantity = 0;
		for (Trade trade : tradesInLast15Mins.values()) {
			totalQuantity += trade.getQuantity();
			totalStockPrice += trade.getPrice() * trade.getQuantity();
		}
		if (totalStockPrice != 0.0 || totalQuantity != 0) {
			return totalStockPrice / totalQuantity;
		}
		return 0.0;

	}

	/**
	 * Records a given trade of the current stock.
	 * 
	 * @param trade
	 */
	public void recordTrade(Trade trade) {
		this.trades.put(new Date(), trade);
	}

	/**
	 * Returns the last traded price of the stock.
	 * 
	 * @return lastTradedPrice
	 */
	public double lastTradedPrice() {
		if (this.trades.size() > 0) {
			// last traded price
			return this.trades.lastEntry().getValue().getPrice();
		} else {
			// No trades of the stock so far
			return 0.0;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getStockId() {
		return stockId;
	}

	/**
	 * 
	 * @return
	 */
	public StockType getStockType() {
		return stockType;
	}


	/**
	 * 
	 * @return
	 */
	public int getLastDividend() {
		return lastDividend;
	}


	/**
	 * 
	 * @return
	 */
	public double getFixedDividendPercent() {
		return fixedDividendPercent;
	}


	/**
	 * 
	 * @return
	 */
	public int getParValue() {
		return parValue;
	}

}
