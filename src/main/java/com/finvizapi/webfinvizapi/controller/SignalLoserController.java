package com.finvizapi.webfinvizapi.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

import com.finvizapi.webfinvizapi.model.SignalLoser;
import com.finvizapi.webfinvizapi.persistence.SignalLoserDAO;

@RestController
@RequestMapping("api/stockLoser")
public class SignalLoserController {
    private static final Logger LOG = Logger.getLogger(SignalLoserController.class.getName());
    private SignalLoserDAO signalLoserDAO;

    public SignalLoserController(SignalLoserDAO signalLoserDAO) {
        this.signalLoserDAO = signalLoserDAO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignalLoser> getSignalLoser(@PathVariable int id) {
        LOG.info("GET /api/stockLoser/" + id);
        try {
            SignalLoser signalLoser = this.signalLoserDAO.getSignalLoser(id);
            if (signalLoser != null) {
                return new ResponseEntity<>(signalLoser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<SignalLoser[]> getSignalLosers() {
        LOG.info("GET /api/stockLoser/all");

        try {
            SignalLoser[] signalLosers = this.signalLoserDAO.getSignalLosers();
            if (signalLosers.length > 0) {
                return new ResponseEntity<>(signalLosers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<SignalLoser[]> findSignalLoser(@RequestParam String name) {
        LOG.info("GET /api/stockLoser/?name=" + name);

        try {
            SignalLoser[] signalLosers = this.signalLoserDAO.findSignalLoser(name);
            if (signalLosers != null) {
                return new ResponseEntity<>(signalLosers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<SignalLoser> createSignalLoser(@RequestBody SignalLoser signalLoser) {
        LOG.info("POST /api/stockLoser " + signalLoser);

        try {
            SignalLoser createdLoser = this.signalLoserDAO.createSignalLoser(signalLoser);
            if (createdLoser == null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity<>(createdLoser, HttpStatus.CREATED);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<SignalLoser> updateSignalLoser(@RequestBody SignalLoser signalLoser) {
        LOG.info("PUT /api/stockLoser " + signalLoser);

        try {
            SignalLoser signalLoserUpdated = this.signalLoserDAO.updateSignalLoser(signalLoser);
            if (signalLoserUpdated != null) {
                return new ResponseEntity<>(signalLoserUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SignalLoser> deleteSignalLoser(@PathVariable int id) {
        LOG.info("DELETE /api/stockLoser/" + id);

        try {
            boolean isDeleted = this.signalLoserDAO.deleteSignalLoser(id);
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
