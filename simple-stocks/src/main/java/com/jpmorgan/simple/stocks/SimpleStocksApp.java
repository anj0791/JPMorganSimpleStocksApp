package com.jpmorgan.simple.stocks;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jpmorgan.simple.stocks.util.SimpleStocksUtil;

/**
 * Simple Stocks Application continuously displays a Stocks Dashboard, receives
 * trade details from the user, records the trades and refreshes the Dashboard.
 * Application ends when the user chooses to do so. The application has a fixed
 * set of stocks which is maintained in an in-memory database (a Map). The
 * database is updated when a trade is recorded.
 * 
 * @author Veeranjaneyulu Sivaratri
 */
public class SimpleStocksApp {
	private static final Logger logger = LoggerFactory.getLogger(SimpleStocksApp.class);

	/**
	 * Application's main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("SimpleStocksApp started.");
		SimpleStocksUtil.loadServiceAndDatabase();
		int wantToTrade = 0;
		try (Scanner scanner = new Scanner(System.in)) {
			while (wantToTrade != 2) {
				SimpleStocksUtil.printStocksDashboard();
				System.out.println("Enter 1 to trade; 2 to quit: ");
				wantToTrade = SimpleStocksUtil.getWantToTrade(scanner);
				if (wantToTrade == 1) {
					SimpleStocksUtil.readAndRecordTrade(scanner);
					SimpleStocksUtil.refreshStocksValues();
				} else {
					System.out.println("Application terminated.");
					logger.info("SimpleStocksApp terminated");
					System.exit(0);
				}
			}
		}

	}

}
