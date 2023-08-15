package com.finvizapi.webfinvizapi.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StockScrapingService {

    static String baseUrl = "https://finviz.com/quote.ashx?t=%s&p=d";

    private String ticker;
    private String stockUrl;
    private HashMap<String, String> stockValues;

    // public StockScrapingService(String ticker) {
    //     this.ticker = ticker;
    //     this.stockValues = new HashMap<>();
    //     this.stockUrl = String.format(baseUrl, this.ticker);
    //     // this.stockValues = this.getTableData();
    //     for (Entry<String, String> entry : this.stockValues.entrySet()) {
    //         System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
    //     }
    // }

    public String getTicker() {
        return this.ticker;
    }

    public String getStockUrl() {
        return this.stockUrl;
    }

    private void writeTableDataToJsonFile(String filePath) {
        HashMap<String, String> res = new HashMap<>();
        try {
            Document doc = Jsoup.connect(this.getStockUrl()).get();
            Elements table = doc.getElementsByClass("snapshot-table2");
            Elements rows = table.select("tr");
            int currWidth;
            StringBuilder currHeader = new StringBuilder();
            StringBuilder currValue = new StringBuilder();
            for (Element row : rows) {
                Elements cells = row.select("td");
                for (int i = 0; i < cells.size(); i++) {
                    Element cell = cells.get(i);
                    currWidth = Integer.valueOf(cells.get(i).attr("width").split("%")[0]);
                    if (currWidth == 7) {
                        currHeader.append(cell.text());
                    } else if (currWidth == 8) {
                        currValue.append(cell.text());
                        System.out.println("currHeader: " + currHeader + " ,currValue: " + currValue);
                        res.put(currHeader.toString(), currValue.toString());
                        currHeader.setLength(0);
                        currValue.setLength(0);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error fetching stock data or creating JSON: " + e.getMessage());
        }
    }


}
