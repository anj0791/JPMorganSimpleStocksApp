/**
 * 
 */
package com.jpmorgan.simple.stocks.util;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.jpmorgan.simple.stocks.model.Stock;
import com.jpmorgan.simple.stocks.model.Trade;
import com.jpmorgan.simple.stocks.model.TradeType;
import com.jpmorgan.simple.stocks.service.SimpleStocksService;
import com.jpmorgan.simple.stocks.service.SpringContextService;

/**
 * This class provides static utility methods that help the application print
 * Stocks Dashboard, read user inputs.
 * 
 * @author Veeranjaneyulu Sivaratri
 *
 */
public class SimpleStocksUtil {
	private static final Logger logger = LoggerFactory.getLogger(SimpleStocksUtil.class);

	private static ApplicationContext context = SpringContextService.SPRING_CONTEXT;
	private static SimpleStocksService simpleStocksService = null;
	private static Map<String, Stock> allStocks = null;

	/**
	 * This methods loads the simpleStocksServiceImpl and the stocks database.
	 */
	public static boolean loadServiceAndDatabase() {
		boolean success = false;
		simpleStocksService = (SimpleStocksService) context.getBean("simpleStocksServiceImpl");
		allStocks = simpleStocksService.getStocksDataBase();
		logger.info("simpleStocksServiceImpl and the database are loaded.");
		success = true;
		return success;
	}

	/**
	 * This methods reads Trade details from the user and calls Stock's method
	 * to record the trade.
	 * 
	 * @param scanner
	 */
	public static void readAndRecordTrade(Scanner scanner) {
		try {
			System.out.println("Please enter the stock you want to trade: ");
			scanner.nextLine();
			String stockId = scanner.next();
			Stock stock = allStocks.get(stockId.toUpperCase());
			if (stock == null) {
				System.out.println("Stock doesn't exist. Returning to the Stocks Dashboard.");
				return;
			}
			System.out.println("Please enter 1 to buy; 2 to sell: ");
			scanner.nextLine();
			int buyOrSell = scanner.nextInt();
			TradeType tradeType = TradeType.BUY;
			if (buyOrSell == 2) {
				tradeType = TradeType.SELL;
			} else if (buyOrSell == 1) {
				tradeType = TradeType.BUY;
			} else {
				System.out.println("Invalid input. Returning to the Stocks Dashboard.");
				return;
			}
			System.out.println("Please enter quantity: ");
			scanner.nextLine();
			int quantity = 0;
			quantity = scanner.nextInt();
			if (quantity <= 0) {
				System.out.println("Invalid input. Returning to the Stocks Dashboard.");
				return;
			}

			System.out.println("Please enter price: ");
			scanner.nextLine();
			double price = 0.0;
			price = scanner.nextDouble();
			if (price <= 0.0) {
				System.out.println("Invalid input. Returning to the Stocks Dashboard.");
				return;
			}

			Trade trade = new Trade(new Date(), stock, quantity, price, tradeType);
			stock.recordTrade(trade);
			logger.info("Trade successfully recorded: [" + stock.getStockId() + ", " + quantity + ", " + price + ", "
					+ tradeType + " ]");

		} catch (Exception ex) {
			System.out.println("Invalid input. Returning the Main Dash Board.");
			logger.error("Invalid input.", ex);
			return;
		}

		System.out.println("Trade successfully recorded.");
	}

	public static void refreshStocksValues() {
		allStocks.values().forEach(stock -> stock.calculateDividendYield());
		allStocks.values().forEach(stock -> stock.calculatePERatio());
		allStocks.values().forEach(stock -> stock.calculateStockTickerPrice());
		simpleStocksService.calculateGBCEAllShareIndex();
		logger.info("Stocks dashboard refreshed.");
	}

	public static void printStocksDashboard() {
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"                                                     Stocks Dashboard                                   ");
		String headingsPattern = "%-15s%-15s%-15s%-25s%-10s%-20s%-15s%-15s%-15s";
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------");
		String heading = String.format(headingsPattern, "StockName", "StockType", "LastDividend",
				"FixedDividendPercent", "ParValue", "LastTradedPrice", "DividendYield", "P/E Ratio", "TickerPrice");
		System.out.println(heading);
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------");
		allStocks.forEach((k, v) -> {
			String rowPattern = "%-15s%-15s%12d%23.2f%10d%18.2f%16.2f%13.2f%16.2f";
			String row = String.format(rowPattern, v.getStockId(), v.getStockType(), v.getLastDividend(),
					v.getFixedDividendPercent(), v.getParValue(), v.lastTradedPrice(), v.calculateDividendYield(),
					v.calculatePERatio(), v.calculateStockTickerPrice());
			System.out.println(row);
		});
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("All number values in pennies");
		System.out.println("GBCE All shares index: " + simpleStocksService.calculateGBCEAllShareIndex());
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public static int getWantToTrade(Scanner scanner) {
		int userOption = 0;
		try {
			userOption = scanner.nextInt();
			while (userOption < 1 || userOption > 2) {
				System.out.println("Please enter a valid option: ");
				userOption = scanner.nextInt();
			}
		} catch (Exception ex) {
			logger.error("Invalid Input", ex);
			System.out.println("Please enter a number: ");
			scanner.nextLine();
			userOption = getWantToTrade(scanner);
		}
		return userOption;

	}

}
