package com.finvizapi.webfinvizapi.service;

@Component
public class LoadSignalLeadersBean implements IntilizingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        // Call the method to generate the JSON file
        LoadSignalLeaders.generateStockTickerJson(("./webfinvizapi/src/main/data/signalLeaders.json"));
    }
}
