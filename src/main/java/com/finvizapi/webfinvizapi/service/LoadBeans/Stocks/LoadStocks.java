package com.finvizapi.webfinvizapi.service.LoadBeans.Stocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finvizapi.webfinvizapi.model.Stock;
import com.finvizapi.webfinvizapi.service.JsonPropertyExtractor;
import com.finvizapi.webfinvizapi.service.FinvizScrapingService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class LoadStocks {
    private static final Logger LOG = Logger.getLogger(LoadStocks.class.getName());

    static int stockId = 0;

    private synchronized static int nextStockId() {
        int id = stockId;
        ++stockId;
        return id;
    }

    public LoadStocks() {
    }

    static String[] readStockTickersFromFile(String filePath) {
        List<String> tickers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tickers.add(line.trim()); // Add each ticker to the list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickers.toArray(new String[0]); // Convert list to array and return
    }

    static synchronized void generateStockTickerJson(String filePath) {
        long startTime = System.nanoTime();
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();
        String[] s_and_p_tickers = readStockTickersFromFile("./webfinvizapi/src/main/data/Stocks.txt");
        int written = 0; 
        int failed = 0; 
        try {

            for (String ticker : s_and_p_tickers) {
                ArrayList<String> keys = JsonPropertyExtractor.getPropertyNames(Stock.class);
                ArrayList<String> values = FinvizScrapingService.readStockTableAndReturnAllTableValues(ticker);
                ObjectNode currentStockEntry = objectMapper.createObjectNode();
                for (int i = 0; i < values.size(); i++) {
                    if (i == 0) {
                        currentStockEntry.put(keys.get(i), nextStockId());
                    } else if (i == 1) {
                        currentStockEntry.put(keys.get(i), ticker);
                    } else {
                        currentStockEntry.put(keys.get(i), values.get(i));
                    }
                }
                jsonArray.add(currentStockEntry);
            }
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(jsonArray.toString());

                LOG.info("JSON data has been written to the file: " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
                LOG.warning("Error writing JSON data to file: " + filePath);
            }
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            LOG.info("Function execution time: " + executionTime + " nanoseconds");

        } catch (Exception e) {
            e.printStackTrace();
            LOG.warning("Error creating JSON: " + e.getMessage());
        }
    }
}
