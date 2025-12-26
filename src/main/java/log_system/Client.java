package log_system;

import java.util.List;

public class Client {
    static void main() {
        /**
         * [[],[1,"2017:01:01:23:59:59"],[2,"2017:01:01:22:59:59"],[3,"2016:01:01:00:00:00"],
         * [4,"2017:01:01:22:59:59"],["2016:01:01:01:01:01","2017:01:01:23:00:00","Year"],
         * ["2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"]]
         */
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");
        logSystem.put(4, "2017:01:01:22:59:59");

        List<Integer> result1 = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
        List<Integer> result2 = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");

        System.out.println(result1); // Expected: [1, 2, 3, 4]
        System.out.println(result2); // Expected: [2, 4]
    }
}
