package com.finvizapi.webfinvizapi.service.LoadBeans.Stocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finvizapi.webfinvizapi.model.Stock;
import com.finvizapi.webfinvizapi.service.JsonPropertyExtractor;
import com.finvizapi.webfinvizapi.service.StockScrapingService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public LoadStocks(){}

    static void generateStockTickerJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();
        String[] technologyTickers = {
                "AAPL", "MSFT", "GOOGL", "AMZN", "META", "TSLA", "NVDA", "INTC", "ADBE", "PYPL",
                "CSCO", "CRM", "AMD", "NFLX", "SQ", "SHOP", "ZM", "UBER", "LYFT", "DOCU"
        };
        try {
            for (String ticker : technologyTickers) {
                ArrayList<String> keys = JsonPropertyExtractor.getPropertyNames(Stock.class);
                ArrayList<String> values = StockScrapingService.readStockTableAndReturnAllTableValues(ticker);
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
        } catch (Exception e) {
            e.printStackTrace();
            LOG.warning("Error creating JSON: " + e.getMessage());
        }
    }
}
