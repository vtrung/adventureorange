package source;

//Author: Ving Trung
//Description: Adventure Orange Game
//Last Changed: May 6, 2014
//Files: source: DrawPanel.java; Map.java; MapFinish.java; MapStart.java;
//				MusicBox.java; MyFrame.java
//		sprites: Sprite.java; SpriteDoor.java; SpriteEnemy.java; SpriteItem.java;
//				SpriteOrange.java; SpriteTree.java; Wall.java;

import sprites.SpriteDoor;
import sprites.SpriteEnemy;
import sprites.SpriteItem;
import sprites.Wall;
/**
 * First Map contains first map image and sprites. extends Map Object
 * @author svingt
 * 
 * 
 */
public class MapStart extends Map{
	
	/**
	 * First Map contains first map image and sprites. extends Map Object
	 */
	public MapStart(){
		//Beginning Map
		super.loadImage("myImages/aNewLand.png");
		sprites.add(new SpriteDoor(1076,6,200,27,1,160,560));
		sprites.add(new SpriteDoor(1245,39,32,165,1,160,560));
		sprites.add(new Wall(0,165,200,550)); //water
		sprites.add(new Wall(202,435,354,286)); //water
		sprites.add(new Wall(198,162,12,205)); //greencliff1
		sprites.add(new Wall(200,362,166,16)); //greencliff1
		sprites.add(new Wall(365,92,4,275)); //greencliff1
		sprites.add(new Wall(445,92,4,100)); //greencliff2 west
		sprites.add(new Wall(445,191,19,16)); //greencliff2 west
		sprites.add(new Wall(462,203,4,112)); //greencliff2 west
		sprites.add(new Wall(462,317,98,18)); //greencliff2
		sprites.add(new Wall(560,334,4,320)); //greencliff2
		sprites.add(new Wall(560,655,30,15)); //greencliff2
		sprites.add(new Wall(590,637,120,15)); //greencliff2
		sprites.add(new Wall(1137,209,145,16)); //browncliff south top
		sprites.add(new Wall(1120,225,160,33)); //browncliff south
		sprites.add(new Wall(1105,258,172,34)); //browncliff south
		sprites.add(new Wall(1090,290,192,52));	//browncliff south
		sprites.add(new Wall(1075,339,190,50));	//browncliff south
		sprites.add(new Wall(1060,358,225,50)); //browncliff south
		sprites.add(new Wall(1040,403,244,152));//browncliff south
		sprites.add(new Wall(1024,547,260,145));//browncliff south
		sprites.add(new Wall(1044,692,237,30)); //browncliff south
		sprites.add(new Wall(850,0,223,23));	//browncliff north
		sprites.add(new Wall(850,25,206,28));	//browncliff north
		sprites.add(new Wall(850,55,190,86));	//browncliff north
		sprites.add(new Wall(880,142,158,23));	//browncliff north
		sprites.add(new Wall(900,170,125,20)); 	//browncliff north
		sprites.add(new Wall(913,190,78,13)); 	//browncliff north
		sprites.add(new Wall(675,650,350,7));	//south most wall
		
		sprites.add(new SpriteItem(700, 350, false)); //droplet desert
		sprites.add(new SpriteItem(230, 410, false));
		sprites.add(new SpriteItem(600, 600, false));
		sprites.add(new SpriteItem(300, 290, false));
		
		enemies.add(new SpriteEnemy(100,100,210,30)); //first bug
		enemies.add(new SpriteEnemy(270,80,40,200)); //second bug
		enemies.add(new SpriteEnemy(270,400,200,0)); // beach bug
		enemies.add(new SpriteEnemy(580,500,50,100)); // south bug
		enemies.add(new SpriteEnemy(700,300,300,50)); // desert bug
		enemies.add(new SpriteEnemy(500,30,200,100));
		enemies.add(new SpriteEnemy(670,322,40,40));
		enemies.add(new SpriteEnemy(680,420,200,170));
		
	}
}
