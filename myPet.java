/*
 * Patrick Mahoney
 * Sep 17, 2019
 * Pet class for virtual pet game  
 */
public class myPet {

	 private String petName;
	 private int  petAge; 
	 private int  petHunger;
	 private int  petCleanliness;
	 private int  petHappiness;
	 private int  petHealth;
	 
	 public myPet (String name) {
		 // initializes random values and sets pets name based of user input
		 petName = name;
		 petAge = 1; 
		 petHunger = (int)(Math.random()* 10 +1);
		 petCleanliness = (int)(Math.random()* 10 +1);
		 petHappiness = (int)(Math.random()* 10 +1);
		 petHealth = (int)(Math.random()* 10 +1);		
	 }
	 
	 //getters and setters
	 String getPetName(){
		 return petName;
	 }
	 void setPetName(String name) {
		 petName = name;
	 }
	
	 int getPetAge(){
		 return petAge;
	 }
	 
	 void setPetAge(int age) {
		 petAge = age;
	 }
	 
	 int getPetHunger(){
		 return petHunger;
	 }
	 
	 void setPetHunger(int hunger) {
		 petHunger = hunger;
	 }
	 
	 int getPetCleanliness(){
		 return petCleanliness;
	 }
	 
	 void setPetCleanliness(int cleanliness) {
		 petCleanliness = cleanliness;
	 }
	 
	 int getPetHappiness(){
		 return petHappiness;
	 }
	 
	 void setPetHappiness(int happiness) {
		 petHappiness = happiness;
	 }
	 
	 int getPetHealth(){
		 return petHealth;
	 }
	 
	 void setPetHealth(int health) {
		 petHealth = health;
	 }
	 
	 /*
	  * methods for user choices of feed, wash, play, health and increments 
	  * corresponding statistics 
	  * 
	  */
	 
	 //feed->petHunger
	 
	 public void feed() { 
		 //positive/negative outcome for each action (2/3 positive)
		 int choice = (int)(Math.random()* 3 +1);
		 //good option
		 if (choice == 1 || choice == 2) {
			 System.out.println(petName + " oinks happily and eats the apple "
			 		+ "(+1 Hunger)");
			 // increases hunger status by 1
			 petHunger++;
		 }
		 //bad option
		 else {
			 System.out.println(petName + " got distracted! (-1 Hunger)");
			 // decreases hunger status by 1
			 petHunger--;
		 }
		 petAge++;
	 }
	 
	 //wash->petCleanliness
	 
	 public void wash() {
		 //positive/negative outcome for each action (2/3 positive)
		 int choice = (int)(Math.random()* 3 +1);
		
		 //good option
		 if (choice == 1 || choice == 2) {
			 System.out.println(petName + " loved his bath (+1 Cleanliness)");
			 petCleanliness++;
		 }
		 //bad option
		 else {
			 System.out.println(petName + " was super dirty and couldn't be "
			 		+ "fully cleaned, (-1 Cleanliness)");
			 petCleanliness--;
		 }
		 petAge++;
	 }
	 
	 //play->petHappiness
	 
	 public void play() {
		 //positive/negative outcome for each action (2/3 positive)
		 int choice = (int)(Math.random()* 3 +1);
		
		 //good option
		 if (choice == 1 || choice == 2) {
			 System.out.println(petName + " had fun outside (+1 Happiness)");
			 petHappiness++;
		 }
		 //bad option
		 else {
			 System.out.println(petName + " runs around the house...destroying"
				 		+ " everything (-1 Happiness)");
				 petHappiness--;
		 }
		 petAge++;
	 }
 
	 //health->petHealth
	 		 
	 public void health() {
		 //positive/negative outcome for each action (2/3 positive)
		 int choice = (int)(Math.random()* 3 +1);
		
		 //good option
		 if (choice == 1 || choice == 2) {
			 System.out.println(petName + " got a check-up at the doctor "
			 		+ "(+1 Health)");
			 petHealth++;
		 }
		 //bad option
		 else {
			 System.out.println(petName + " cries about getting shots, "
			 		+ "and doesn't go (-1 Health)");
			 petHealth--;
		 }
		 petAge++;
	 }
}

