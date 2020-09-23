package simulation;

import java.io.FileWriter;
import java.io.IOException;

public class Printer {

	private static FileWriter myFileWriter = null;
	
	public static void setFile(String fileName){
		try {
			Printer.myFileWriter = new FileWriter(fileName + ".txt");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File does not exist!");
		}
	}

	public static void addLine(String line){
		try {
			myFileWriter.write(line);
		} catch (IOException e) {
			System.out.println("Error writing to file!");
		}
	}
}
