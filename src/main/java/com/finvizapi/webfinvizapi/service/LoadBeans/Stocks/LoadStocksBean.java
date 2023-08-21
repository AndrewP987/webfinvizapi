package com.finvizapi.webfinvizapi.service.LoadBeans.Stocks;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LoadStocksBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        // Call the method to generate the JSON file
        LoadStocks.generateStockTickerJson(("./webfinvizapi/src/main/data/Stocks.json"));
    }
}
