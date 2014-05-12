package sprites;
/**
 * sprite type "Item" and load image for item
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

public class SpriteItem extends Sprite {
	private boolean blank = false;
	
	/**
	 * create sprite type "Item" and load image for item
	 * @param x
	 * @param y
	 * @param blank
	 */
	public SpriteItem(int x, int y, boolean blank){
		super(x, y, 11,18);
		super.type="Item";
		this.blank = blank;
		if(blank)
			super.loadImage("myImages/dropb.png");
		else
			super.loadImage("myImages/drop.png");
	}//	SpriteItem()
	
	/**
	 * set if drop image should be blank or not
	 * @param blank
	 */
	public void setBlank(boolean blank){ //set empty pic or not
		this.blank=blank;
		if(blank){
			super.loadImage("myImages/dropb.png");
		} else {
			super.loadImage("myImages/drop.png");
		}
	}//	setBlank()

	/**
	 * get if sprite is blank or not
	 * @return boolean
	 */
	public boolean isBlank() { //check if empty
		return blank;
	}//	isBlank()
	
}
