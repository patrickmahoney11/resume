/*
 * Patrick Mahoney
 * Sep 17, 2019
 * Virtual pet game that changes pets vitals depending on user input 
 */

import java.util.Scanner;

public class petMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		// output start information and virtual pig picture
		System.out.println("-Virtual Pig-");
		System.out.println(
				"  ^  ^   \n" +
				" {-  - }  \n" + 
				" ( 00  ) \n" + 
				" | --  |______/~ \n"+ 
				" (             ) \n"+ 
				" (  ___    ___ ) \n"+ 
				"    | |    | | \n"  +
				"    (_)    (_) \n" );
		
		//user input name
		System.out.println("Please Enter a name for your pet Pig:");
		String name;
		name = input.nextLine();
				
		myPet pig = new myPet(name);
		
		//show stats
		System.out.println("Initializing Stats...");
		printStats(pig);
		System.out.println(name + " was Born! \n\n");
		
		printMenu();
		
		System.out.println("Enter a number (1-5): ");
		int action;
		action = input.nextInt();
		
		//loops until pet's age reaches 10 and calls method corresponding to 
		//user inputed action
		while (action != 5 && pig.getPetAge() < 10){
			
			if (action == 1) {
				Attribute_Tool.checkHunger(pig);
			}
			
			if (action == 2) {
				Attribute_Tool.checkCleanliness(pig);
			}
	
			if (action == 3) {
				Attribute_Tool.checkHappiness(pig);
			}
			if (action == 4) {
				Attribute_Tool.checkHealth(pig);
			}
			
			printStats(pig);
			
			if(pig.getPetAge() != 10) {
				printMenu();
				System.out.println("Enter a number (1-5): ");
				action = input.nextInt();
			}
		}
		//prints end program
		System.out.println("\n \n" + name + " Died of old age");
		System.out.println("Quiting Program...");
	}
	
	//print current pet stats
	public static void printStats(myPet pig){
		//Displays current statitistics of pet 
		
		System.out.println("\n\n-" + pig.getPetName() + "'s Stats-");
		
		System.out.println("Hunger: " + pig.getPetHunger());
		System.out.println("Cleanliness: " + pig.getPetCleanliness());
		System.out.println("Happiness: " + pig.getPetHappiness());
		System.out.println("Health: " + pig.getPetHealth() + "\n\n");
	}
	
	// print option menu
	public static void printMenu(){	
		System.out.println("Main Menu:");
		System.out.println("1. Feed");
		System.out.println("2. Wash");
		System.out.println("3. Play");
		System.out.println("4. Health");
		System.out.println("5. Quit");
	}
	
	public static void checkAttributes(myPet pig) {
		Attribute_Tool.checkHunger(pig);
		Attribute_Tool.checkCleanliness(pig);
		Attribute_Tool.checkHappiness(pig);
		Attribute_Tool.checkHealth(pig);
	}
	
}

