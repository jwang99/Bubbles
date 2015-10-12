//Christina Lau
//4-20-15
//JC1.java is the menu of the game, it leads to the game, instructions, and credits

import java.awt.*; //import libraries

import javax.swing.*;

import java.awt.event.*;
//import javax.swing.event.*;


public class JCMain extends JFrame//jframe
{
	Panel1 panel1= new Panel1();
    Panel2 panel2= new Panel2();
    Panel3 panel3= new Panel3();
	Panel4 panel4= new Panel4();
	CardPages cP;
	CardLayout ccc;
	
	//private boolean booleanV=false;
	
	public static void main (String [] args)//main
	{
	 JCMain ff= new JCMain();
	}
       

        public JCMain()//constructor
        { 
             super ("Bubbles Menu");
             setSize (1000, 800);
             setDefaultCloseOperation(DISPOSE_ON_CLOSE);
             setLocation(0, 0);
             setResizable(true); 
			
			 cP = new CardPages();			// object for pages CardLayout class
			 add(cP);						// add CardLayout object to the container
			 ccc.show(cP, "p1");	
			  setVisible(true);
        }




class CardPages extends JPanel//class five implements ActionListener, is a cardlayout
{				
		public CardPages()
		{
			ccc = new CardLayout();		// create CardLayout object
			setLayout(ccc);				// set to CardLayout
			add(panel1, "p1");		// add classes objects as card pages
			add(panel2, "p2");	
			add(panel3, "p3");
			add(panel4, "p4");
	}
}

class Panel1 extends JPanel implements MouseListener, MouseMotionListener{//class Panel 1 is the Menu page, it has three buttons on it "Start Game", "Instructions", and "Credits", buttons will change cards
			private Image i;
			private Image start;
			private Image startselected;
			private Image instructions;
			private Image instructionsselected;
			private Image credits;
			private Image creditsselected;
			private boolean sselected = false;
			private boolean iselected = false;
			private boolean cselected = false;
			public Panel1()
			{
				setLayout(new GridLayout(4,1, 10, 10));
				
				i = Toolkit.getDefaultToolkit().getImage("menupic.png");
				start = Toolkit.getDefaultToolkit().getImage("start.png");
				startselected= Toolkit.getDefaultToolkit().getImage("startselected.png");
				instructions = Toolkit.getDefaultToolkit().getImage("instructions.png");
				instructionsselected = Toolkit.getDefaultToolkit().getImage("instructionsselected.png");
				credits = Toolkit.getDefaultToolkit().getImage("credits.png");	
				creditsselected = Toolkit.getDefaultToolkit().getImage("creditsselected.png");

				addMouseListener(this);
				addMouseMotionListener(this);
			}
			
	  
        public void paintComponent(Graphics g)
        {//paint component
        	//super.paintComponent(g);//draw background
        		g.drawImage(i, 0,0,1000,800,this);
        		if (sselected){
        			g.drawImage(startselected, 350,300,this);
        		}
        		else{
        			g.drawImage(start, 350,300,this);
        		}
        		if(iselected){
        			g.drawImage(instructionsselected, 350,450,this);
        		}
        		else{
        			g.drawImage(instructions, 350,450,this);
        		}
        		if(cselected){
        			g.drawImage(creditsselected, 350,600,this);
        		}
        		else{
        			g.drawImage(credits, 350,600,this);
        		}
        }      
        
