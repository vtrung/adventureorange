package source;
/**
 * 
 * @author svingt
 * @param add
 * 
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import sprites.Sprite;
import sprites.SpriteEnemy;
//Author: Ving Trung
//Description: Adventure Orange Game
//Last Changed: May 6, 2014
//Files: source: DrawPanel.java; Map.java; MapFinish.java; MapStart.java;
//					MusicBox.java; MyFrame.java
//			sprites: Sprite.java; SpriteDoor.java; SpriteEnemy.java; SpriteItem.java;
//					SpriteOrange.java; SpriteTree.java; Wall.java;
/**
 * Create Map object that contain background image and sprites
 * @author svingt
 *
 */
public class Map {
	protected ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	protected ArrayList<SpriteEnemy> enemies = new ArrayList<SpriteEnemy>();
	protected Image BackgroundImage = null;
	
	/**
	 * Create Map object that contain background image and sprites
	 */
	public Map(){}

	/**
	 * get ArrayList of Sprites within map
	 * @return ArrayList<Sprite>
	 */
	public ArrayList<Sprite> getSprites() {
		return sprites;
	} //	getSprites()

	/**
	 * set ArrayList of sprites for map
	 * @param sprites
	 */
	public void setSprites(ArrayList<Sprite> sprites) {
		this.sprites = sprites;
	}//		setSprites()

	/**
	 * get ArrayList of enemy sprites for map
	 * @return ArrayList<SpriteEnemy>
	 */
	public ArrayList<SpriteEnemy> getEnemies() {
		return enemies;
	}//		getEnemies()
	
	/**
	 * set ArrayList of enemy sprites for map
	 * @param enemies
	 */
	public void setEnemies(ArrayList<SpriteEnemy> enemies) {
		this.enemies = enemies;
	}//		setEnemies()
	
	/**
	 * load image with imgFileName to BackgroundImage to be drawn
	 * @param imgFileName
	 */
	protected void loadImage(String imgFileName) 
	{
	      URL imgUrl = getClass().getClassLoader().getResource(imgFileName); // get a imgURL pointer to the file.
	      
	      if (imgUrl == null) // check to see the file exists.
	      { 
	         System.err.println("Couldn't find file: " + imgFileName);
	      } // if
	      else 
	      {
	         try 
	         { // if it exists try to load it.
	            BackgroundImage = ImageIO.read(imgUrl);  // load image via URL
	         } // try 
	         catch (IOException ex) 
	         {
	            ex.printStackTrace();
	         } // catch
	      } // else
	} // loadImage
	
	/**
	 * draw the background image that was loaded into Map Object
	 * @param g2d
	 */
	public void drawMap (Graphics2D g2d)
	{
		//if (SpriteVisible) // if the sprite is visible then draw it.
			// draw the sprite at location x,y.
			g2d.drawImage(BackgroundImage,0,0,1280, 720,0,0,1280, 720,null);
		
	} //	drawMap()
}
