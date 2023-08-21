package com.finvizapi.webfinvizapi.service.LoadBeans.SignalLeaders;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finvizapi.webfinvizapi.model.SignalLeader;
import com.finvizapi.webfinvizapi.model.Stock;
import com.finvizapi.webfinvizapi.service.FinvizScrapingService;
import com.finvizapi.webfinvizapi.service.LoadBeans.Stocks.LoadStocks;

public class LoadSignalLeaders {
    private static final Logger LOG = Logger.getLogger(LoadSignalLeaders.class.getName());

    static int stockId = 0;

    public LoadSignalLeaders() {
    }

    static void generateSignalLeaderJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        try {
            ArrayList<SignalLeader> signalLeaders = FinvizScrapingService.getSignalLeaders();

            for (SignalLeader currSignalLeader : signalLeaders) {
                jsonArray.add(currSignalLeader.JSONObject());
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
