package GranblueFantasyAnalysis;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReadWrite {
	
	public class FileReading{
		//For File Reading
		private String readAll(final String path) throws IOException {
		    return Files.lines(Paths.get(path), Charset.forName("UTF-8"))
		        .collect(Collectors.joining(System.getProperty("line.separator")));
		}
		
		public String RetLine(String path){
			String ret = null;
			try {
				ret = this.readAll(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ret;
		}

	}
	
	public class FileWriting<T1> implements IFileWriting<T1>{
		//For File Writing
		public void writeAll(final String path, final T1 text) throws IOException{
			if(text instanceof Object) {
				Files.write(Paths.get(path), (List<String>) text, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			}
			else {
				List<String> textlist = new ArrayList<>();
				textlist.add((String)text);
				Files.write(Paths.get(path), textlist, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
			}
		}
		
		public void CreanFile(String path) {
			try {
				if(Files.exists(Paths.get(path))) {
					Files.delete(Paths.get(path));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
		public void WriteLine(String path, T1 text) {
			try {
				if(!Files.exists(Paths.get(path))) {
					Files.createFile(Paths.get(path));
				}
				this.writeAll(path, text);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


