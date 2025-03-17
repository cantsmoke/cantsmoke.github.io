package com.mycompany.mavenproject1;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;

import java.util.*;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.util.Pair;

public class StatisticsCalculator {
    private List<List<Double>> samples;
    private static double confidenceLevel = 0.05;
    private static double alpha = 1- confidenceLevel;
    private static double tailProbability = alpha/2;
    
    public StatisticsCalculator(List<List<Double>> samples) {
        this.samples = new ArrayList<>(samples);
    }

    public double calculateGeometricMean(List<Double> sample) {
        return StatUtils.geometricMean(toDoubleArray(sample));
    }

    public double calculateArithmeticMean(List<Double> sample) {
        return StatUtils.mean(toDoubleArray(sample));
    }

    public double calculateStandardDeviation(List<Double> sample) {
        double[] array = toDoubleArray(sample);
        return Math.sqrt(StatUtils.variance(array));
    }

    public double calculateRange(List<Double> sample) {
        double[] array = toDoubleArray(sample);
        return StatUtils.max(array) - StatUtils.min(array);
    }

    public double calculateCovariance(List<Double> sample1, List<Double> sample2) {
        if (sample1.size() != sample2.size()) {
            throw new IllegalArgumentException("Размеры выборок должны совпадать");
        }
        Covariance covariance = new Covariance();
        return covariance.covariance(
                toDoubleArray(sample1),
                toDoubleArray(sample2)
        );
    }

    public double calculateCoefficientOfVariation(List<Double> sample) {
        double mean = calculateArithmeticMean(sample);
        double stdDev = calculateStandardDeviation(sample);
        return (stdDev / mean) * 100;
    }

    public Pair<Double, Double> calculateConfidenceInterval(List<Double> sample) {
        double mean = calculateArithmeticMean(sample);
        double stdDev = calculateStandardDeviation(sample);
        int sampleSize = sample.size();
        int degreesOfFreedom = sampleSize - 1;
        TDistribution tDist = new TDistribution(degreesOfFreedom);
        double quantile = tDist.inverseCumulativeProbability(1 - tailProbability); 
        double marginOfError = quantile * (stdDev / Math.sqrt(sampleSize));
        return new Pair<>(mean - marginOfError, mean + marginOfError);
    }

    public double calculateVariance(List<Double> sample) {
        return StatUtils.variance(toDoubleArray(sample));
    }

    public double findMax(List<Double> sample) {
        return StatUtils.max(toDoubleArray(sample));
    }

    public double findMin(List<Double> sample) {
        return StatUtils.min(toDoubleArray(sample));
    }
    
    public int calculateSampleSize(List<Double> sample) {
        return sample.size();
    }

    public Map<String, Double> calculateAllStatistics() {
        Map<String, Double> results = new LinkedHashMap<>();
        for (int i = 0; i < samples.size(); i++) {
            List<Double> sample = samples.get(i);
            String prefix = "Выборка " + (i + 1) + " - ";
            results.put(prefix + "Среднее геометрическое", calculateGeometricMean(sample));
            results.put(prefix + "Среднее арифметическое", calculateArithmeticMean(sample));
            results.put(prefix + "Оценка стандартного отклонения", calculateStandardDeviation(sample));
            results.put(prefix + "Размах", calculateRange(sample));
            results.put(prefix + "Коэффициент вариации", calculateCoefficientOfVariation(sample));
            results.put(prefix + "Оценка дисперсии", calculateVariance(sample));
            results.put(prefix + "Максимум", findMax(sample));
            results.put(prefix + "Минимум", findMin(sample));
            results.put(prefix + "Количество элементов", (double) calculateSampleSize(sample));
            Pair<Double, Double> confidenceInterval = calculateConfidenceInterval(sample);
            results.put(prefix + "доверительный интервал (нижняя граница)", confidenceInterval.getKey());
            results.put(prefix + "доверительный интервал (верхняя граница)", confidenceInterval.getValue());
        }
        for (int i = 0; i < samples.size(); i++) {
            for (int j = i; j < samples.size(); j++) {
                String key = "Коэффициент ковариации  (Выборка " + (i + 1) + ", Выборка " + (j + 1) + ")";
                results.put(key, calculateCovariance(samples.get(i), samples.get(j)));
            }
        }
        for (int i = 0; i < samples.size(); i++) {
            for (int j = i + 1; j < samples.size(); j++) {
                String key = "Коэффициент ковариации  (Выборка " + (j + 1) + ", Выборка " + (i + 1) + ")";
                results.put(key, calculateCovariance(samples.get(j), samples.get(i)));
            }
        }
        return results;
    }
    
    private double[] toDoubleArray(List<Double> sample) {
        double[] array = new double[sample.size()];
        for (int i = 0; i < sample.size(); i++) {
            array[i] = sample.get(i);
        }
        return array;
    }
    
}

