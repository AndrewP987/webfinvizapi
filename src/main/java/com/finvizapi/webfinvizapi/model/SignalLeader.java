package com.finvizapi.webfinvizapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

public class SignalLeader {

    @JsonProperty("id")
    private int id;

    @JsonProperty("ticker")
    private String ticker;

    @JsonProperty("last")
    private String lastPrice;

    @JsonProperty("change")
    private String change;

    @JsonProperty("volume")
    private String volume;

    @JsonProperty("signal")
    private String signal;

    public SignalLeader(@JsonProperty("ticker") String ticker,
            @JsonProperty("lastPrice") String lastPrice, @JsonProperty("change") String change,
            @JsonProperty("volume") String volume, @JsonProperty("signal") String signal) {
        this.ticker = ticker;
        this.lastPrice = lastPrice;
        this.change = change;
        this.volume = volume;
        this.signal = signal;
    }

    public SignalLeader(@JsonProperty("id") int id, @JsonProperty("ticker") String ticker,
            @JsonProperty("lastPrice") String lastPrice, @JsonProperty("change") String change,
            @JsonProperty("volume") String volume, @JsonProperty("signal") String signal) {
        this.id = id;
        this.ticker = ticker;
        this.lastPrice = lastPrice;
        this.change = change;
        this.volume = volume;
        this.signal = signal;
    }

    public SignalLeader(SignalLeader other) {
        this.id = other.id;
        this.ticker = other.ticker;
        this.lastPrice = other.lastPrice;
        this.change = other.change;
        this.volume = other.volume;
        this.signal = other.signal;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return this.ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getLastPrice() {
        return this.lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getChange() {
        return this.change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSignal() {
        return this.signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", ticker='" + getTicker() + "'" +
                ", lastPrice='" + getLastPrice() + "'" +
                ", change='" + getChange() + "'" +
                ", volume='" + getVolume() + "'" +
                ", signal='" + getSignal() + "'" +
                "}";
    }

    public JsonNode JSONObject() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("id", getId());
        node.put("ticker", getTicker());
        node.put("lastPrice", getLastPrice());
        node.put("change", getChange());
        node.put("volume", getVolume());
        node.put("signal", getSignal());
        return node;
    }

}
