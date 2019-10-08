package ui;

import java.io.*;
import java.util.Scanner;

import model.Event;

public class Main {
	
	private Scanner reader;
	private Event theEvent;
	
	public Main() throws IOException {
		reader = new Scanner(System.in);
		System.out.println("Relative route of the file:");
		String file = reader.nextLine();
		boolean exist = false;
		while(!exist) {
			if(!new File(file).exists()) {
				System.out.println("The file doesn't exist. Please try again.");
				System.out.println("Relative route of the file:");
				file = reader.nextLine();
			}
			else {
				exist = true;
			}
		}
		theEvent = new Event(file);
		System.out.println(theEvent.findCountryCompetitors("Colombia"));
	}
	
	public static void main(String[] args) {
		try {
			Main m = new Main();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
