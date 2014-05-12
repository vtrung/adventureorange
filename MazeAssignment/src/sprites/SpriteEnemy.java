package sprites;
/**
 * sprite type "Enemy" contain own moving algoritms to update its position
 * @author svingt
 * 
 * 
 */
//Author: Ving Trung
//Description: Adventure Orange Game
//Last Changed: May 6, 2014
//Files: source: DrawPanel.java; Map.java; MapFinish.java; MapStart.java;
//					MusicBox.java; MyFrame.java
//			sprites: Sprite.java; SpriteDoor.java; SpriteEnemy.java; SpriteItem.java;
//					SpriteOrange.java; SpriteTree.java; Wall.java;
public class SpriteEnemy extends Sprite{
	//private Random randgen = new Random(); 
	private int xspeed=1, yspeed=1;
	private int xstart, ystart;
	private int xlimit, ylimit;
	private boolean up = true;
	
	/**
	 * sprite type "Enemy" contain own moving algoritms to update its positio
	 * @param x
	 * @param y
	 * @param xbox
	 * @param ybox
	 */
	public SpriteEnemy(int x, int y, int xbox, int ybox){
		super(x,y,14,14);
		super.type="Enemy";
		this.xstart=x;
		this.ystart=y;
		this.xlimit=x+xbox;
		this.ylimit=y+ybox;
		
		super.loadImage("myImages/bug.png");
	}//		SpriteEnemy()
	
	/**
	 * update position of SpriteEnemy
	 */
	public void update(){
		
		if(up){
			if(this.x > xlimit || this.x < xstart){
				//System.out.println("x limit hit :" + this.x + ";" + this.xlimit);
				this.xspeed = -xspeed;
				this.x+=xspeed;
				this.SpriteBounds.x+=xspeed;
				this.up=false; //hitting bound, change directions
			} else {
				this.x+=xspeed;
				this.SpriteBounds.x+=xspeed;
			}
		} else {
			if(this.y > ylimit || this.y < ystart){
				//System.out.println("y limit hit :" + this.y + ";" + this.ylimit); 
				this.yspeed = -yspeed;
				this.y+=yspeed;
				this.SpriteBounds.y+=yspeed;
				this.up=true; //hitting bound, change directions
			} else {
				this.y+=yspeed;
				this.SpriteBounds.y+=yspeed;
			}
		}
	}//		update()
	
	
}
