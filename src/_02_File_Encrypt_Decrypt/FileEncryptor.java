package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a messager.
	 * Use any key you want (1 - 25) to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String message=JOptionPane.showInputDialog("Put a message to encrypt");
		ArrayList<Character> charMessage=new ArrayList<Character>();
		ArrayList<Character> messageEncrypt=new ArrayList<Character>();
		for(int i=0; i<message.length(); i++) {
			charMessage.add(message.charAt(i));
		}
		for(int i=0; i<charMessage.size(); i++) {
			char c=charMessage.get(i);
			try {
			c=message.charAt(i+4);
			}
			catch(IndexOutOfBoundsException e) {
				c=message.charAt(java.lang.Math.abs(((charMessage.size()-1)-i)-3));
			}
			messageEncrypt.add(c);
		}
		JOptionPane.showMessageDialog(null, " Your encrypted message is " + messageEncrypt);
		char[] encryptedCharacters=new char[messageEncrypt.size()];
		for(int i=0; i<messageEncrypt.size(); i++) {
			encryptedCharacters[i]=messageEncrypt.get(i);
		}
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/EncryptedMessage.txt", false);
			fw.write(encryptedCharacters);	
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
