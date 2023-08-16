package com.finvizapi.webfinvizapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class SignalLeaders {

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
    private ArrayList<String> signal;

    public SignalLeaders(@JsonProperty("id") int id, @JsonProperty("ticker") String ticker,
            @JsonProperty("lastPrice") String lastPrice, @JsonProperty("change") String change,
            @JsonProperty("volume") String volume, @JsonProperty("signal") ArrayList<String> signal) {
        this.id = id;
        this.ticker = ticker;
        this.lastPrice = lastPrice;
        this.change = change;
        this.volume = volume;
        this.signal = signal;
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

    public ArrayList<String> getSignal() {
        return this.signal;
    }

    public void setSignal(ArrayList<String> signal) {
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
}
