import java.util.*;

class UndergroundSystem {
    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, TravelStats> travelStats;
    
    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelStats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.get(id);
        checkIns.remove(id);
        
        String key = info.stationName + "->" + stationName;
        int travelTime = t - info.time;
        
        TravelStats stats = travelStats.getOrDefault(key, new TravelStats());
        stats.totalTime += travelTime;
        stats.count += 1;
        travelStats.put(key, stats);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        TravelStats stats = travelStats.get(key);
        return (double) stats.totalTime / stats.count;
    }
    
    private static class CheckInInfo {
        String stationName;
        int time;
        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    private static class TravelStats {
        int totalTime;
        int count;
    }
    
    // Quick test
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // 14.0
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.0
        
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 12.0
    }
}
