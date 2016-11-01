/**
 * 
 */
package com.jpmorgan.simple.stocks.model;

import java.util.Date;

/**
 * This class represents the Trade model objects.
 * 
 * @author Veeranjaneyulu Sivaratri
 *
 */
public class Trade {
	private Date timeStamp;
	private Stock stock;
	private int quantity;
	private double price;
	private TradeType tradeType;
	
	/**
	 * Constructor
	 * 
	 * @param timeStamp
	 * @param stock
	 * @param quantity
	 * @param price
	 * @param tradeType
	 */
	public Trade(Date timeStamp, Stock stock, int quantity, double price, TradeType tradeType){
		this.timeStamp = timeStamp;
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
		this.tradeType = tradeType;
	}
	/**
	 * 
	 * @return
	 */
	public Stock getStock() {
		return stock;
	}
	/**
	 * 
	 * @param stock
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	/**
	 * 
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * 
	 * @return
	 */
	public TradeType getTradeType() {
		return tradeType;
	}
	/**
	 * 
	 * @param tradeType
	 */
	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}
	/**
	 * 
	 * @return
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}
	/**
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
