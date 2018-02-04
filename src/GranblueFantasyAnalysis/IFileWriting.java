package GranblueFantasyAnalysis;

import java.io.IOException;

public interface IFileWriting<T1> {
	void WriteLine(String path,  T1 text);
	void writeAll(String path, T1 text) throws IOException;
}
