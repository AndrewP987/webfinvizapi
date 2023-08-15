package com.finvizapi.webfinvizapi.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LoadStocksBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        // Call the method to generate the JSON file
        LoadStocks.generateStockTickerJson(("/Users/andrewphotinakis/Documents/FinvizAPI/webfinvizapi/src/main/data/stocks.json"));
    }
}
