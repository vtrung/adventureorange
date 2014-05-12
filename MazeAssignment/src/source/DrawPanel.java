// This program shows the basics of how to draw 2D shapes
//author: Ving Trung
// date: 1/28/2014
// assignment: #3 DrawSomething
// class: CIS 016

package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

import sprites.SpriteItem;
import sprites.SpriteOrange;
/**
 * Main game panel that all sprites and images are drawn. Manages sprites attributes and game statuses
 * @author svingt
 * 
 */
@SuppressWarnings("serial")
public class DrawPanel extends JPanel{
	
//Author: Ving Trung
//Description: Adventure Orange Game
//Last Changed: May 6, 2014
//Files: source: DrawPanel.java; Map.java; MapFinish.java; MapStart.java;
//					MusicBox.java; MyFrame.java
//			sprites: Sprite.java; SpriteDoor.java; SpriteEnemy.java; SpriteItem.java;
//					SpriteOrange.java; SpriteTree.java; Wall.java;
	
	public boolean end = false;
	public boolean treetouch = false;
	public boolean win = false;
	public int life = 3;
	private MusicBox music = new MusicBox();
	private SpriteOrange sOrange;
	private int upmv = 0;
	private int downmv = 0;
	private int leftmv = 0;
	private int rightmv = 0;
	private int frameRate = 100; //frame rate in frames per second.
	private int mapLoc = 0;
	private ArrayList<Map> maps = new ArrayList<Map>();
	private ArrayList<SpriteOrange> lives = new ArrayList<SpriteOrange>();
	private ArrayList<SpriteItem> items = new ArrayList<SpriteItem>();
	
	/**
	 * Build all elements to start the game
	 */
	public DrawPanel(){
		sOrange = new SpriteOrange(60,60,life);
		for(int count = 0; count < life; count++){
			lives.add(new SpriteOrange((count*35+1085), 612, 1));
		}
		for(int count = 0; count < 5; count++){
			items.add(new SpriteItem((count*30+1085), 660, true));
		}
		maps.add(new MapStart()); //initializeMaps
		maps.add(new MapFinish());
		
		music.loopClip(1);
		Thread myAnimThread = new Thread() {
			@Override
			public void run() { 
				while (true) {
					if(!end)
						update(); // update the position of our box
					repaint(); // Refresh the display which calls paintComponent
					
					try {
						Thread.sleep(1000/frameRate);
					} // try
					catch (InterruptedException ex) {}
				} // while 
			} // run
		}; // Thread
		myAnimThread.start();
	} // 	DrawPanel()
	
	/**
	 * Update sprite positioning and getting return value to determine the state of panel
	 * 
	 */
	public void update(){
		String status = sOrange.update(leftmv, rightmv, upmv, downmv, maps.get(mapLoc).getSprites(), maps.get(mapLoc).getEnemies());
		if(status.equals("wall")){ //check if hit wall
			music.playBump();
		}
		if(status.equals("tree")){//check if hit tree
			music.playBump();
			treetouch=true;
		}
		if(status.equals("died")){//check if died
			music.playEat();
			treetouch=false;
			life--;
			lives.remove(lives.size()-1);
			if(life < 1){
				end=true;
			}
		}
		if(status.equals("win")){//check if win
			music.playWin();
			win=true;
		}
		if(status.equals("door")){//check if hit door
			music.playDoor();
			mapLoc=sOrange.getLocation();
			treetouch=false;
		}
		if(status.equals("item")){ //check for items
			items.get(sOrange.getItemCount()-1).setBlank(false);;
			music.playCollect();
			treetouch=false;
		}
		if(status.equals("clear")){ //check if death animation complete
			mapLoc=sOrange.getLocation();
		}
		for(int index = 0; index < maps.get(mapLoc).getEnemies().size(); index++){
			maps.get(mapLoc).getEnemies().get(index).update();
	    }
	}  // update()
	
	/**
	 * grab the movement from frame when it is called
	 * @param left
	 * @param right
	 * @param up
	 * @param down
	 */
	public void getMovement(int left, int right, int up, int down){
		leftmv = left;
		rightmv = right;
		upmv = up;
		downmv = down;
	} //getMovement() //get movement from frame
	
	/**
	 * return all variable to start of game
	 * 
	 */
	public void restart(){
		end = false;
		treetouch = false;
		win = false;
		
		life = 3;
		sOrange = new SpriteOrange(60,60,life);
		mapLoc = 0;
		maps.set(0, new MapStart());
		maps.set(1, new MapFinish());
		
		lives.clear();
		for(int count = 0; count < life; count++){
			lives.add(new SpriteOrange((count*35+1085), 612, 1));
		}
		items.clear();
		for(int count = 0; count < 5; count++){
			items.add(new SpriteItem((count*30+1085), 660, true));
		}
			
	} //	restart()	//return settings to beginning of game
	
	/**
	 * overriding paintComponenet to draw game and sprites
	 */
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		this.setBackground(null);
		Graphics2D g2 = (Graphics2D)g;
	    @SuppressWarnings("unused")
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
	   
	    this.setOpaque(false);

	    maps.get(mapLoc).drawMap(g2);
	    for(int index = 0; index < maps.get(mapLoc).getSprites().size(); index++){
	    	maps.get(mapLoc).getSprites().get(index).drawSprite(g2);
	    }
	   
	    sOrange.drawOrange(g2);
		
	    for(int index = 0; index < maps.get(mapLoc).getEnemies().size(); index++){
	    	maps.get(mapLoc).getEnemies().get(index).drawSprite(g2);
	    }
	    //draw status block
	    g2.setColor(Color.black);
	    g2.fillRect(1080, 585, 150, 100);
	    g2.setColor(Color.white);
	    g2.drawRect(1080, 585, 150, 100);
	    g2.drawString("Life: ", 1085, 600);
	    g2.drawString("Water Collected: ", 1085, 655);
	    //
	    for(int index = 0; index < lives.size(); index++){
	    	lives.get(index).drawOrange(g2);
	    }
	    for(int index = 0; index < items.size(); index++){
	    	items.get(index).drawSprite(g2);
	    }
	    if(win){
	    	g2.setColor(Color.white);
	    	g2.setFont(new Font("Sans-Serif", Font.PLAIN, 42)); 
	    	g2.drawString("YOU WIN", 500, 300);
	    	g2.setFont(new Font("Sans-Serif", Font.PLAIN, 24)); 
	    	g2.drawString("(press \"Enter\" to play again)", 425, 430);
	    	g2.drawString("Thank you for playing Adventure Orange", 400, 570);
	    	g2.drawString("Game Developed by Ving Trung", 400, 600);
	    	g2.drawString("Music/Sounds from Zelda, Super Mario, and Pacman", 400, 630);
	    }
	    if(treetouch){
	    	g2.setColor(Color.white);
	    	g2.setFont(new Font("Sans-Serif", Font.PLAIN, 24)); 
	    	g2.drawString("You need more water!!", 500, 300);
	    }
	    if(end){
	    	g2.setColor(Color.white);
	    	g2.setFont(new Font("Sans-Serif", Font.PLAIN, 42)); 
	    	g2.drawString("GAME OVER", 500, 300);
	    	g2.setFont(new Font("Sans-Serif", Font.PLAIN, 24)); 
	    	g2.drawString("(press \"Enter\" to play again)", 460, 330);
	    }
	    
	}// paintComponent
	
} 

 // main
