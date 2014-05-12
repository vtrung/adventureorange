package sprites;
/**
 * sprite of type 'Tree' and load tree image
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
public class SpriteTree extends Sprite {
	/**
	 * Create sprite of type 'Tree' and load tree image
	 * @param x
	 * @param y
	 */
	public SpriteTree(int x, int y){
		super(x,y,120,120);
		super.type="Tree";
		super.loadImage("myImages/tree.png");
	}
}
