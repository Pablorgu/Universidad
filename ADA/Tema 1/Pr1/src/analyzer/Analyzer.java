package analyzer;

import java.util.Arrays;

public class Analyzer implements Runnable {
    Algorithm algorithm;
    long maxExecutionTime;
    String complexity = null;

    public Analyzer(Algorithm algorithm, long maxExecutionTime) {
        this.algorithm = algorithm;
        this.maxExecutionTime = maxExecutionTime;
    }

    public String getComplexity() {
        return complexity;
    }

    @Override
    public void run() {
        complexity = findComplexityOf(algorithm, maxExecutionTime);
    }


    public static void initializeTimes(long[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = Long.MAX_VALUE;
        }
    }

    public static double calculateRatio(Algorithm algorithm, double[] n1, double[] n2, long maxTime) {
        Chronometer elapsedTime = new Chronometer();
        elapsedTime.stop();
        Chronometer totalTime = new Chronometer();
        totalTime.stop();
        int size = n1.length;
        double[] ratios = new double[size];
        long[] minTimes = new long[size];
        long[] maxTimes = new long[size];
        double ratio_aux = 0.0;

        initializeTimes(minTimes);
        initializeTimes(maxTimes);

        maxTime = (long) maxTime - (maxTime / 4);

        totalTime.start();
        for (int i = 0; totalTime.getElapsedTime() < maxTime && i < 6; i++) {
            for (int j = 0; totalTime.getElapsedTime() < maxTime && j < size; j++) {

                algorithm.init((long) n1[j]);
                elapsedTime.start();
                algorithm.run();
                elapsedTime.stop();
                long time1 = elapsedTime.getElapsedTime();
                minTimes[j] = Math.min(minTimes[j], time1);
                algorithm.init((long) n2[j]);
                elapsedTime.start();
                algorithm.run();
                elapsedTime.stop();

                long time2 = elapsedTime.getElapsedTime();
                maxTimes[j] = Math.min(maxTimes[j], time2);


                if (minTimes[j] != 0) {
                    ratio_aux = (double) maxTimes[j] / (double) minTimes[j];
                }

                if (ratio_aux >= 10) {
                    System.out.println("El algoritmo supera el tiempo maximo permitido");
                    break;
                }
            }
        }
        for (int j = 0; j < ratios.length; j++) {
            if (minTimes[j] != 0 && minTimes[j] != Long.MAX_VALUE) {
                ratios[j] = (double) maxTimes[j] / (double) minTimes[j];
            }
        }


        double mean = calculateMean(ratios);
        totalTime.stop();
        return mean;
    }

    public static double calculateMean(double[] values) {
        int counter = 0;
        double sum = 0;
        for (double value : values) {
            if(value != 0) {
                sum += value;
                counter++;
            }
        }
        if(counter>0) {
            return sum / counter;
        }
        return sum / values.length;
    }

    static String findComplexityOf(Algorithm algorithm, long maxExecutionTime) {

        double[] setSize = {10, 20, 60, 100, 200, 400, 500};
        double[] doubleofsetSize = {20, 40, 120, 200, 400, 800, 1000};


        double ratio = calculateRatio(algorithm, setSize, doubleofsetSize, maxExecutionTime);
        String complexity = determineComplexity(ratio);

        return complexity;
    }

    private static String determineComplexity(double ratio) {
        String complexity = null;
        if (ratio <= 1 && ratio > 0.2) {
            complexity = "1";
        } else if (ratio > 1 && ratio < 1.2) {
            complexity = "log(n)";
        } else if (ratio >= 1.2 && ratio < 2.02) {
            complexity = "n";
        } else if (ratio >= 2.02 && ratio < 2.5) {
            complexity = "n*log(n)";
        } else if (ratio >= 2.5 && ratio <= 4) {
            complexity = "n^2";
        } else if (ratio > 4 && ratio < 8) {
            complexity = "n^3";
        } else{
            complexity = "2^n";
        }
return complexity;
    }
}