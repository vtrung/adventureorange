package sprites;
/**
 * sprite of type "Wall"
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

public class Wall extends Sprite{
	/**
	 * Create sprite of type "Wall"
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Wall(int x, int y, int width, int height){
		super(x, y, width, height);
		super.type = "Wall";
	}
	
}
