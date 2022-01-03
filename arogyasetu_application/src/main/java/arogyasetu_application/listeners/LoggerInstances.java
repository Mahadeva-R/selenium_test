package arogyasetu_application.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerInstances {
	private static Logger log;

	private LoggerInstances() {
	}

	public static Logger getLoggerInstance() {
		if (log == null) {
			log = LogManager.getLogger(LoggerInstances.class.getName());
		}
		return log;
	}
}
