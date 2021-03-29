package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
	}
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		/*
		 * JFileChooser jfc = new JFileChooser();
		 * jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); int returnVal =
		 * jfc.showOpenDialog(null); if (returnVal == JFileChooser.APPROVE_OPTION) {
		 * File directory = jfc.getSelectedFile(); File[] files = directory.listFiles();
		 * if(files != null) { for(File f : files) {
		 * System.out.println(f.getAbsolutePath()); } } /* }
		 * 
		 * /* Your task is to write a program that iterates through the src folder of
		 * this current Java Project. For every .java file it finds, the program will
		 * add a (non-legally binding) copyright statement at the bottom. Be aware of
		 * possible directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */
void Iteration(File[] files1) {
		File a = new File("/root/git/level5-01-file-io-CookieDoughYum/src");
		File[] files = a.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				files1=files[i].listFiles();
				if (!files[i].isDirectory()) {
					if (files[i].getAbsolutePath().endsWith(".java")) {
						try {
							System.out.println("Trying to print");
							FileWriter fw = new FileWriter("src/_04_Directory_Iteration/DirectoryIterator.java", true);
							fw.write("\nCopyright @2021 Nathan Young");
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				else if(files[i].isDirectory()) {
				      Iteration(files1);
				}
			}
		}
}
}
