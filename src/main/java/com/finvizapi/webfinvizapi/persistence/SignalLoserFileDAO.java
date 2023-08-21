package com.finvizapi.webfinvizapi.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finvizapi.webfinvizapi.model.SignalLoser;

@Component
public class SignalLoserFileDAO implements SignalLoserDAO {
    private static final Logger LOG = Logger.getLogger(SignalLoserFileDAO.class.getName());
    HashMap<Integer, SignalLoser> SignalLoserMap;

    private ObjectMapper objectMapper;

    private static int nextId;
    private String filename;

    public SignalLoserFileDAO(@Value("${SignalLosers.file}") String filename, ObjectMapper objectMapper)
            throws IOException {
        this.filename = filename;
        this.objectMapper = objectMapper;
        load();
    }

    private synchronized static int nextSignalLoserId() throws IOException {
        int id = nextId;
        ++nextId;
        return id;
    }

    private boolean save() throws IOException {
        SignalLoser[] SignalLoserArray = getSignalLoserArray();
        objectMapper.writeValue(new File(filename), SignalLoserArray);
        return true;
    }

    private boolean load() throws IOException {
        SignalLoserMap = new HashMap<>();
        nextId = 0;

        SignalLoser[] SignalLoserArray = objectMapper.readValue(new File(filename), SignalLoser[].class);
        for (SignalLoser currSignalLoser : SignalLoserArray) {
            SignalLoserMap.put(currSignalLoser.getId(), currSignalLoser);
            if (currSignalLoser.getId() > nextId) {
                nextId = currSignalLoser.getId();
            }
        }
        ++nextId;
        return true;
    }

    private SignalLoser[] getSignalLoserArray() {
        return getSignalLoserArray(null);
    }

    private SignalLoser[] getSignalLoserArray(String containsText) {
        ArrayList<SignalLoser> SignalLoserArrayList = new ArrayList<>();

        for (SignalLoser SignalLoser : SignalLoserMap.values()) {
            if (containsText == null || SignalLoser.getTicker().contains(containsText)) {
                SignalLoserArrayList.add(SignalLoser);
            }
        }
        SignalLoser[] SignalLoserArray = new SignalLoser[SignalLoserArrayList.size()];
        SignalLoserArrayList.toArray(SignalLoserArray);
        return SignalLoserArray;
    }

    @Override
    public SignalLoser[] getSignalLosers() throws IOException {
        synchronized (SignalLoserMap) {
            return getSignalLoserArray();
        }
    }

    @Override
    public SignalLoser[] findSignalLoser(String containsText) throws IOException {
        synchronized (SignalLoserMap) {
            return getSignalLoserArray(containsText);
        }
    }

    @Override
    public SignalLoser getSignalLoser(int id) throws IOException {
        synchronized (SignalLoserMap) {
            if (SignalLoserMap.containsKey(id)) {
                return SignalLoserMap.get(id);
            } else {
                return null;
            }
        }
    }

    @Override
    public SignalLoser createSignalLoser(SignalLoser SignalLoser) throws IOException {
        synchronized (SignalLoserMap) {
            SignalLoser newSignalLoser = new SignalLoser(SignalLoser);
            if (SignalLoserMap.containsValue(newSignalLoser)) {
                return null;
            }
            newSignalLoser.setId(nextId);
            SignalLoserMap.put(newSignalLoser.getId(), newSignalLoser);
            save();
            return newSignalLoser;
        }
    }

    @Override
    public SignalLoser updateSignalLoser(SignalLoser SignalLoser) throws IOException {
        synchronized (SignalLoserMap) {
            if (!SignalLoserMap.containsKey(SignalLoser.getId())) {
                return null;
            }
            SignalLoserMap.put(SignalLoser.getId(), SignalLoser);
            save();
            return SignalLoser;
        }
    }

    @Override
    public boolean deleteSignalLoser(int id) throws IOException {
        synchronized (SignalLoserMap) {
            if (SignalLoserMap.containsKey(id)) {
                SignalLoserMap.remove(id);
                return save();
            } else {
                return false;
            }
        }
    }

}
