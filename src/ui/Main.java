package ui;

import java.util.Scanner;

import model.Event;

public class Main {
	
	private Scanner reader;
	private Event theEvent;
	
	public Main() {
		reader = new Scanner(System.in);
		System.out.println("Relative route of the file:");
		String file = reader.nextLine();
		theEvent = new Event(file);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
	}

}
