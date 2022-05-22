package scaler.design.logger;

import java.security.DomainCombiner;
import java.util.ArrayList;
import java.util.List;

public class Client {
	
	public static void main(String[] args) {
		Logger db = new DBWriter();
		Logger con = new ConsoleWriter();
		
		List<Logger> logs = new ArrayList<>();
		logs.add(db);
		logs.add(con);
		
		printLog(logs);
	}
	
	private static void printLog(List<Logger> list) {
		int i = 0;
		for(Logger logger: list) {
			logger.log("hi " + i, Level.INFO);
			i += 1;
		}
	}
}
