package com.finvizapi.webfinvizapi.service.LoadBeans.SignalLosers;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LoadSignalLosersBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        // Call the method to generate the JSON file
        LoadSignalLosers.generateSignalLoserJson(("./webfinvizapi/src/main/data/SignalLosers.json"));
    }
}
