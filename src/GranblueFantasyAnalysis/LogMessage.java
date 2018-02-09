package GranblueFantasyAnalysis;

public class LogMessage {
	LogMessage(){
		
	}
	
	enum LOG_MSG{
		NOT_FOUND_DIRECTORIES,
		NOT_FOUND_FILES,
	}

	protected LOG_MSG Output(String msgName) {
		return LOG_MSG.valueOf(msgName);
	}
}
