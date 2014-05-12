package sprites;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
/**
 * sprite type Orange with lives and includes movement and collision processor
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
public class SpriteOrange extends Sprite{
	protected int x;
	protected int y;
	private int xtemp;
	private int ytemp;
	protected int lives;
	private int itemcount = 0;
	private int xstart, ystart;
	private int winx = 670;
	private int winy = 420;
	private int mapLoc = 0;
	protected  double size = 0.9;
	protected  double maxSize = 1;
	protected  double growSpeed = 0.002; //speed of orange growth until it falls
	private boolean death=false;
	private boolean win=false;
	
	private int xCenter;
	private int yCenter;
	private int[] polyX = new int[6];
	private int[] polyY = new int[6];
	private int[] offsetX = {0, 0, 5, 10, 10, 2};
	private int[] offsetY = {-10, -15, -25, -25, -15, -10};
	
	/**
	 * 
	 * Create sprite type Orange with lives
	 * @param x
	 * @param y
	 * @param lives
	 */
	public SpriteOrange(int x, int y, int lives){
		super(x,y,28,30);
		this.x=x;
		this.y=y;
		this.xstart=x;
		this.ystart=y;
		this.lives=lives;
		mapLoc = 0;
		itemcount = 0;
		death = false;
		win = false;
	} // SpriteOrange() //Set starting parameters
	
	/**
	 * return orange to starting point when sprite dies
	 */
	private void refresh(){
		x=xstart;
		y=ystart;
		death=false;
		size=0.9;
	}//		refresh() //start at starting position
	
	/**
	 * get the current map location of sprite
	 * @return int
	 */
	public int getLocation(){
		return mapLoc;
	} //	getLocation()
	
	/**
	 * get the current item collected of sprite
	 * @return int
	 */
	public int getItemCount(){
		return itemcount;
	} //	getItemCount()
	
	/**
	 * process the collisions and update the position of sprite based on collisions
	 * @param left
	 * @param right
	 * @param up
	 * @param down
	 * @param sprites
	 * @param enemies
	 * @return String
	 */
	public String update(int left, int right, int up, int down, ArrayList<Sprite> sprites, ArrayList<SpriteEnemy> enemies){
		if(win){
			growSpeed = Math.abs(growSpeed);
			if(size >= 0.3){
				size = size - (2*growSpeed);
			} else {
				return "end";
			}
			if(this.x > (winx+2))
				this.x--;
			if(this.x < (winx-2))
				this.x++;
			if(this.y > (winy-2))
				this.y--;
			if(this.y < (winy+2))
				this.y++;		
		} //after win, win animation
		
		if(death){
			growSpeed = Math.abs(growSpeed);
			if(size > 0.4){
				size = size - (4*growSpeed);
			} else {
				refresh();
				return "clear"; //finished dying
			}
			return "null"; //not finished
		} else { //reading controls if not dead
			xtemp=this.x;
			ytemp=this.y;
			if( xtemp > 0)
				xtemp = xtemp - left;	
			if( xtemp < 1245)
				xtemp = xtemp + right;
			if( ytemp > 0)
				ytemp = ytemp - up;
			if( ytemp < 665)
				ytemp = ytemp + down;
			if(size > 1)
				growSpeed = -growSpeed;
			if(size < 0.9)
				growSpeed = -growSpeed;
			size += growSpeed;
			super.updateBound(xtemp, ytemp);
			
			//check collision with enemies
			for(int index = 0; index < enemies.size();index++){
				if(super.SpriteBounds.intersects(enemies.get(index).SpriteBounds)){
					death=true;
					if(lives < 0){ // check if stick have lives
						return "gameover";
					}
					mapLoc=0;
					lives--;
					return "died";
				}
			}
			
			/**
			 * check collisions
			 */
			for(int index = 0; index < sprites.size();index++){
				if(super.SpriteBounds.intersects(sprites.get(index).SpriteBounds)){
					if(sprites.get(index).getType().equals("Wall")){ //don't move if wall
						xtemp = this.x;	
						ytemp = this.y;
						super.updateBound(xtemp, ytemp);
						return "wall";
					}
					if(sprites.get(index).getType().equals("Item")){ //collect item if item
						sprites.remove(index);
						itemcount++;
						return "item";
					}
					if(sprites.get(index).getType().equals("Door")){ //change map if door
						this.x = ((SpriteDoor)sprites.get(index)).getStartingx();
						this.y = ((SpriteDoor)sprites.get(index)).getStartingy();
						mapLoc = ((SpriteDoor)sprites.get(index)).getLocation();
						return "door";
					}
					if(sprites.get(index).getType().equals("Tree")){// check if win if tree
						if(itemcount>4){
							win=true;
							return "win";
						};
						return "tree";
					}
					
				}
			}
			
			this.x=xtemp;
			this.y=ytemp;
		}
		return "null";
	} //	update()
	
	/**
	 * draw Orange
	 * @param g2
	 */
	public void drawOrange(Graphics2D g2){

		xCenter = (int)(x + (30*size)/2); //25
		yCenter = (int)(y + (30*size)/2); //125
		
		//Setting Center point for polygon
		for(int index = 0; index < polyX.length; index++){
			polyX[index] = xCenter;
			polyY[index] = yCenter;
 		}
		//x,y point offset from center point for each corner of polygon
		//set into polyX and polyY
		for(int i = 0; i < 6; i++){
			polyX[i] += (int)(offsetX[i] * size);
			polyY[i] += (int)(offsetY[i] * size);
		};
		
		//Draw orange
		g2.setColor(Color.orange);
		g2.fillOval(x, y, (int)(30*size), (int)(30*size));
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(1));
		g2.drawOval(x, y, (int)(30*size), (int)(30*size));
		
		//Draw Polygon (leaf)
		g2.setColor(Color.green);
		g2.fillPolygon(polyX, polyY, 6);
		g2.setColor(Color.black);
		g2.drawPolygon(polyX, polyY, 6);
		
	} //drawOrange
}
