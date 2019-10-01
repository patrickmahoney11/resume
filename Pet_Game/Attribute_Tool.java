/*
 * Patrick Mahoney
 * Sep 20, 2019
 * Controls additional outputs dependent on age and level of pet statistics
 */
public class Attribute_Tool {
	
	public static void checkHunger(myPet pig){
		int num = (int)(Math.random()* 3 +1);
		// as the pet gets older the game gets harder and if the user makes any  
		// stat less than 5
		boolean easy = pig.getPetHunger() <= 5 || pig.getPetAge() > 6;
		
		//sends initial message (2/3 good - 1/3 bad)
		pig.feed();	
		 //other stats that change (additional phrases) 
		 //dependent on stat < 5 or age > 6 
		
		//more likely to get a better output 
		if (easy == true) {	 
			 if(num == 1) {	
				 System.out.println(pig.getPetName() + " Feels healthy and "
				 		+ "ready to go! (+1 Happiness & +1 Health)");
				pig.setPetHappiness(pig.getPetHappiness() + 1);
				pig.setPetHealth(pig.getPetHealth() + 1);
			 }
			 else if(num == 2) {
				 System.out.println(pig.getPetName() + " ate a lot! (+1 Hunger "
				 		+ "& -2 Health");
				 pig.setPetHealth(pig.getPetHealth() - 2);
				 pig.setPetHealth(pig.getPetHunger() + 1);
			 }
			 else if(num == 3) {
				 System.out.println(pig.getPetName() + " got food all over! "
				 		+ "(-1 Cleanliness)");
				 pig.setPetCleanliness(pig.getPetCleanliness() - 1);
			 }
		 } 
		//more likely to get a worse output 
		 else {
			 if(num == 1) {
				 //decrease Happiness or happiness 					 
				 System.out.println(pig.getPetName() + " wanted a cookie! "
				 		+ "(-1 Happiness) "
				 		+ "and did not finish it! (-1 Hunger)");
				 pig.setPetHappiness(pig.getPetHappiness() - 1);;
				 pig.setPetHunger(pig.getPetHunger() - 1);
			 }
			 else if(num == 2) {
				 System.out.println(pig.getPetName() + " Didn't finish the "
				 		+ "food because it was spoiled! "
				 		+ "(-2 Hunger & -2 Health)");
				 pig.setPetHunger(pig.getPetHunger() - 2);
				 pig.setPetHealth(pig.getPetHealth() - 2);
			 }
			 else if(num == 3) {
				 System.out.println(pig.getPetName() 
						 + " ate a lot! (+1 Happiness)");
				 pig.setPetHealth(pig.getPetHappiness() + 1);
			 } 
		 }

	}
	
	public static void checkCleanliness(myPet pig){
		int num = (int)(Math.random()* 3 +1);
		// as the pet gets older the game gets harder and if the user makes any  
		// stat less than 5
		boolean easy = pig.getPetCleanliness() <= 5 || pig.getPetAge() > 6;
		
		//sends initial message (2/3 good - 1/3 bad)
		pig.wash();	
		 //other stats that change (additional phrases) 
		 //dependent on stat < 5 or age > 6 
		
		//more likely to get a better output 
		if (easy == true) {	 
			 if(num == 1) {	
				 System.out.println(pig.getPetName() + " Got an after bath "
				 		+ "snack (+1 Hunger)");
				pig.setPetHealth(pig.getPetHealth() + 1);
			 }
			 else if(num == 2) {
				 System.out.println(pig.getPetName() + " was all clean, "
				 		+ "after yoga (+1 health) /n "
					 		+ "...but hated it (-2 Happiness)");
				 pig.setPetHealth(pig.getPetHealth() + 1);
				 pig.setPetHappiness(pig.getPetHappiness() - 2);
			 }
			 else if(num == 3) {
				 System.out.println(pig.getPetName() + " used his new shampoo "
				 		+ "(+1 Happiness)");
				 pig.setPetCleanliness(pig.getPetHappiness() + 1);
			 }
		 } 
		//more likely to get a worse output 
		 else {
			 if(num == 1) {
				 //decrease Happiness or happiness 					 
				 System.out.println(pig.getPetName() + " was so happy! "
				 		+ "(+1 Happiness) " + pig.getPetName() + 
				 		"ran outside to play in the mud (-1 Cleanliness)");
				 pig.setPetHappiness(pig.getPetHappiness() - 1);;
				 pig.setPetHunger(pig.getPetHappiness() - 1);
			 }
			 else if(num == 2) {
				 System.out.println(pig.getPetName() + " Didn't finish the "
				 		+ "snacks you gave him after his bath (-2 Hunger)");
				 pig.setPetHunger(pig.getPetHunger() - 2);
			 }
			 else if(num == 3) {
				 System.out.println(pig.getPetName() + " Feels healthy and "
				 		+ "ready to go! (+1 Health)");
				 pig.setPetHealth(pig.getPetHealth() + 1);
			 } 
		 }
	}
	

