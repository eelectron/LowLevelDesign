package logger;

public class DBWriter implements Logger{

	@Override
	public void log(String text, Enum level) {
		// TODO Auto-generated method stub
		System.out.println("Write to database");
	}
}