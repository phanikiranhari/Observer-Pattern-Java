package studentRecordsBackup.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Hari
 *
 */

public class FileProcessor {
	
	private BufferedReader bufferReader;

	/**
	 * This method takes the required parameters viz. filename and buffer reader and
	 * returns the current line from the file.
	 * @param fileName
	 * @param bufferReader
	 * @return the current line from the file
	 */
	public String readLineFromFile() {
		String currentLine = null;
		try {
			currentLine = bufferReader.readLine();
		} catch (IOException e) {
			Logger.writeMessage("Exception: Some exception has occured while reading the file");
			System.exit(0);
		}
		return currentLine;
	}
	
	
	/**
	 * Constructor that instantiates a buffer ready and makes it ready to read file content
	 * @param fileName
	 * @return No Value
	 */
	public FileProcessor(String fileName){
		try {
			bufferReader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			Logger.writeMessage("Error File not found");
			System.exit(0);
		}
		
	}
}
