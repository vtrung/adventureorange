package source;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * Container for Game DrawPanel with action listener for arrow and enter keys
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
public class MyFrame extends JFrame implements KeyListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int moveSpeed = 2;
	private int upmv = 0;
	private int downmv = 0;
	private int leftmv = 0;
	private int rightmv = 0;
	private DrawPanel panel = new DrawPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setTitle("Adventure Orange");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setFocusable(true);
		contentPane.setLayout(null);
		
		panel.setFocusable(true); 
		panel.addKeyListener(this);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 1280, 720);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon(MyFrame.class.getResource("/myImages/aNewLand.png")));
		//label.setBounds(0, 0, 1280, 720);
		//contentPane.add(label);
	} //myFrame()
	
	@Override
	/**
	 * Reads arrow keys and if the game has ended, it reads the enter key
	 */
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Key Code Pressed: " + arg0.getKeyCode());
		switch(arg0.getKeyCode()){
		case 10:
			if(panel.end || panel.win){
				panel.restart(); //if game ended, press enter to restart
			}
			break;
		case 37:
			leftmv = moveSpeed;
			//System.out.println("Left");
			break;
		case 38:
			upmv = moveSpeed;
			//System.out.println("Up");
			break;
		case 39:
			rightmv = moveSpeed;
			//System.out.println("Right");
			break;
		case 40:
			downmv = moveSpeed;
			//System.out.println("Down");
			break;
		default:
		}
		panel.getMovement(leftmv, rightmv, upmv, downmv);
	}

	/**
	 * Reads arrow keys 
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Key Code Released: " + arg0.getKeyCode());
		switch(arg0.getKeyCode()){
		case 37:
			leftmv = 0;
			//System.out.println("Left");
			break;
		case 38:
			upmv = 0;
			//System.out.println("Up");
			break;
		case 39:
			rightmv = 0;
			//System.out.println("Right");
			break;
		case 40:
			downmv = 0;
			//System.out.println("Down");
			break;
		default:
		}
		panel.getMovement(leftmv, rightmv, upmv, downmv);
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