         public void mouseClicked (MouseEvent e) { 
        	 	int mouseX = e.getX();
        	 	int mouseY = e.getY();
			 	if(mouseX>= 350 && mouseX <= 650){
			 		if (mouseY>= 300 && mouseY <=400 ){
                        ccc.show(cP, "p2");
                        panel2.jc.panel2.jc7.panel1.redo();
						panel2.jc.panel4.jc.panel1.redo();
						panel2.jc.panel3.jcAddition.panel1.redo();
			 		}
			 		else if (mouseY >= 450 && mouseY <= 550){          
                        ccc.show(cP, "p3");
						
			 		}
			 		else if (mouseY >= 600 && mouseY <= 700){
			 			ccc.show(cP, "p4");
						
			 		}
			 	}
       }
         public void mouseReleased(MouseEvent e){}
         public void mousePressed(MouseEvent e){}
         public void mouseEntered(MouseEvent e){}
         public void mouseExited(MouseEvent e){}
         public void mouseDragged(MouseEvent e){}
         public void mouseMoved(MouseEvent e){
        	// System.out.println("mousemoved");
        	 int mouseX = e.getX();
     	 	int mouseY = e.getY();
			 	if(mouseX>= 350 && mouseX <= 650){
			 		if (mouseY>= 300 && mouseY <=400 ){
			 			//System.out.println("sselected");
			 			sselected = true;
			 		}
			 		else{
			 			//System.out.println("")
			 			sselected = false;
			 		}
			 		if (mouseY >= 450 && mouseY <= 550){          
                     iselected = true;
			 		}
			 		else{
			 			iselected = false;
			 		}
			 		if (mouseY >= 600 && mouseY <= 700){
			 			cselected = true;
			 		}
			 		else{
			 			cselected = false;
			 		}
			 	}
			 	else{
			 		sselected = false;
			 		iselected = false;
			 		cselected = false;
			 	}
			 		
			 	repaint();
        	 
         }
	 
}

class Panel2 extends JPanel implements ActionListener{//class Panel 2 is the page where the game starts (at level 1), for now this page will be left blank and later the game code will be added in
	private JButton d;//global button 
	JCLevels jc;
	
	Panel2(){
		setBackground(Color.GREEN);
		repaint();
		setLayout(new BorderLayout(5, 5));//set border layout
		d= new JButton("Back to Home Page");//add button for leading back to home page
	    d.addActionListener(this);//add listener to button
	    add(d, BorderLayout.SOUTH); //add button to panel on the bottom
	    jc= new JCLevels();
	    add(jc, BorderLayout.CENTER);
	}
	public void paintComponent(Graphics g)
        {//paint component
                super.paintComponent(g);//draw background
                Font f= new Font("Serif", Font.BOLD, 80);//set font serif to bold and size 40
                 g.setColor(Color.BLACK);
                 g.drawString("Game under Construction", 50, 90);
                     
        }    
	public void actionPerformed (ActionEvent e) { //event handler for button\(actionPreformed)
	        	 ccc.show(cP, "p1");		// go back to the front page card
	      	 }  

}

class Panel3 extends JPanel implements ActionListener{//class Panel 3 is the instructions page. We will use a text area for this
	private JButton dd;
	private JTextArea ta;
	Panel3(){
		setBackground(Color.RED);
		repaint();
		setLayout(new BorderLayout(5, 5));//set border layout
		dd= new JButton("Back to Home Page");//add button for leading back to home page
	    dd.addActionListener(this);//add listener to button
	    add(dd, BorderLayout.SOUTH); //add button to panel on the bottom
	    ta=new JTextArea("Welcome to Bubbles! The game is very simple. You are a red bubble, all other bubbles are blue. You must avoid all bubbles whose values are greater than you, and eat all bubbles whose values are less than you. When you eat a smaller bubble, your value will combine with the eaten bubble, causing you to grow bigger and bigger. You have thirty seconds to eat as much bubbles as you can, but if you get eaten by a bigger bubble, you die right there. Try to get a high score!");
	    ta.setLineWrap(true);
	    add(ta, BorderLayout.CENTER);
	} 
	public void paintComponent(Graphics g)
	{//paint component
		setBackground(Color.RED);
        super.paintComponent(g);//draw background
                     
    }  
    public void actionPerformed (ActionEvent e) { //event handler for button\(actionPreformed)
	    ccc.show(cP, "p1");		// go back to the front page card
	}  
}

class Panel4 extends JPanel implements ActionListener{//class Panel 4 is the credits page, for now this page will be left blank
	private JButton ddd;
	 Panel4(){
		setBackground(Color.BLUE);
		repaint();
		setLayout(new BorderLayout(0,0));//set border layout
		ddd= new JButton("Back to Home Page");//add button for leading back to home page
	    ddd.addActionListener(this);//add listener to button
	    add(ddd, BorderLayout.SOUTH); //add button to panel on the bottom
	}
	public void paintComponent(Graphics g)
        {//paint component
                super.paintComponent(g);//draw background
                Font f= new Font("Serif", Font.BOLD, 80);//set font serif to bold and size 40
                 g.setColor(Color.BLACK);
                 g.drawString("Credits Page under Construction", 50, 90);
                     
        }   
    public void actionPerformed (ActionEvent e) { //event handler for button\(actionPreformed)
	    ccc.show(cP, "p1");		// go back to the front page card
	}   
}
}