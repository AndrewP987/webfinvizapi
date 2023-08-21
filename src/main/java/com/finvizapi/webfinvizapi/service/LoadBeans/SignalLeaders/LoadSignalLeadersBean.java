package com.finvizapi.webfinvizapi.service.LoadBeans.SignalLeaders;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LoadSignalLeadersBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        // Call the method to generate the JSON file
        LoadSignalLeaders.generateSignalLeaderJson(("./webfinvizapi/src/main/data/SignalLeaders.json"));
    }
}
