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
import com.finvizapi.webfinvizapi.model.SignalLeader;
import com.finvizapi.webfinvizapi.model.SignalLeader;
import com.finvizapi.webfinvizapi.model.SignalLeader;

@Component
public class SignalLeaderFileDAO implements SignalLeaderDAO {
    private static final Logger LOG = Logger.getLogger(SignalLeaderFileDAO.class.getName());
    HashMap<Integer, SignalLeader> SignalLeaderMap;

    private ObjectMapper objectMapper;

    private static int nextId;
    private String filename;

    public SignalLeaderFileDAO(@Value("${SignalLeaders.file}") String filename, ObjectMapper objectMapper)
            throws IOException {
        this.filename = filename;
        this.objectMapper = objectMapper;
        load();
    }

    private synchronized static int nextSignalLeaderId() throws IOException {
        int id = nextId;
        ++nextId;
        return id;
    }

    private boolean save() throws IOException {
        SignalLeader[] SignalLeaderArray = getSignalLeaderArray();
        objectMapper.writeValue(new File(filename), SignalLeaderArray);
        return true;
    }

    private boolean load() throws IOException {
        SignalLeaderMap = new HashMap<>();
        nextId = 0;

        SignalLeader[] SignalLeaderArray = objectMapper.readValue(new File(filename), SignalLeader[].class);
        for (SignalLeader currSignalLeader : SignalLeaderArray) {
            SignalLeaderMap.put(currSignalLeader.getId(), currSignalLeader);
            if (currSignalLeader.getId() > nextId) {
                nextId = currSignalLeader.getId();
            }
        }
        ++nextId;
        return true;
    }

    private SignalLeader[] getSignalLeaderArray() {
        return getSignalLeaderArray(null);
    }

    private SignalLeader[] getSignalLeaderArray(String containsText) {
        ArrayList<SignalLeader> SignalLeaderArrayList = new ArrayList<>();

        for (SignalLeader SignalLeader : SignalLeaderMap.values()) {
            if (containsText == null || SignalLeader.getTicker().contains(containsText)) {
                SignalLeaderArrayList.add(SignalLeader);
            }
        }
        SignalLeader[] SignalLeaderArray = new SignalLeader[SignalLeaderArrayList.size()];
        SignalLeaderArrayList.toArray(SignalLeaderArray);
        return SignalLeaderArray;
    }

    @Override
    public SignalLeader[] getSignalLeaders() throws IOException {
        synchronized (SignalLeaderMap) {
            return getSignalLeaderArray();
        }
    }

    @Override
    public SignalLeader[] findSignalLeader(String containsText) throws IOException {
        synchronized (SignalLeaderMap) {
            return getSignalLeaderArray(containsText);
        }
    }

    @Override
    public SignalLeader getSignalLeader(int id) throws IOException {
        synchronized (SignalLeaderMap) {
            if (SignalLeaderMap.containsKey(id)) {
                return SignalLeaderMap.get(id);
            } else {
                return null;
            }
        }
    }

    @Override
    public SignalLeader createSignalLeader(SignalLeader SignalLeader) throws IOException {
        synchronized (SignalLeaderMap) {
            SignalLeader newSignalLeader = new SignalLeader(SignalLeader);
            if (SignalLeaderMap.containsValue(newSignalLeader)) {
                return null;
            }
            newSignalLeader.setId(nextId);
            SignalLeaderMap.put(newSignalLeader.getId(), newSignalLeader);
            save();
            return newSignalLeader;
        }
    }

    @Override
    public SignalLeader updateSignalLeader(SignalLeader SignalLeader) throws IOException {
        synchronized (SignalLeaderMap) {
            if (!SignalLeaderMap.containsKey(SignalLeader.getId())) {
                return null;
            }
            SignalLeaderMap.put(SignalLeader.getId(), SignalLeader);
            save();
            return SignalLeader;
        }
    }

    @Override
    public boolean deleteSignalLeader(int id) throws IOException {
        synchronized (SignalLeaderMap) {
            if (SignalLeaderMap.containsKey(id)) {
                SignalLeaderMap.remove(id);
                return save();
            } else {
                return false;
            }
        }
    }

}
