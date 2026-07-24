import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Route {
        int totalTime;
        int count;

        Route(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    HashMap<Integer, CheckIn> checkInMap;
    HashMap<String, Route> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn info = checkInMap.get(id);

        String route = info.station + "->" + stationName;
        int travelTime = t - info.time;

        Route data = routeMap.getOrDefault(route, new Route(0, 0));
        data.totalTime += travelTime;
        data.count++;

        routeMap.put(route, data);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        Route data = routeMap.get(route);

        return (double) data.totalTime / data.count;
    }
}
