package com.finvizapi.webfinvizapi.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class Converter {

    private HashMap<String, String> conversionStorage;

    public Converter() {
        this.conversionStorage = this.getAllConversions();
    }

    public HashMap<String, String> getAllConversions() {
        HashMap<String, String> conveMap = new HashMap<>();
        
        return conveMap;
    }

}
