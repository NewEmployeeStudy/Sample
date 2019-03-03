package application.common;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogUtil {
	ResourceBundle rb = null;
	Logger logger = null;

	public void log(String str) {
		try {
			FileHandler fHandler = new FileHandler(rb.getString("LOG"), true);
			fHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fHandler);
			logger.info(str);
			fHandler.close();
		} catch (IOException e) {

		}
	}

	public void log(Level lv, String str, Throwable th) {
		try {
			FileHandler fHandler = new FileHandler(rb.getString("LOG"), true);
			fHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fHandler);
			//なぜかスタックトレースがでない。。。
			//logger.log(lv, str, th);
			StringBuilder sbr = new StringBuilder();
			String line = System.getProperty("line.separator");
			sbr.append(str);
			sbr.append(line);
			for (StackTraceElement el : th.getStackTrace()) {
				sbr.append(el.toString());
				sbr.append(line);
			}
			logger.log(lv, sbr.toString());
			fHandler.close();
		} catch (IOException e) {

		}
	}

	public LogUtil() {
		rb = ResourceBundle.getBundle("java");
		logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		logger.setLevel(Level.INFO);
	}
}
