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

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StockScrapingService {

    public static void main(String[] args) {
        // ArrayList<String> stockNames = StockScrapingService.getSignalLeaders();
        ArrayList<String> stockNames = StockScrapingService.getSignalLosers();
    }

    private static final Logger LOG = Logger.getLogger(StockScrapingService.class.getName());

    static String baseStockURL = "https://finviz.com/quote.ashx?t=%s&p=d";
    static String frontPageURL = "https://finviz.com/";

    static synchronized ArrayList<String> getSignalLosers() {
        ArrayList<String> res = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(frontPageURL).get();
            Element table = doc.getElementById("js-signals_2");
            Elements rows = table.select("tr");

            for (int currRow = 1; currRow < rows.size(); currRow++) {
                Element row = rows.get(currRow);
                Elements cells = row.select("td");

                String currTicker = cells.get(0).select("a").last().text();
                String tickerLast = cells.get(1).text();
                String tickerChange = cells.get(2).text();
                String tickerVolume = cells.get(3).text();
                String tickerSignal = cells.get(5).select("a").text();

                LOG.info("currTicker: " + currTicker);
                LOG.info("tickerLast: " + tickerLast);
                LOG.info("tickerChange: " + tickerChange);
                LOG.info("tickerVolume: " + tickerVolume);
                LOG.info("tickerSignal: " + tickerSignal);
                LOG.info("\n");

                res.add(currTicker);
            }

            return res;
        } catch (Exception e) {
            e.printStackTrace();
            LOG.warning("Error fetching stock data or creating JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    static synchronized ArrayList<String> getSignalLeaders() {
        ArrayList<String> res = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(frontPageURL).get();
            Element table = doc.getElementsByClass("t-home-table table-empty-rounded-separate").first();
            Elements rows = table.select("tr");

            for (int currRow = 1; currRow < rows.size(); currRow++) {
                Element row = rows.get(currRow);
                Elements cells = row.select("td");

                String currTicker = cells.get(0).select("a").last().text();
                String tickerLast = cells.get(1).text();
                String tickerChange = cells.get(2).text();
                String tickerVolume = cells.get(3).text();
                String tickerSignal = cells.get(5).select("a").text();

                LOG.info("currTicker: " + currTicker);
                LOG.info("tickerLast: " + tickerLast);
                LOG.info("tickerChange: " + tickerChange);
                LOG.info("tickerVolume: " + tickerVolume);
                LOG.info("tickerSignal: " + tickerSignal);
                LOG.info("\n");

                res.add(currTicker);
            }

            return res;
        } catch (Exception e) {
            e.printStackTrace();
            LOG.warning("Error fetching stock data or creating JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    static synchronized ArrayList<String> writeTableDataToJsonFile(String ticker) {
        ArrayList<String> res = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(String.format(baseStockURL, ticker)).get();
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
            LOG.warning("Error fetching stock data or creating JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
