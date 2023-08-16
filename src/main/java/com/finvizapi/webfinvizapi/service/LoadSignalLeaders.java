package com.finvizapi.webfinvizapi.service;

import java.util.logging.Logger;

public class LoadSignalLeaders {
    private static final Logger LOG = Logger.getLogger(LoadStocks.class.getName());

    static int stockId = 0;

    private synchronized static int nextStockId() {
        int id = stockId;
        ++stockId;
        return id;
    }

    public LoadSignalLeaders() {
    }
}
