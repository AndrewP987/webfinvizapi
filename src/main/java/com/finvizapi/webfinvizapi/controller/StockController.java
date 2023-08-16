package com.finvizapi.webfinvizapi.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finvizapi.webfinvizapi.model.Stock;
import com.finvizapi.webfinvizapi.persistence.StockDAO;

@RestController
@RequestMapping("api/stock")
public class StockController {
    private static final Logger LOG = Logger.getLogger(StockController.class.getName());
    private StockDAO stockDAO;

    public StockController(StockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStock(@PathVariable int id) {
        LOG.info("GET /api/stock" + id);
        try {
            Stock stock = stockDAO.getStock(id);
            if (stock != null) {
                return new ResponseEntity<Stock>(stock, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Stock[]> getStocks() {
        LOG.info("GET /api/stock/all");

        try {
            Stock[] stocks = stockDAO.getStocks();
            if (stocks.length > 0) {
                return new ResponseEntity<Stock[]>(stocks, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Stock[]> searchStocks(@RequestParam String name) {
        LOG.info("GET /api/stock/?name=" + name);

        try {
            Stock[] userNames = stockDAO.findStock(name);
            if (userNames != null) {
                return new ResponseEntity<Stock[]>(userNames, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        LOG.info("POST /api/stock " + stock);

        try {
            Stock createdStock = stockDAO.createStock(stock);
            if (createdStock == null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity<Stock>(createdStock, HttpStatus.CREATED);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
        LOG.info("PUT /api/stock " + stock);

        try {
            Stock stockUpdated = stockDAO.updateStock(stock);
            if (stockUpdated != null) {
                return new ResponseEntity<>(stockUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Stock> deleteStock(@PathVariable int id) {
        LOG.info("DELETE /api/stock/" + id);

        try {
            boolean isDeleted = stockDAO.deleteStock(id);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
