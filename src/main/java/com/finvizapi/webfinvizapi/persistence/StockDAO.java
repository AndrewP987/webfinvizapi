package com.finvizapi.webfinvizapi.persistence;

import java.io.IOException;

import com.finvizapi.webfinvizapi.model.Stock;

public interface StockDAO {

    Stock[] getStocks() throws IOException;

    Stock[] findStock(String containsText) throws IOException;

    Stock getStock(int id) throws IOException;

    Stock createStock(Stock Stock) throws IOException;

    Stock updateStock(Stock Stock) throws IOException;

    boolean deleteStock(int id) throws IOException;

}
