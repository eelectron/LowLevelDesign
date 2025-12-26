package log_system;

import java.util.*;

class LogSystem {
    // keep timestamp sorted
    private TreeMap<TimeStamp, List<Integer>> timestamps;

    private final String MIN_TIMESTAMP = "2000:01:01:00:00:00";
    private final String MAX_TIMESTAMP = "2017:12:31:23:59:59";
    private Map<String, Integer> granularityMap = Map.of(
        "Year", 4,
        "Month", 7,
        "Day", 10,
        "Hour", 13,
        "Minute", 16,
        "Second", 19
    );

    public LogSystem() {
        timestamps = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        // create a new timestamp object and add it to the set
        TimeStamp ts = new TimeStamp(timestamp);

        timestamps.putIfAbsent(ts, new java.util.ArrayList<>());
        timestamps.get(ts).add(id);
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        int granularityIndex = granularityMap.get(granularity);
        // adjust start and end timestamps based on the granularity
        start = start.substring(0, granularityIndex) + MIN_TIMESTAMP.substring(granularityIndex);
        end = end.substring(0, granularityIndex) + MAX_TIMESTAMP.substring(granularityIndex);

        // create start and end timestamp objects based on the granularity
        TimeStamp startTs = new TimeStamp(start);
        TimeStamp endTs = new TimeStamp(end);

        // retrieve all timestamps in the range [startTs, endTs]
        List<Integer> result = new java.util.ArrayList<>();
        NavigableMap<TimeStamp, List<Integer>> subMap = timestamps.subMap(startTs, true, endTs, true);
        for (Map.Entry<TimeStamp, List<Integer>> entry: subMap.entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }
}

class TimeStamp implements Comparable<TimeStamp> {
    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;

    TimeStamp(String timestamp) {
        String[] parts = timestamp.split(":");
        this.year = Integer.parseInt(parts[0]);
        this.month = Integer.parseInt(parts[1]);
        this.day = Integer.parseInt(parts[2]);
        this.hour = Integer.parseInt(parts[3]);
        this.minute = Integer.parseInt(parts[4]);
        this.second = Integer.parseInt(parts[5]);
    }

    @Override
    public int compareTo(TimeStamp o) {
        if (this.year != o.year) {
            return this.year - o.year;
        }

        if (this.month != o.month) {
            return this.month - o.month;
        }

        if (this.day != o.day) {
            return this.day - o.day;
        }

        if (this.hour != o.hour) {
            return this.hour - o.hour;
        }

        if (this.minute != o.minute) {
            return this.minute - o.minute;
        }

        if (this.second != o.second) {
            return this.second - o.second;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return year * 100000000 + month * 1000000 + day * 10000 + hour * 100 + minute * 10 + second;
    }
}
/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
