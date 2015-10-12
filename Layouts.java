import javax.swing.*;
import java.awt.*;
public class Layouts extends JFrame{
	public static void main(String[]args){
		Layouts l = new Layouts();
	}
	public Layouts(){
		 super ("Layouts");
             setSize (500, 500);
             setDefaultCloseOperation(DISPOSE_ON_CLOSE);
             setLocation(0, 0);
             setResizable(false); 
			
			 Geh g = new Geh();			// object for pages CardLayout class
			 add(g);						// add CardLayout object to the container
			 setVisible(true);
	}
class Geh extends JPanel{
	public Geh(){
		BorderLayout b = new BorderLayout();
		Blue bl = new Blue();
		Red r = new Red();
		Center c = new Center();
		setLayout(b);
		add(r, BorderLayout.SOUTH);
		add(bl, BorderLayout.WEST);
		add(c, BorderLayout.CENTER);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}

class Blue extends JPanel{
	public Blue(){
		setPreferredSize(new Dimension(75,425));
	}
	public void paintComponent(Graphics g){
		setBackground(Color.BLUE);
		super.paintComponent(g);
		g.setColor(Color.RED);
		//g.fillRect(0,0,75,100);
	}
}
class Red extends JPanel{
	public Red(){
		setPreferredSize(new Dimension(500,75));
	}
	public void paintComponent(Graphics g){
		setBackground(Color.RED);
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		//g.fillRect(0,0,100,7);
	}
}
class Center extends JPanel{
	public Center(){
		BorderLayout b = new BorderLayout();
		JLabel one = new JLabel("Center Panel");
		one.setFont(new Font("Serif", Font.PLAIN, 30));
		one.setBackground(Color.WHITE);
		JLabel left = new JLabel(" ");
		left.setFont(new Font("Serif", Font.PLAIN, 30));
		left.setBackground(Color.WHITE);
		JLabel bottom = new JLabel(" ");
		bottom.setFont(new Font("Serif", Font.PLAIN, 40));
		bottom.setBackground(Color.WHITE);
		JLabel right = new JLabel(" ");
		right.setFont(new Font("Serif", Font.PLAIN, 30));
		right.setBackground(Color.WHITE);
		JPanel yellow = new JPanel();
		yellow.setBackground(Color.YELLOW);
		yellow.setLayout(new GridLayout(2,4));
		setLayout(b);
		add(one, BorderLayout.NORTH);
		add(left, BorderLayout.WEST);
		add(right,BorderLayout.EAST);
		add(bottom,BorderLayout.SOUTH);
		add(yellow,BorderLayout.CENTER);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
}