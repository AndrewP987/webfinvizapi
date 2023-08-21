package com.finvizapi.webfinvizapi.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.finvizapi.webfinvizapi.model.SignalLeader;
import com.finvizapi.webfinvizapi.persistence.SignalLeaderDAO;

@RestController
@RequestMapping("api/signalLeader")
public class SignalLeaderController {
    private static final Logger log = Logger.getLogger(SignalLeaderController.class.getName());
    private final SignalLeaderDAO signalLeaderDAO;

    public SignalLeaderController(SignalLeaderDAO signalLeaderDAO) {
        this.signalLeaderDAO = signalLeaderDAO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignalLeader> getSignalLeader(@PathVariable int id) {
        log.info("GET /api/signalLeader/" + id);
        try {
            SignalLeader signalLeader = this.signalLeaderDAO.getSignalLeader(id);
            if (signalLeader != null) {
                return new ResponseEntity<>(signalLeader, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<SignalLeader[]> getSignalLeaders() {
        log.info("GET /api/signalLeader/all");

        try {
            SignalLeader[] signalLeaders = this.signalLeaderDAO.getSignalLeaders();
            if (signalLeaders.length > 0) {
                return new ResponseEntity<>(signalLeaders, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<SignalLeader[]> findSignalLeader(@RequestParam String name) {
        log.info("GET /api/signalLeader/?name=" + name);

        try {
            SignalLeader[] signalLeaders = this.signalLeaderDAO.findSignalLeader(name);
            if (signalLeaders != null) {
                return new ResponseEntity<>(signalLeaders, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<SignalLeader> createSignalLeader(@RequestBody SignalLeader signalLeader) {
        log.info("POST /api/signalLeader " + signalLeader);

        try {
            SignalLeader createdLeader = this.signalLeaderDAO.createSignalLeader(signalLeader);
            if (createdLeader == null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity<>(createdLeader, HttpStatus.CREATED);
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<SignalLeader> updateSignalLeader(@RequestBody SignalLeader signalLeader) {
        log.info("PUT /api/signalLeader " + signalLeader);

        try {
            SignalLeader updatedLeader = this.signalLeaderDAO.updateSignalLeader(signalLeader);
            if (updatedLeader != null) {
                return new ResponseEntity<>(updatedLeader, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SignalLeader> deleteSignalLeader(@PathVariable int id) {
        log.info("DELETE /api/signalLeader/" + id);

        try {
            boolean isDeleted = this.signalLeaderDAO.deleteSignalLeader(id);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
