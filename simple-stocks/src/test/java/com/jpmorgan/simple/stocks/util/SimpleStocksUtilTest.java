package com.jpmorgan.simple.stocks.util;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class SimpleStocksUtilTest {

  @Test
  public void loadServiceAndDatabase() {
	  boolean success = SimpleStocksUtil.loadServiceAndDatabase();
	  Assert.assertTrue(success);
  }
}