	public static void checkHappiness(myPet pig){
		int num = (int)(Math.random()* 3 +1);
		// as the pet gets older the game gets harder and if the user makes any  
		// stat less than 5
		boolean easy = pig.getPetHappiness() <= 5 || pig.getPetAge() > 7;
		
		//sends initial message (2/3 good - 1/3 bad)
		pig.play();

		//more likely to get a better output 
		if (easy == true) {	 
			 if(num == 1) {	
				 System.out.println(pig.getPetName() + " Feels healthy and "
				 		+ "ready to go! (+1 Health)");
				pig.setPetHealth(pig.getPetHealth() + 1);
			 }
			 else if(num == 2) {
				 System.out.println(pig.getPetName() + " was all clean, and "
				 		+ "went to get his shots (+2 health)");
				 pig.setPetHealth(pig.getPetHealth() + 2);
			 }
			 else if(num == 3) {
				 System.out.println(pig.getPetName() + " plays in the mud..."
					 		+ "and got really dirty (-1 Cleanliness)");
				 pig.setPetCleanliness(pig.getPetCleanliness() - 1);
			 }
		 } 
		//more likely to get a worse output 
		 else {
			 if(num == 1) {
				 //decrease Happiness or happiness 					 
				 System.out.println(pig.getPetName() + " was so happy! "
				 		+ "(+1 Happiness) " + pig.getPetName() + "ran outside "
				 				+ "to play in the mud (-1 Cleanliness)");
				 pig.setPetHappiness(pig.getPetHappiness() + 1);
				 pig.setPetHunger(pig.getPetCleanliness() - 1);
			 }
			 else if(num == 2) {
				 System.out.println(pig.getPetName() + " Didn't finish the "
				 		+ "snacks you gave him after his bath (-2 Hunger)");
				 pig.setPetHunger(pig.getPetHunger() - 2);
			 }
			 else if(num == 3) {
				 System.out.println(pig.getPetName() + " Feels healthy and "
				 		+ "ready to go! (+1 Health)");
				 pig.setPetHealth(pig.getPetHealth() + 1);
			 } 
		 }
	}
	
	public static void checkHealth(myPet pig){
		int num = (int)(Math.random()* 3 +1);
		// as the pet gets older the game gets harder and if the user makes any  
		// stat less than 5
		boolean easy = pig.getPetHealth() <= 5 || pig.getPetAge() > 7;
		
		//sends initial message (2/3 good - 1/3 bad)
		pig.health();	
	
		//more likely to get a better output 
		if (easy == true) {	 
			 if(num == 1) {	
				 System.out.println(pig.getPetName() + " Feels healthy and "
				 		+ "ready to go! (+1 Health)");
				pig.setPetHealth(pig.getPetHealth() + 1);
			 }
			 else if(num == 2) {
				 System.out.println(pig.getPetName() + "got a lolipop at the "
				 		+ "doctors (+1 Health)");
				 pig.setPetHealth(pig.getPetHealth() + 2);
			 }
			 else if(num == 3) {
				 System.out.println(pig.getPetName() + " feels great and plays "
				 		+ "in the mud...and got really dirty (-1 Cleanliness "
				 		+ "& +1 Happiness)");
				 pig.setPetCleanliness(pig.getPetCleanliness() - 1);
				 pig.setPetHappiness(pig.getPetHappiness() + 1);
			 }
		 } 
		//more likely to get a worse output 
		 else {
			 if(num == 1) {
				 //decrease Happiness or happiness 					 
				 System.out.println(pig.getPetName() + " was so happy! "
				 		+ "(+1 Happiness) " + pig.getPetName() + "ran outside "
				 				+ "to play in the mud (-1 Cleanliness)");
				 pig.setPetHappiness(pig.getPetHappiness() + 1);;
				 pig.setPetHunger(pig.getPetCleanliness() - 1);
			 }
			 else if(num == 2) {
				 System.out.println(pig.getPetName() + " Didn't finish the s"
				 		+ "nacks you gave him (-1 Hunger)");
				 pig.setPetHunger(pig.getPetHunger() - 1);
			 }
			 else if(num == 3) {
				 System.out.println(pig.getPetName() + " Feels healthy and "
				 		+ "ready to go! (+1 Health)");
				 pig.setPetHealth(pig.getPetHealth() + 1);
			 } 
		 }
	}
}
