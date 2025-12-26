package scaler.design;
/**
 * Using this temporary class for autocompletion purpose
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class LeetCode {
}

class UndergroundSystem {
    private Map<String, Map<Integer, List<Integer>>> checkIn;
    private Map<String, Map<Integer, List<Integer>>> checkOut;
    public UndergroundSystem() {
        checkIn = new HashMap<>();
        checkOut = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        // get passengers of station
        Map<Integer, List<Integer>> passengers = checkIn.get(stationName);
        if(passengers == null){
            passengers = new HashMap<>();
            checkIn.put(stationName, passengers);
        }

        // get passenger's times
        List<Integer> times = passengers.get(id);
        if(times == null){
            times = new ArrayList<>();
            passengers.put(id, times);
        }
        times.add(t);
    }

    public void checkOut(int id, String stationName, int t) {
        // get passengers of station
        Map<Integer, List<Integer>> passengers = checkOut.get(stationName);
        if(passengers == null) {
            passengers = new HashMap<>();
            checkOut.put(stationName, passengers);
        }

        // get passenger's times
        List<Integer> times = passengers.get(id);
        if(times == null){
            times = new ArrayList<>();
            passengers.put(id, times);
        }
        times.add(t);
    }

    public double getAverageTime(String startStation, String endStation) {
        // get passengers of startStation from checkIn
        Map<Integer, List<Integer>> startPassengers = checkIn.get(startStation);

        // get passengers of endStation from checkOut
        Map<Integer, List<Integer>> endPassengers = checkOut.get(endStation);

        double totalTime = 0;
        int count = 0;

        // calculate total time for all passengers
        for(Map.Entry<Integer, List<Integer>> entry : startPassengers.entrySet()) {
            int id = entry.getKey();
            List<Integer> checkInTimes = entry.getValue();
            List<Integer> checkOutTimes = endPassengers.getOrDefault(id, new ArrayList<>());
            double[] info = getTotalTravelTime(checkInTimes, checkOutTimes);
            totalTime += info[0];
            count += (int)info[1];
        }

        double averageTime = totalTime / count;
        return averageTime;
    }

    private double[] getTotalTravelTime(List<Integer> checkInTimes, List<Integer> checkOutTimes) {
        double totalTime = 0;
        int n = Math.min(checkInTimes.size(), checkOutTimes.size());
        for(int i = 0; i < n; i++) {
            totalTime += (checkOutTimes.get(i) - checkInTimes.get(i));
        }
        return new double[]{totalTime, n};
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
