package simulation;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Printer {

	private static Writer writer = null;

	public static boolean setFile()
	{
		try {
			if (Printer.writer != null)
			Printer.writer.close();
			Printer.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.txt"), "utf-8"));
			return true;
		} catch (Exception e) {
			System.out.println("Error setting file");
			return false;
		}
	}

	public static void addLine(String message)
	{
		try
		{
			Printer.writer.write(message + '\n');
			writer.flush();
		}
		catch (IOException e)
		{
			System.out.println("Error while trying to write to the file");
			System.exit(1);
		}
	}
}
