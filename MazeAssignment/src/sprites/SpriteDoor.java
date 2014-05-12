package sprites;
/**
 * Sprite type "Door" contains information to for hero sprite to teleport to new map
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
public class SpriteDoor extends Sprite{
	
	public int location;
	private int startingx;
	private int startingy;
	
	/**
	 * build sprite with type "Door" and the maplocation destination and starting points
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param maplocation
	 * @param startingx
	 * @param startingy
	 */
	public SpriteDoor(int x, int y, int width, int height, int maplocation, int startingx, int startingy){
		super(x, y, width, height);
		super.type = "Door";
		this.location = maplocation;
		this.startingx = startingx;
		this.startingy = startingy;
	}
	
	/**
	 * get starting x location
	 * @return int
	 */
	public int getStartingx() {
		return startingx;
	}

	/**
	 * set starting x location
	 * @param startingx
	 */
	public void setStartingx(int startingx) {
		this.startingx = startingx;
	}

	/**
	 * get starting x location
	 * @return int
	 */
	public int getStartingy() {
		return startingy;
	}

	/**
	 * set starting y location
	 * @param startingy
	 */
	public void setStartingy(int startingy) {
		this.startingy = startingy;
	}

	/**
	 * get destination of door
	 * @return int
	 */
	public int getLocation() {
		return location;
	}

	/**
	 * set destination of wall
	 * @param location
	 */
	public void setLocation(int location) {
		this.location = location;
	}
	
}
