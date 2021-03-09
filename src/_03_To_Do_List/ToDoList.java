package _03_To_Do_List;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton button=new JButton("add task");
	JButton button1=new JButton("view tasks");
	JButton button2=new JButton("remove task");
	JButton button3=new JButton("save list");
	JButton button4=new JButton("load list");
    public static void main(String[] args) {
    	ToDoList t=new ToDoList();
		t.GUI();
    }
    public void GUI() {
    	button.addActionListener(this);
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	button3.addActionListener(this);
    	button4.addActionListener(this);
    	frame.pack();
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ArrayList<String> tasks=new ArrayList<String>();
		if(arg0.getSource()==button) {
			String task=JOptionPane.showInputDialog("Enter a task");
			tasks.add(task);
		}
		if(arg0.getSource()==button1) {
			for(int i=0; i<tasks.size(); i++) {
				System.out.println(tasks.get(i));
			}
		}
		if(arg0.getSource()==button2) {
			String remove=JOptionPane.showInputDialog("which task would you like to remove?");
			tasks.remove(remove);
		}
		if(arg0.getSource()==button3) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/Task.txt", true);
				fw.write(tasks.size());
				fw.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(arg0.getSource()==button4) {
			String list=JOptionPane.showInputDialog("from which file would you like to load the list from?");
		}
	}
}
