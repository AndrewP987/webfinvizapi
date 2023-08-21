package com.finvizapi.webfinvizapi.persistence;

import java.io.IOException;

import com.finvizapi.webfinvizapi.model.SignalLoser;

public interface SignalLoserDAO {

    SignalLoser[] getSignalLosers() throws IOException;

    SignalLoser[] findSignalLoser(String containsText) throws IOException;

    SignalLoser getSignalLoser(int id) throws IOException;

    SignalLoser createSignalLoser(SignalLoser SignalLoser) throws IOException;

    SignalLoser updateSignalLoser(SignalLoser SignalLoser) throws IOException;

    boolean deleteSignalLoser(int id) throws IOException;

}
