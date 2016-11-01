package com.jpmorgan.simple.stocks.model;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test class for Stock
 * 
 * @author Veeranjaneyulu Sivaratri
 *
 */
public class StockTest {

	/**
	 * Setting up Stock object for testing
	 */
	@BeforeTest
	public void setUp() {
	}

	/**
	 * Calculate dividend yield before any trade
	 */
	@Test
	public void calculateDividendYieldBeforeAnyTrade() {
		Stock stock = new Stock("POP", StockType.COMMON, 8, 0.0, 100);
		double dividend = stock.calculateDividendYield();
		Assert.assertEquals(dividend, 0.0);
	}
	
	/**
	 * Calculate dividend yield after a trade
	 */
	@Test
	public void calculateDividendYieldAfterATrade() {
		Stock stock = new Stock("POP", StockType.COMMON, 8, 0.0, 100);
		Trade trade = new Trade(new Date(), stock, 25, 107, TradeType.BUY);
		stock.recordTrade(trade);
		double dividend = stock.calculateDividendYield();
		String dividendStr = String.format("%3.2f", dividend);
		Assert.assertEquals(dividendStr, "0.07");
	}
	
	/**
	 * Calculate dividend yield for a preferred stock after a trade
	 */
	@Test
	public void calculateDividendYieldPreferredStock() {
		Stock stock = new Stock("GIN", StockType.PREFERRED, 8, 2.0, 100);
		Trade trade = new Trade(new Date(), stock, 10, 105, TradeType.BUY);
		stock.recordTrade(trade);
		double dividend = stock.calculateDividendYield();
		String dividendStr = String.format("%3.2f", dividend);
		Assert.assertEquals(dividendStr, "1.90");
	}

	/**
	 * Calculate P/E Ratio before any trade
	 */
	@Test
	public void calculatePERatioBeforeAnyTrade() {
		Stock stock = new Stock("POP", StockType.COMMON, 8, 0.0, 100);
		double peRatio = stock.calculatePERatio();
		Assert.assertEquals(peRatio, 0.0);
	}
	/**
	 * Calculate P/E Ratio after a trade
	 */
	@Test
	public void calculatePERatioAfterATrade() {
		Stock stock = new Stock("POP", StockType.COMMON, 8, 0.0, 100);
		Trade trade = new Trade(new Date(), stock, 25, 107, TradeType.BUY);
		stock.recordTrade(trade);
		double peRatio = stock.calculatePERatio();
		String peRatioStr = String.format("%6.2f", peRatio);
		Assert.assertEquals(peRatioStr, "1431.13");
	}

	/**
	 * Get last traded price before any trade
	 */
	@Test
	public void lastTradedPriceBeforeAnyTrade() {
		Stock stock = new Stock("POP", StockType.COMMON, 8, 0.0, 100);
		double lastTradedPrice = stock.lastTradedPrice();
		Assert.assertEquals(lastTradedPrice, 0.0);
	}
	
	/**
	 * Get last traded price after a trade
	 */
	@Test
	public void lastTradedPriceAfterATrade() {
		Stock stock = new Stock("POP", StockType.COMMON, 8, 0.0, 100);
		Trade trade = new Trade(new Date(), stock, 25, 107, TradeType.BUY);
		stock.recordTrade(trade);
		double lastTradedPrice = stock.lastTradedPrice();
		String peRatioStr = String.format("%5.2f", lastTradedPrice);
		Assert.assertEquals(peRatioStr, "107.00");
	}
	
	@Test
	public void getStockId(){
		Stock stock = new Stock("POP", StockType.COMMON, 8, 0.0, 100);
		String stockId = stock.getStockId();
		Assert.assertEquals(stockId, "POP");
	}
	
}
