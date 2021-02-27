import javax.swing.JFrame;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame object = new JFrame();
		Game game=new Game();
		object.setBounds(10,10,700,600);
		object.setTitle("Let's play");
		object.setResizable(true);
		object.setVisible(true);
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		object.add(game);
	}

}
