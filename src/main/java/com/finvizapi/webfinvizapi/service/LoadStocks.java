package com.finvizapi.webfinvizapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.EnvironmentAccessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoadStocks {


    // public static void main(String[] args) {
    //     generateStockTickerJson("/Users/andrewphotinakis/Documents/FinvizAPI/webfinvizapi/src/main/data/stocks.json");
    // }

    static void generateStockTickerJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        String[] technologyTickers = {
                "AAPL", "MSFT", "GOOGL", "AMZN", "FB", "TSLA", "NVDA", "INTC", "ADBE", "PYPL",
                "CSCO", "CRM", "AMD", "NFLX", "SQ", "SHOP", "ZM", "UBER", "LYFT", "DOCU"
        };

        String[] spaceDefenseTickers = {
                "BA", "LMT", "RTX", "NOC", "HON", "GD", "LHX", "UTX", "TDY", "KTOS",
                "LORL", "SPCE", "MAXR", "AJRD", "OSK", "HEI", "TDG", "BE", "ASTC", "NANR"
        };

        try {
            for (String ticker : technologyTickers) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                jsonObject.put("ticker", ticker);
                jsonArray.add(jsonObject);
            }

            for (String ticker : spaceDefenseTickers) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                jsonObject.put("ticker", ticker);
                jsonArray.add(jsonObject);
            }

            // Write JSON array to a file
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(jsonArray.toString());
                System.out.println("JSON data has been written to the file: " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error writing JSON data to file: " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error creating JSON: " + e.getMessage());
        }
    }

}
