/*
 * Patrick Mahoney
 * Nov 19 2019
 * Maze Game: LVL1: follow the pattern, LVL2: lights out, LVL3: Monster
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class MazeMonsters extends JFrame implements KeyListener, ActionListener{
		
	boolean next = false;
	
	int win = 0;

	JMenuBar mainbar = new JMenuBar();
	JMenu lives = new JMenu("Lives");
	JMenu menu = new JMenu("Menu");
	
	//Lives 
	int lifeCount = 3; 
	JMenuItem menuLifeCount = new JMenuItem("Lifes: " + lifeCount);
	
	//select
	JMenuItem mainMenu = new JMenuItem("Main Menu");
	JMenuItem levelOne = new JMenuItem("Level 1");
	JMenuItem levelTwo = new JMenuItem("Level 2");
	JMenuItem levelThree = new JMenuItem("Level 3");
	JMenuItem exit = new JMenuItem("Exit Game");
	
	private final int ROWS = 10;
	private final int COLS = 10;
	private int curCOL = 0;
	private int curROW = 5;
	
	//CHARACTER IMAGE
	ImageIcon adventureCharacter = new ImageIcon("//Users/matthewmahoney/"
			+ "Documents/CPSC 223J/Final Project/Hat-Boy-Adventure-Character"
			+ ".png");
	Image character = adventureCharacter.getImage()
			.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
	
	//FLOOR IMAGES
	ImageIcon caveTile = new ImageIcon("//Users/matthewmahoney/Documents/"
			+ "CPSC 223J/Final Project/snow_floor_tile.png");
	Image caveFloor = caveTile.getImage() 
			.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
	
	ImageIcon darkCave = new ImageIcon("//Users/matthewmahoney/Documents/"
			+ "CPSC 223J/Final Project/CavefloorDark.png");
	Image darkFloor = darkCave.getImage()
			.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
	
	//light up path colors
	ImageIcon green_tile = new ImageIcon("//Users/matthewmahoney/Documents/"
			+ "CPSC 223J/Final Project/green_tile.png");
	Image greenTile = green_tile.getImage() 
			.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
	
	ImageIcon orange_tile = new ImageIcon("//Users/matthewmahoney/Documents/"
			+ "CPSC 223J/Final Project/orange_tile.png");
	Image orangeTile = orange_tile.getImage() 
			.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);	
	
	ImageIcon red_tile = new ImageIcon("//Users/matthewmahoney/Documents/"
			+ "CPSC 223J/Final Project/red_tile.png");
	Image redTile = red_tile.getImage() 
			.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
	
	ImageIcon yellow_tile = new ImageIcon("//Users/matthewmahoney/Documents/"
			+ "CPSC 223J/Final Project/yellow_tile.png");
	Image yellowTile = yellow_tile.getImage() 
			.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);

	
	//CARDLAYOUTS:
	CardLayout levels = new CardLayout();
	
	//welcome
	private JPanel welcomePanel = new JPanel(new BorderLayout());
	
	private JLabel welcomeLabel = new JLabel();
	
	ImageIcon welcome_image = new ImageIcon("//Users/matthewmahoney/Documents/"
			+ "CPSC 223J/Final Project/welcome_image.png");
	Image welcomeImage = welcome_image.getImage()
			.getScaledInstance(732, 685, java.awt.Image.SCALE_SMOOTH);
	
	private JButton play = new JButton("play");
	
	//lose	
	private JLabel loseLabel = new JLabel();
	
	ImageIcon lost_image = new ImageIcon("//Users/matthewmahoney/Documents/"
			+ "CPSC 223J/Final Project/lose.png");
	Image lostImage = lost_image.getImage()
			.getScaledInstance(685, 685, java.awt.Image.SCALE_SMOOTH);
	//private JButton retryButton = new JButton("retry");

	//win	
	private JLabel winLabel = new JLabel();
	
	ImageIcon win_image = new ImageIcon("//Users/matthewmahoney/Documents/"
			+ "CPSC 223J/Final Project/win_image.png");
	Image winImage = win_image.getImage()
			.getScaledInstance(875, 685, java.awt.Image.SCALE_SMOOTH);

	//dungeon 1
	private JPanel LVLOne = new JPanel(new BorderLayout());
	
	private JPanel dungeon1 = new JPanel(new GridLayout(ROWS, COLS, 0, 0));
	
	//character movment
	private JLabel background[][] = new JLabel[ROWS][COLS];

	private JPanel sideBar = new JPanel(new GridLayout(2, 1, 0, 0));

	private JLabel story = new JLabel("NAVIGATION ON: (-1 Life)");
	private JButton see = new JButton("light path");

	
	//dungeon 2	
	private JPanel LVLTwo = new JPanel(new BorderLayout());
	
	private JPanel dungeon2 = new JPanel(new GridLayout(ROWS, COLS, 0, 0));
	
	//character movment
	private JLabel background2[][] = new JLabel[ROWS][COLS];
		
	private JPanel sideBar2 = new JPanel(new GridLayout(2, 1, 0, 0));
	private JLabel story2 = new JLabel("ERROR: NAVIGATION DOWN");
	private JButton enter = new JButton("Enter Cave");

	//boss level
	private JPanel bossPanel = new JPanel(new BorderLayout());
	
	private JLabel bossLabel = new JLabel();
	
	ImageIcon boss_image = new ImageIcon("//Users/matthewmahoney/Documents/"
			+ "CPSC 223J/Final Project/Boss.png");
	Image bossImage = boss_image.getImage()
			.getScaledInstance(900, 700, java.awt.Image.SCALE_SMOOTH);
	
	private JButton defeatBoss = new JButton("Press Quickly!");
		
	public MazeMonsters() {
		super("Maze Monsters");
		setSize(800,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(levels);
		
		setJMenuBar(mainbar);
		
		//LIVES
		mainbar.add(lives);
		lives.add(menuLifeCount);

		//MAIN MENU
		mainbar.add(menu);
		menu.add(mainMenu);
		menu.add(levelOne);
		menu.add(levelTwo);
		menu.add(levelThree);
		
		//exit
		menu.add(exit);
		
		exit.addActionListener(this);
		mainMenu.addActionListener(this);
		levelOne.addActionListener(this);
		levelTwo.addActionListener(this);
		levelThree.addActionListener(this);
		
		//WELCOME
		welcomeLabel.setIcon(new ImageIcon(welcomeImage));
		welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
		welcomePanel.add(play, BorderLayout.EAST);
		play.addActionListener(this);
		
		add(welcomePanel, "WLCM");
		
		//LOSE
		loseLabel.setIcon(new ImageIcon(lostImage));
		
		add(loseLabel, "LOSE");
		
		//WIN
		winLabel.setIcon(new ImageIcon(winImage));
				
		add(winLabel, "WIN");
		
		//LVL 1 Panels
		for(int i = 0; i < ROWS; i++)
			for(int j = 0; j < COLS; j++) {
				background[i][j] = new JLabel(); 
				background[i][j].setIcon(new ImageIcon(caveFloor));
				dungeon1.add(background[i][j]);
			}
		
		//set player location
		background[curROW][curCOL].setIcon(new ImageIcon(character));		
		
		//LVL1 buttons (RIGHT)
		sideBar.add(story);
		sideBar.add(see);

		LVLOne.add(dungeon1, BorderLayout.CENTER);		
		
		LVLOne.add(sideBar, BorderLayout.EAST);
		
		see.addActionListener(this);

		add(LVLOne, "LVL1");
		
		//LVL 2 Panels
		for(int i = 0; i < ROWS; i++)
			for(int j = 0; j < COLS; j++) {
				background2[i][j] = new JLabel(); 
				background2[i][j].setIcon(new ImageIcon(darkFloor));
				dungeon2.add(background2[i][j]) ;
			}
		
		//set player location
		background2[curROW][curCOL].setIcon(new ImageIcon(character));		
		
		//LVL2 buttons (RIGHT)
		sideBar2.add(story2);
		sideBar2.add(enter);

		enter.addActionListener(this);
		
		LVLTwo.add(dungeon2, BorderLayout.CENTER);
		LVLTwo.add(sideBar2, BorderLayout.EAST);
		
		add(LVLTwo, "LVL2");
		
		
		//BOSS LVL
		bossLabel.setIcon(new ImageIcon(bossImage));
		bossPanel.add(bossLabel, BorderLayout.CENTER);
		bossPanel.add(defeatBoss, BorderLayout.SOUTH);
		
		defeatBoss.addActionListener(this);
		
		add(bossPanel, "BOSS");

		this.addKeyListener(this);
        this.setFocusable(true);        
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		//Character Movment
		int keyCode = e.getKeyCode();
		
		background[curROW][curCOL].setIcon(new ImageIcon(caveFloor));
		background2[curROW][curCOL].setIcon(new ImageIcon(darkFloor));	
		

		
		//check if on the path
		if(
			(curROW == 5 && curCOL == 0) || (curROW == 5 && curCOL == 1) ||
			(curROW == 5 && curCOL == 2) || (curROW == 4 && curCOL == 2) ||
			(curROW == 5 && curCOL == 0) || (curROW == 5 && curCOL == 0) ||
			(curROW == 3 && curCOL == 2) || (curROW == 3 && curCOL == 3) ||
			(curROW == 3 && curCOL == 4) || (curROW == 3 && curCOL == 5) ||
			(curROW == 4 && curCOL == 5) || (curROW == 5 && curCOL == 5) ||
			(curROW == 6 && curCOL == 5) || (curROW == 7 && curCOL == 5) ||
			(curROW == 7 && curCOL == 6) || (curROW == 7 && curCOL == 7) ||
			(curROW == 7 && curCOL == 8) || (curROW == 6 && curCOL == 8) ||
			(curROW == 6 && curCOL == 9) ) {
				if(keyCode == KeyEvent.VK_UP && (curROW - 1) >= 0) 
					curROW--;
				else if(keyCode == KeyEvent.VK_DOWN && (curROW + 1) < ROWS)
					curROW++;
				else if(keyCode == KeyEvent.VK_LEFT && (curCOL - 1) >= 0)
					curCOL--;					
				else if(keyCode == KeyEvent.VK_RIGHT && (curCOL + 1) < COLS)
					curCOL++;
				if(curROW == 6 && curCOL == 9) {
					story.setText("Press to Enter Next Level:");	
					see.setText("Enter");
					if(next) {
						story2.setText("There's a noise coming from the next "
								+ "room..");	
						enter.setText("Enter Cave");
					}
		    	}
		}
		//Minus One Life if not on path and reset game pieces 
		else {
			lifeCount--;
			
			background[5][1].setIcon(new ImageIcon(greenTile));
			background[5][2].setIcon(new ImageIcon(orangeTile));
			background[4][2].setIcon(new ImageIcon(redTile));
			background[3][2].setIcon(new ImageIcon(yellowTile));
				
			background[3][3].setIcon(new ImageIcon(greenTile));
			background[3][4].setIcon(new ImageIcon(orangeTile));
			background[3][5].setIcon(new ImageIcon(redTile));
			background[4][5].setIcon(new ImageIcon(yellowTile));
				
			background[5][5].setIcon(new ImageIcon(greenTile));
			background[6][5].setIcon(new ImageIcon(orangeTile));
			background[7][5].setIcon(new ImageIcon(redTile));
			background[7][6].setIcon(new ImageIcon(yellowTile));
				
			background[7][7].setIcon(new ImageIcon(greenTile));
			background[7][8].setIcon(new ImageIcon(orangeTile));
			background[6][8].setIcon(new ImageIcon(redTile));
			background[6][9].setIcon(new ImageIcon(yellowTile));
			
			
			
			background2[5][1].setIcon(new ImageIcon(greenTile));
			background2[5][2].setIcon(new ImageIcon(orangeTile));
			background2[4][2].setIcon(new ImageIcon(redTile));
			background2[3][2].setIcon(new ImageIcon(yellowTile));
				
			background2[3][3].setIcon(new ImageIcon(greenTile));
			background2[3][4].setIcon(new ImageIcon(orangeTile));
			background2[3][5].setIcon(new ImageIcon(redTile));
			background2[4][5].setIcon(new ImageIcon(yellowTile));
				
			background2[5][5].setIcon(new ImageIcon(greenTile));
			background2[6][5].setIcon(new ImageIcon(orangeTile));
			background2[7][5].setIcon(new ImageIcon(redTile));
			background2[7][6].setIcon(new ImageIcon(yellowTile));
				
			background2[7][7].setIcon(new ImageIcon(greenTile));
			background2[7][8].setIcon(new ImageIcon(orangeTile));
			background2[6][8].setIcon(new ImageIcon(redTile));
			background2[6][9].setIcon(new ImageIcon(yellowTile));			
			
    		curCOL = 0;
    		curROW = 5;
    		background[curROW][curCOL].setIcon(new ImageIcon(character));
			background2[curROW][curCOL].setIcon(new ImageIcon(character));
			
			menuLifeCount.setText("Lifes: " + lifeCount);
			
		//if the player runs out of lifes end game OR display minus one life
			if(lifeCount == 0) {
	    		levels.show(getContentPane(), "LOSE");
			}else {
				JOptionPane.showMessageDialog(null, "Minus One Life :(");
			}
		}
		
		//display character for both levels
		background[curROW][curCOL].setIcon(new ImageIcon(character));
		background2[curROW][curCOL].setIcon(new ImageIcon(character));

		/* ADD:
		 * if space pressed at correct location action happens (good/bad)
		 * random monsters appearing 
		 */
	}

	@Override
	public void keyReleased(KeyEvent e) {

		//change the tiles back after pressing see
		background[5][0].setIcon(new ImageIcon(caveFloor));
		background[5][1].setIcon(new ImageIcon(caveFloor));
		background[5][2].setIcon(new ImageIcon(caveFloor));
		background[4][2].setIcon(new ImageIcon(caveFloor));
		background[3][2].setIcon(new ImageIcon(caveFloor));
		
		background[3][3].setIcon(new ImageIcon(caveFloor));
		background[3][4].setIcon(new ImageIcon(caveFloor));
		background[3][5].setIcon(new ImageIcon(caveFloor));
		background[4][5].setIcon(new ImageIcon(caveFloor));
		
		background[5][5].setIcon(new ImageIcon(caveFloor));
		background[6][5].setIcon(new ImageIcon(caveFloor));
		background[7][5].setIcon(new ImageIcon(caveFloor));
		background[7][6].setIcon(new ImageIcon(caveFloor));
		
		background[7][7].setIcon(new ImageIcon(caveFloor));
		background[7][8].setIcon(new ImageIcon(caveFloor));
		background[6][8].setIcon(new ImageIcon(caveFloor));
		background[6][9].setIcon(new ImageIcon(caveFloor));
		
		//setting after switching to PANEL 2
		background2[5][1].setIcon(new ImageIcon(darkFloor));
		background2[5][2].setIcon(new ImageIcon(darkFloor));
		background2[4][2].setIcon(new ImageIcon(darkFloor));
		background2[3][2].setIcon(new ImageIcon(darkFloor));
			
		background2[3][3].setIcon(new ImageIcon(darkFloor));
		background2[3][4].setIcon(new ImageIcon(darkFloor));
		background2[3][5].setIcon(new ImageIcon(darkFloor));
		background2[4][5].setIcon(new ImageIcon(darkFloor));
			
		background2[5][5].setIcon(new ImageIcon(darkFloor));
		background2[6][5].setIcon(new ImageIcon(darkFloor));
		background2[7][5].setIcon(new ImageIcon(darkFloor));
		background2[7][6].setIcon(new ImageIcon(darkFloor));
			
		background2[7][7].setIcon(new ImageIcon(darkFloor));
		background2[7][8].setIcon(new ImageIcon(darkFloor));
		background2[6][8].setIcon(new ImageIcon(darkFloor));
		background2[6][9].setIcon(new ImageIcon(darkFloor));
		
		background[curROW][curCOL].setIcon(new ImageIcon(character));
		background2[curROW][curCOL].setIcon(new ImageIcon(character));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//MENU BAR: goes to the level and resets the stats and game peices  
		Object menu = e.getSource();
		
		//welcome: play
		if(menu == mainMenu) {
			levels.show(getContentPane(), "WLCM");
			lifeCount = 3;
			menuLifeCount.setText("Lifes: " + lifeCount);
			story.setText("navigation on: press to activate:");
			next = false;
			story.setText("navigation on: press to activate:");
			see.setText("light path");
	
			background[5][0].setIcon(new ImageIcon(yellowTile));
			background[5][1].setIcon(new ImageIcon(greenTile));
			background[5][2].setIcon(new ImageIcon(orangeTile));
			background[4][2].setIcon(new ImageIcon(redTile));
			background[3][2].setIcon(new ImageIcon(yellowTile));
			
			background[3][3].setIcon(new ImageIcon(greenTile));
			background[3][4].setIcon(new ImageIcon(orangeTile));
			background[3][5].setIcon(new ImageIcon(redTile));
			background[4][5].setIcon(new ImageIcon(yellowTile));
				
			background[5][5].setIcon(new ImageIcon(greenTile));
			background[6][5].setIcon(new ImageIcon(orangeTile));
			background[7][5].setIcon(new ImageIcon(redTile));
			background[7][6].setIcon(new ImageIcon(yellowTile));
				
			background[7][7].setIcon(new ImageIcon(greenTile));
			background[7][8].setIcon(new ImageIcon(orangeTile));
			background[6][8].setIcon(new ImageIcon(redTile));
			background[6][9].setIcon(new ImageIcon(yellowTile));
			
			background[curROW][curCOL].setIcon(new ImageIcon(character));
		}
		//LVL 1: see
		else if(menu == levelOne) {
			lifeCount = 3;
			menuLifeCount.setText("Lifes: " + lifeCount);
			story.setText("navigation on: press to activate:");
			next = false;
			story.setText("navigation on: press to activate:");
			see.setText("light path");
			levels.show(getContentPane(), "LVL1");

			background[5][0].setIcon(new ImageIcon(yellowTile));
			background[5][1].setIcon(new ImageIcon(greenTile));
			background[5][2].setIcon(new ImageIcon(orangeTile));
			background[4][2].setIcon(new ImageIcon(redTile));
			background[3][2].setIcon(new ImageIcon(yellowTile));
			
			background[3][3].setIcon(new ImageIcon(greenTile));
			background[3][4].setIcon(new ImageIcon(orangeTile));
			background[3][5].setIcon(new ImageIcon(redTile));
			background[4][5].setIcon(new ImageIcon(yellowTile));
				
			background[5][5].setIcon(new ImageIcon(greenTile));
			background[6][5].setIcon(new ImageIcon(orangeTile));
			background[7][5].setIcon(new ImageIcon(redTile));
			background[7][6].setIcon(new ImageIcon(yellowTile));
				
			background[7][7].setIcon(new ImageIcon(greenTile));
			background[7][8].setIcon(new ImageIcon(orangeTile));
			background[6][8].setIcon(new ImageIcon(redTile));
			background[6][9].setIcon(new ImageIcon(yellowTile));
			
			background[curROW][curCOL].setIcon(new ImageIcon(character));
		}
		//LVL 2: enter
		else if(menu == levelTwo) {
			lifeCount = 3;	
			menuLifeCount.setText("Lifes: " + lifeCount);
			story2.setText("ERROR: PATH NOT LIT");
			enter.setText("Enter Cave");
			levels.show(getContentPane(), "LVL2");

			background2[5][1].setIcon(new ImageIcon(greenTile));
			background2[5][2].setIcon(new ImageIcon(orangeTile));
			background2[4][2].setIcon(new ImageIcon(redTile));
			background2[3][2].setIcon(new ImageIcon(yellowTile));
				
			background2[3][3].setIcon(new ImageIcon(greenTile));
			background2[3][4].setIcon(new ImageIcon(orangeTile));
			background2[3][5].setIcon(new ImageIcon(redTile));
			background2[4][5].setIcon(new ImageIcon(yellowTile));
				
			background2[5][5].setIcon(new ImageIcon(greenTile));
			background2[6][5].setIcon(new ImageIcon(orangeTile));
			background2[7][5].setIcon(new ImageIcon(redTile));
			background2[7][6].setIcon(new ImageIcon(yellowTile));
				
			background2[7][7].setIcon(new ImageIcon(greenTile));
			background2[7][8].setIcon(new ImageIcon(orangeTile));
			background2[6][8].setIcon(new ImageIcon(redTile));
			background2[6][9].setIcon(new ImageIcon(yellowTile));
			
			curCOL = 0;
			curROW = 5;
			background2[curROW][curCOL].setIcon(new ImageIcon(character));		
		}
		//LVL 3: defeatBoss
		else if(menu == levelThree) {
			levels.show(getContentPane(), "BOSS");
			win = 0;
		}
		//closes game
		else if(menu == exit)
			System.exit(0); 

		
		/*GAME BUTTONS: 
		 * 
		 *player moving between levels
		 */
		
		//LVL ONE:
		Object button = e.getSource();
		
		if(button == play){

			levels.show(getContentPane(), "LVL1");
			
			background[curROW][curCOL].setIcon(new ImageIcon(character));
			
			JOptionPane.showMessageDialog(null, "Follow the guided path, you "
				+ "can press 'see' to view the path again.. but it will cost "
				+ "you a life!");

			background[5][1].setIcon(new ImageIcon(greenTile));
			background[5][2].setIcon(new ImageIcon(orangeTile));
			background[4][2].setIcon(new ImageIcon(redTile));
			background[3][2].setIcon(new ImageIcon(yellowTile));
				
			background[3][3].setIcon(new ImageIcon(greenTile));
			background[3][4].setIcon(new ImageIcon(orangeTile));
			background[3][5].setIcon(new ImageIcon(redTile));
			background[4][5].setIcon(new ImageIcon(yellowTile));
				
			background[5][5].setIcon(new ImageIcon(greenTile));
			background[6][5].setIcon(new ImageIcon(orangeTile));
			background[7][5].setIcon(new ImageIcon(redTile));
			background[7][6].setIcon(new ImageIcon(yellowTile));
				
			background[7][7].setIcon(new ImageIcon(greenTile));
			background[7][8].setIcon(new ImageIcon(orangeTile));
			background[6][8].setIcon(new ImageIcon(redTile));
			background[6][9].setIcon(new ImageIcon(yellowTile));			
		}
		
		//if the player is at the end -> press to enter boss OR reset level 2
		if(button == enter){
			if(curCOL == 9 && curROW == 6 ) {
				levels.show(getContentPane(), "BOSS");
			}else {
				lifeCount--;
				
				background2[5][1].setIcon(new ImageIcon(greenTile));
				background2[5][2].setIcon(new ImageIcon(orangeTile));
				background2[4][2].setIcon(new ImageIcon(redTile));
				background2[3][2].setIcon(new ImageIcon(yellowTile));
					
				background2[3][3].setIcon(new ImageIcon(greenTile));
				background2[3][4].setIcon(new ImageIcon(orangeTile));
				background2[3][5].setIcon(new ImageIcon(redTile));
				background2[4][5].setIcon(new ImageIcon(yellowTile));
					
				background2[5][5].setIcon(new ImageIcon(greenTile));
				background2[6][5].setIcon(new ImageIcon(orangeTile));
				background2[7][5].setIcon(new ImageIcon(redTile));
				background2[7][6].setIcon(new ImageIcon(yellowTile));
					
				background2[7][7].setIcon(new ImageIcon(greenTile));
				background2[7][8].setIcon(new ImageIcon(orangeTile));
				background2[6][8].setIcon(new ImageIcon(redTile));
				background2[6][9].setIcon(new ImageIcon(yellowTile));
				
				curCOL = 0;
				curROW = 5;
				background2[curROW][curCOL].setIcon(new ImageIcon(character));				
			}

		}

		//LEVEL TWO:
		Object button2 = e.getSource();
		
		//see safe path 
		if(button2 == see) {
				if(curCOL == 9 && curROW == 6) {
					next=true;
					background2[curROW][curCOL].setIcon
						(new ImageIcon(darkFloor));
				  	levels.show(getContentPane(), "LVL2");			
					JOptionPane.showMessageDialog(null, "Oh no...the path is "
							+ "too dark! The path can only be seen once!");	
					
					background2[5][1].setIcon(new ImageIcon(greenTile));
					background2[5][2].setIcon(new ImageIcon(orangeTile));
					background2[4][2].setIcon(new ImageIcon(redTile));
					background2[3][2].setIcon(new ImageIcon(yellowTile));
						
					background2[3][3].setIcon(new ImageIcon(greenTile));
					background2[3][4].setIcon(new ImageIcon(orangeTile));
					background2[3][5].setIcon(new ImageIcon(redTile));
					background2[4][5].setIcon(new ImageIcon(yellowTile));
						
					background2[5][5].setIcon(new ImageIcon(greenTile));
					background2[6][5].setIcon(new ImageIcon(orangeTile));
					background2[7][5].setIcon(new ImageIcon(redTile));
					background2[7][6].setIcon(new ImageIcon(yellowTile));
						
					background2[7][7].setIcon(new ImageIcon(greenTile));
					background2[7][8].setIcon(new ImageIcon(orangeTile));
					background2[6][8].setIcon(new ImageIcon(redTile));
					background2[6][9].setIcon(new ImageIcon(yellowTile));
					
					curCOL = 0;
					curROW = 5;
					background2[curROW][curCOL].setIcon
						(new ImageIcon(character));	
				}else {
					lifeCount--;
					
					background[5][0].setIcon(new ImageIcon(yellowTile));
					background[5][1].setIcon(new ImageIcon(greenTile));
					background[5][2].setIcon(new ImageIcon(orangeTile));
					background[4][2].setIcon(new ImageIcon(redTile));
					background[3][2].setIcon(new ImageIcon(yellowTile));
						
					background[3][3].setIcon(new ImageIcon(greenTile));
					background[3][4].setIcon(new ImageIcon(orangeTile));
					background[3][5].setIcon(new ImageIcon(redTile));
					background[4][5].setIcon(new ImageIcon(yellowTile));
						
					background[5][5].setIcon(new ImageIcon(greenTile));
					background[6][5].setIcon(new ImageIcon(orangeTile));
					background[7][5].setIcon(new ImageIcon(redTile));
					background[7][6].setIcon(new ImageIcon(yellowTile));
						
					background[7][7].setIcon(new ImageIcon(greenTile));
					background[7][8].setIcon(new ImageIcon(orangeTile));
					background[6][8].setIcon(new ImageIcon(redTile));
					background[6][9].setIcon(new ImageIcon(yellowTile));
					
					background[curROW][curCOL].setIcon(new ImageIcon(character));
				}
	        this.requestFocusInWindow();
	        
	     } 
		
		//LEVEL THREE:
		Object button3 = e.getSource();
		
		if(button3 == defeatBoss) {
			win++;
			defeatBoss.setText("Press Quickly!!  (" + win + "/10)");
			if(win >= 10) {
				levels.show(getContentPane(), "WIN");
			}
		}
		
		
		/*
		 * ADD: RETRY
		 * 
		Object retry = e.getSource();

		if(retry == retryButton) {
	    		levels.show(getContentPane(), "LVL1");
	     }
	     */
	}
}
