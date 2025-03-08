package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {
    private List<List<Double>> samples;
    private Map<String, Double> calculatedStatistics;

    public DataStorage() {
        this.samples = new ArrayList<>();
    }

    public void storeData(List<List<Double>> data) {
        this.samples = new ArrayList<>(data);
    }

    public List<List<Double>> getData() {
        return new ArrayList<>(samples);
    }

    public int getSampleCount() {
        return samples.size();
    }
    
    public void storeCalculatedStatistics(Map<String, Double> statistics) {
        this.calculatedStatistics = new HashMap<>(statistics);
    }

    public Map<String, Double> getCalculatedStatistics() {
        return new HashMap<>(calculatedStatistics);
    }
}
