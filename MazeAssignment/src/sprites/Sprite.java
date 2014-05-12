package sprites;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * General Sprite Object used to generate other sprites
 * @author svingt
 * 
 */
//Author: Ving Trung
//Description: Adventure Orange Game
//Last Changed: May 6, 2014
//Files: source: DrawPanel.java; Map.java; MapFinish.java; MapStart.java;
//					MusicBox.java; MyFrame.java
//			sprites: Sprite.java; SpriteDoor.java; SpriteEnemy.java; SpriteItem.java;
//					SpriteOrange.java; SpriteTree.java; Wall.java;

public class Sprite {
	private Image SpriteImage; 
	protected String type = "Sprite";
	protected int x; //position
	protected int y;
	public Rectangle SpriteBounds; 
	
	/**
	 * create sprite rectangle at x,y with width and height passed in
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Sprite(int x, int y, int width, int height){
		this.x=x;
		this.y=y;
		this.SpriteBounds = new Rectangle();
		this.SpriteBounds.x=x;
		this.SpriteBounds.y=y;
		this.SpriteBounds.height=height;
		this.SpriteBounds.width=width;
	} //	Sprite

	/**
	 * update the position of rectangle to x,y
	 * @param x
	 * @param y
	 */
	public void updateBound(int x, int y){
		this.SpriteBounds.x=x;
		this.SpriteBounds.y=y;
	}//	updateBound
	
	/**
	 * get the type of the sprite
	 * @return String
	 */
	public String getType(){
		return this.type;
	}//	getType()
	
	/**
	 * load imgFileName into an Image Object to be drawn
	 * @param imgFileName
	 */
	public void loadImage(String imgFileName) 
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
	            SpriteImage = ImageIO.read(imgUrl);  // load image via URL
	         } // try 
	         catch (IOException ex) 
	         {
	            ex.printStackTrace();
	         } // catch
	      } // else

	      // get the information from the image file into the SpriteBounds bounding Rectangle so that we can do collision detection later.
	      SpriteBounds.x = x; // the top left x coordinate of where the sprite is to be drawn on the screen gets put in the SpriteBounds Rectangle.
	      SpriteBounds.y = y; // the top left y coordinate of where the sprite is to be drawn on the screen gets put in the SpriteBounds Rectangle.
	      
	      // get the height and width of the image and assign it to the sprite's variables.
	      SpriteBounds.height = SpriteImage.getHeight(null); // get the height of the image.
	      SpriteBounds.width  = SpriteImage.getWidth(null);  // get the width of the image.
	      
	      //System.out.println("Sprite Bounds x is "+SpriteBounds.x+ " y "+SpriteBounds.y+" width "+SpriteBounds.width+" height "+SpriteBounds.height);	      
	} // loadImage
	
	/**
	 * Draw sprite Image
	 * @param g2d
	 */
	public void drawSprite (Graphics2D g2d)
	{
		//if (SpriteVisible) // if the sprite is visible then draw it.
			// draw the sprite at location x,y.
			g2d.drawImage(SpriteImage,x,y,null);
		
	}//	drawSprite

}
