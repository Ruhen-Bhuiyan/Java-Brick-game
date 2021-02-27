import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener, ActionListener{
	private boolean letsplay=false;
	private int score = 0;
	private int numberofbricks=15;
	private Timer timer;
	private int delay= 5;
	private int player1=210;
	private int ballpositionx=300;
	private int ballpositiony=300;
	private int ballXdirec=-1;
	private int ballYdirec=-2;
	private Map themap;
	public Game() {
		themap=new Map(4,6);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay,this);
		timer.start();
	}
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(1,1,1360,592);
		themap.letsdraw((Graphics2D)g);
		g.setColor(Color.yellow);
		g.fillRect(0,0,2,1350);
		g.fillRect(0,0,1350,3);
		g.fillRect(1350,0,1,592);
		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString(""+score,590,30);
		
		g.setColor(Color.pink);
		g.fillRect(player1,590,100,8);
		
		g.setColor(Color.yellow);
		g.fillOval(ballpositionx,ballpositiony,20,20);
		if(ballpositiony>1350){
			letsplay=false;
			ballXdirec=0;
			ballYdirec=0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("Game over:",190,300);

			g.setFont(new Font("serif",Font.BOLD,20));
			g.drawString("Press Enter to restart:",230,350);
			}
		g.dispose();
		
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		if(letsplay){
		if(new Rectangle(ballpositionx,ballpositiony,20,20).intersects(new Rectangle(player1,550,100,8))){
		ballYdirec=-ballYdirec;
		}
		A: for(int i=0;i<themap.arr.length;i++){
			for(int j=0;j<themap.arr[0].length;j++){
				if(themap.arr[i][j]>0){
					int brickx=j*themap.theWidth+80;
					int bricky=i*themap.theHeight+80;
					int brickWidth=themap.theWidth;
					int brickHeight=themap.theHeight;
					Rectangle rect = new Rectangle(brickx,bricky,brickWidth,brickHeight);
					Rectangle ballRectan=new Rectangle(ballpositionx,ballpositiony,20,20);
					Rectangle brickRectan=rect;
					if(ballRectan.intersects(brickRectan)){
						themap.setValue(0,i,j);
						numberofbricks++;
						score+=5;
						if(ballpositionx+19<=brickRectan.x||ballpositionx+1>=brickRectan.x+brickRectan.width){
							ballXdirec=-ballXdirec;
						} else {
							ballYdirec=-ballYdirec;
						}
						break A;
					}
				}
			}
			}
		ballpositionx+=ballXdirec;
		ballpositiony+=ballYdirec;
		if(ballpositionx<0){
		ballXdirec=-ballXdirec;
		}
		if(ballpositiony<0){
		ballYdirec=-ballYdirec;
		}
		if(ballpositionx>1350){
		ballXdirec=-ballXdirec;
		}
		}
		repaint();
		}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			if(player1>=1350){
			player1=1350;
			}else{
			movetoRight();
			}
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT){
			if(player1<10){
			player1=10;
			}else{
			movetoLeft();
			}
			}
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				if(!letsplay){
					letsplay=true;
					ballpositionx=120;
					ballpositiony=350;
					ballXdirec=-1;
					ballYdirec=-2;
					player1=310;
					score=0;
					numberofbricks=15;
					themap=new Map(3,7);
					repaint();

				}
				}
			}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
			}
	public void movetoRight(){
		letsplay=true;
		player1+=20;
		}
	public void movetoLeft(){
		letsplay=true;
		player1-=20;
		}
}
