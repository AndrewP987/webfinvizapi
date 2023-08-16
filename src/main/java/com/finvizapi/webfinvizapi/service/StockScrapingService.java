package com.finvizapi.webfinvizapi.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    static ArrayList<String> writeTableDataToJsonFile(String ticker) {
        ArrayList<String> res = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(String.format(baseUrl, ticker)).get();
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
                        res.add(currValue.toString());
                        currHeader.setLength(0);
                        currValue.setLength(0);
                    }
                }
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error fetching stock data or creating JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
