package ui;

import java.io.*;
import java.util.InputMismatchException;
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
		menu();
	}
	
	public void menu() {
		int option = -1;
		while(option != 0) {
			System.out.println("0. Exit");
		    System.out.println("1. Find viewer");
		    System.out.println("2. Find competitor");
		    System.out.println("3. Find the viewers from a country");
		    System.out.println("4. Find the competitors from a country");
		    boolean correct = false;
		    while(!correct) {
		    	try {
			    	option = reader.nextInt();
				    reader.nextLine();
				    correct = true;
			    }
			    catch(InputMismatchException e) {
			    	reader.nextLine();
			    	System.out.println("Select a correct option");
			    }
		    }
		    switch(option) {
		    case 1:
		    	findViewer();
		    break;
		    case 2:
		    	findCompetitor();
		    break;
		    case 3:
		    	findCountryViewers();
		    	break;
		    case 4:
		    	findCountryCompetitors();
		    case 0:
		    	System.out.println("See you later");
		    	break;
		    default:
		    	break;
		    }
		}
	}
	
	public void findViewer() {
		System.out.println("Id of the viewer:");
		String idViewer = reader.nextLine();
		long t1 = System.currentTimeMillis();
		if(theEvent.findViewer(idViewer) != null) {
			System.out.println(theEvent.findViewer(idViewer));
		}
		else {
			System.out.println("The viewer doesn't exist");
		}
		long t2 = System.currentTimeMillis();
		System.out.println("The time expended in the search is "+(t2-t1)+" miliseconds");
	}
	
	public void findCompetitor() {
		System.out.println("Id of the competitor:");
		String idCompetitor = reader.nextLine();
		long t1 = System.currentTimeMillis();
		if(theEvent.findCompetitor(idCompetitor) != null) {
			System.out.println(theEvent.findCompetitor(idCompetitor));
		}
		else {
			System.out.println("The viewer doesn't exist");
		}
		long t2 = System.currentTimeMillis();
		System.out.println("The time expended in the search is "+(t2-t1)+" miliseconds");
	}
	
	public void findCountryViewers() {
		System.out.println("Country:");
		String country = reader.nextLine();
		System.out.println(theEvent.findCountryViewers(country));
	}
	
	public void findCountryCompetitors() {
		System.out.println("Country:");
		String country = reader.nextLine();
		System.out.println(theEvent.findCountryCompetitors(country));
	}
	
	public static void main(String[] args) {
		try {
			Main m = new Main();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
