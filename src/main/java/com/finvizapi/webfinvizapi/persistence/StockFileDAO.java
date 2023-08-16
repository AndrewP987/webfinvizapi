package com.finvizapi.webfinvizapi.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finvizapi.webfinvizapi.model.Stock;

@Component
public class StockFileDAO implements StockDAO {
    private static final Logger LOG = Logger.getLogger(StockFileDAO.class.getName());
    HashMap<Integer, Stock> stockMap;

    private ObjectMapper objectMapper;

    private static int nextId;
    private String filename;

    public StockFileDAO(@Value("${stocks.file}") String filename, ObjectMapper objectMapper) throws IOException {
        this.filename = filename;
        this.objectMapper = objectMapper;
        load();
    }

    private synchronized static int nextStockId() throws IOException {
        int id = nextId;
        ++nextId;
        return id;
    }

    private boolean save() throws IOException {
        Stock[] stockArray = getStockArray();
        objectMapper.writeValue(new File(filename), stockArray);
        return true;
    }

    private boolean load() throws IOException {
        stockMap = new HashMap<>();
        nextId = 0;

        Stock[] stockArray = objectMapper.readValue(new File(filename), Stock[].class);
        for (Stock currStock : stockArray) {
            stockMap.put(currStock.getId(), currStock);
            if (currStock.getId() > nextId) {
                nextId = currStock.getId();
            }
        }
        ++nextId;
        return true;
    }

    private Stock[] getStockArray() {
        return getStockArray(null);
    }

    private Stock[] getStockArray(String containsText) {
        ArrayList<Stock> stockArrayList = new ArrayList<>();

        for (Stock stock : stockMap.values()) {
            if (containsText == null || stock.getTicker().contains(containsText)) {  
                stockArrayList.add(stock);
            }
        }
        Stock[] stockArray = new Stock[stockArrayList.size()];
        stockArrayList.toArray(stockArray);
        return stockArray;
    }

    @Override
    public Stock[] getStocks() throws IOException {
        synchronized (stockMap) {
            return getStockArray();
        }
    }

    @Override
    public Stock[] findStock(String containsText) throws IOException {
        synchronized (stockMap) {
            return getStockArray(containsText);
        }
    }

    @Override
    public Stock getStock(int id) throws IOException {
        synchronized (stockMap) {
            if (stockMap.containsKey(id)) {
                return stockMap.get(id);
            } else {
                return null;
            }
        }
    }

    @Override
    public Stock createStock(Stock stock) throws IOException {
        synchronized (stockMap) {
            Stock newStock = new Stock(stock);
            if (stockMap.containsValue(newStock)) {
                return null;
            }
            newStock.setId(nextId);
            stockMap.put(newStock.getId(), newStock);
            save();
            return newStock;
        }
    }

    @Override
    public Stock updateStock(Stock stock) throws IOException {
        synchronized (stockMap) {
            if (!stockMap.containsKey(stock.getId())) {
                return null;
            }
            stockMap.put(stock.getId(), stock);
            save();
            return stock;
        }
    }

    @Override
    public boolean deleteStock(int id) throws IOException {
        synchronized (stockMap) {
            if (stockMap.containsKey(id)) {
                stockMap.remove(id);
                return save();
            } else {
                return false;
            }
        }
    }

}
