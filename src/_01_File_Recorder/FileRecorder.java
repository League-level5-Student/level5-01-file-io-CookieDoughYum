package _01_File_Recorder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src/_01_File_Recorder/Message.txt");
			int c = fr.read();
			while(c != -1){
				System.out.print((char)c);
				c = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
