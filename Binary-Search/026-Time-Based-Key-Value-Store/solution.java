import java.util.*;

class TimeMap {

    // key -> (timestamp -> value)
    // TreeMap is based on a balaned Red-Black tree (sorted by default)
    private Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new TreeMap<>());
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> map = timeMap.get(key);

        // largest timestamp <= given timestamp
        Integer floorKey = map.floorKey(timestamp);

        if (floorKey == null) {
            return "";
        }

        return map.get(floorKey);
    }
}