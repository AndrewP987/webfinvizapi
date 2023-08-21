package com.finvizapi.webfinvizapi.persistence;

import java.io.IOException;

import com.finvizapi.webfinvizapi.model.SignalLeader;

public interface SignalLeaderDAO {

    SignalLeader[] getSignalLeaders() throws IOException;

    SignalLeader[] findSignalLeader(String containsText) throws IOException;

    SignalLeader getSignalLeader(int id) throws IOException;

    SignalLeader createSignalLeader(SignalLeader SignalLeader) throws IOException;

    SignalLeader updateSignalLeader(SignalLeader SignalLeader) throws IOException;

    boolean deleteSignalLeader(int id) throws IOException;

}
