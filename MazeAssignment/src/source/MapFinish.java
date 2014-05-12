package source;

import sprites.SpriteDoor;
import sprites.SpriteEnemy;
import sprites.SpriteItem;
import sprites.SpriteTree;
import sprites.Wall;
/**
 * Final Map extends on Map object
 * @author svingt
 * 
 * 
 */
public class MapFinish extends Map{
	//Author: Ving Trung
	//Description: Adventure Orange Game
	//Last Changed: May 6, 2014
	//Files: source: DrawPanel.java; Map.java; MapFinish.java; MapStart.java;
//						MusicBox.java; MyFrame.java
//				sprites: Sprite.java; SpriteDoor.java; SpriteEnemy.java; SpriteItem.java;
//						SpriteOrange.java; SpriteTree.java; Wall.java;
	/**
	 * Final Map extends on Map object
	 */
	public MapFinish(){
		super.loadImage("myImages/aNewLand2.png");
		sprites.add(new SpriteTree(620,400));
		sprites.add(new SpriteDoor(0,674,105,45,0,1158,108));
		sprites.add(new SpriteDoor(1245,39,32,165,1,160,560));
		sprites.add(new Wall(0,520,30,115)); //cliffs
		sprites.add(new Wall(0,483,40,33)); 
		sprites.add(new Wall(0,240,60,246));
		sprites.add(new Wall(0,0,1000,255));
		sprites.add(new Wall(111,688,21,31));
		sprites.add(new Wall(129,674,780,44));
		sprites.add(new Wall(880,260,130,470));
		
		sprites.add(new SpriteItem(350, 450, false));
		
		enemies.add(new SpriteEnemy(350,450,50,50));
		enemies.add(new SpriteEnemy(300,400,50,50));
		enemies.add(new SpriteEnemy(325,425,50,50));
	}
}
