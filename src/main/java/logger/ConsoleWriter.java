package logger;

public class ConsoleWriter implements Logger{

	@Override
	public void log(String text, Enum level) {
		// TODO Auto-generated method stub
		System.out.println("text : " + text);
	}

}
