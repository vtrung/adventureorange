package source;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * MusicBox contain all music used for game as Clip objects to be called to play
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
public class MusicBox {
	public  Clip WLS_Sound = loadClip("/myMusic/WLS.wav");   // load and open the clip and assign it to WLS_Sound
	public  Clip ZeldaBackgroundMusic = loadClip("/myMusic/Zelda.wav");
	public  Clip eat = loadClip("/myMusic/pacman_eatfruit.wav"); 
	public  Clip bump = loadClip("/myMusic/smb_bump.wav");
	public  Clip collect = loadClip("/myMusic/smb_stomp.wav");  
	public  Clip win = loadClip("/myMusic/Fanfare_Stereo.wav"); 
	
	public MusicBox(){};
	
	/**
	 * play the winning music
	 */
	public void playWin(){
		stopClip(win);
		playClip(win);
	} //	playWin()
	
	/**
	 * play the door entry music
	 */
	public void playDoor(){
		stopClip(WLS_Sound);
		playClip(WLS_Sound);
	}//		playDoor()
	
	/**
	 * play the enemy eat music
	 */
	public void playEat(){
		stopClip(eat);
		playClip(eat);
	}//		playEat()
	
	/**
	 * play the wall bumping music
	 */
	public void playBump(){
		stopClip(bump);
		playClip(bump);
	}//	playBump
	
	/**
	 * play the collect an item music
	 */
	public void playCollect(){
		stopClip(collect);
		playClip(collect);
	}//	playCollect()
	
	/**
	 * load music with filename to a Clip object
	 * @param filename
	 */
	public Clip loadClip(String filename)
	{
		Clip clip = null;
		try
		{
			//AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(filename));   // either of these two lines of code will work.
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(MyFrame.class.getResource(filename)); // either of these two lines of code will work.
			clip = AudioSystem.getClip();
			clip.open( audioIn );
		}// try
		catch (Exception e)
		{
			e.printStackTrace();
		}// catch
		return(clip);	
	} // Clip
	
	@SuppressWarnings("static-access")
	/**
	 * looping the background music
	 * @param clip_number
	 */
	public void loopClip( int clip_number)
	{
		switch (clip_number)
		{
		case 1: 
			stopClip(ZeldaBackgroundMusic);
			ZeldaBackgroundMusic.loop(ZeldaBackgroundMusic.LOOP_CONTINUOUSLY);
		break;
		
		case 2:
			stopClip(WLS_Sound);
			WLS_Sound.loop(WLS_Sound.LOOP_CONTINUOUSLY);
		break;
		} // switch
		
	} // loopClip
	
	/**
	 * play selected clip
	 * @param clip
	 */
	public void playClip(Clip clip)
	{
		clip.start();
		
	} // playClip
	
	/**
	 * stop and reset selected clip
	 * @param clip
	 */
	public void stopClip(Clip clip )
	{
			//if (clip.isRunning() )
				//clip.stop();
			clip.setFramePosition(0);
		
	} // stopClip
	
}
