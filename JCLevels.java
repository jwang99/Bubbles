//Christina Lau and Jasmine Wang
//4-20-15
//JC1.java is the menu of the game, it leads to the game, instructions, and credits

import java.awt.*; //import libraries
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class JCLevels extends JPanel//jframe
{
	Panel1 panel1= new Panel1();
	Panel2 panel2= new Panel2();
    Panel3 panel3= new Panel3();
	Panel4 panel4= new Panel4();
	CardPages cP;
	CardLayout ccc;
	
	JCLevels()
		{
			setLayout(new GridLayout(1, 1, 0, 0));
			cP = new CardPages();			// object for pages CardLayout class
			add(cP);						// add CardLayout object to the container
			ccc.show(cP, "p1");
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
	private Image levelspic;
	private boolean integers = false;
	private boolean addition = false;
	private boolean subtraction = false;
			public Panel1()
			{
				addMouseListener(this);
				addMouseMotionListener(this);
				levelspic = Toolkit.getDefaultToolkit().getImage("levelspic.png");
				
			}
			
	  
        public void paintComponent(Graphics g)
        {//paint component
                super.paintComponent(g);//draw background
                g.drawImage(levelspic, 0,0,this);
				g.setFont(new Font("Snap ITC", Font.PLAIN, 50));
				Color blue = new Color(95,200,255);
				if (!integers){
					g.setColor(Color.WHITE);
					g.fillRect(350,300,300,100);
					g.setColor(blue);
					g.drawString("Integers",350,375);
				}
				else{
					g.setColor(blue);
					g.fillRect(350,300,300,100);
					g.setColor(Color.WHITE);
					g.drawString("Integers",350,375);
				}
				if (!addition){
					g.setColor(Color.WHITE);
					g.fillRect(350,450,300,100);
					g.setColor(blue);
					g.drawString("Addition",350,525);
				}
				else{
					g.setColor(blue);
					g.fillRect(350,450,300,100);
					g.setColor(Color.WHITE);
					g.drawString("Addition",350,525);
				}
				g.setFont(new Font("Snap ITC", Font.PLAIN, 45));
				if (!subtraction){
					g.setColor(Color.WHITE);
					g.fillRect(350,600,300,100);
					g.setColor(blue);
					g.drawString("Subtraction",350,675);
				}
				else{
					g.setColor(blue);
					g.fillRect(350,600,300,100);
					g.setColor(Color.WHITE);
					g.drawString("Subtraction",350,675);
				}
        }      
        
         public void mousePressed(MouseEvent e){}
		 public void mouseReleased(MouseEvent e){}
		 public void mouseEntered(MouseEvent e){}
		 public void mouseExited(MouseEvent e){}
		 public void mouseClicked(MouseEvent e)
		 {int mouseX = e.getX();
        	 	int mouseY = e.getY();
			 	if(mouseX>= 350 && mouseX <= 650){
			 		if (mouseY>= 300 && mouseY <=400 ){
                        ccc.show(cP, "p2");
                       
						panel2.jc7.panel1.redo();
						
						
						
			 		}
			 		else if (mouseY >= 450 && mouseY <= 550){     
					panel3.jcAddition.panel1.redo();     
                        ccc.show(cP, "p3");
			 		}
			 		else if (mouseY >= 600 && mouseY <= 700){
					panel4.jc.panel1.redo();
			 			ccc.show(cP, "p4");
			 		}
			 	}
		 }
		 public void mouseMoved(MouseEvent e)
		 {
		 	int mouseX = e.getX();
			int mouseY = e.getY();
			if(mouseX>= 350 && mouseX <= 650){
			 		if (mouseY>= 300 && mouseY <=400 ){
			 			//System.out.println("sselected");
			 			integers = true;
			 		}
			 		else{
			 			//System.out.println("")
			 			integers = false;
			 		}
			 		if (mouseY >= 450 && mouseY <= 550){          
                     	addition = true;
			 		}
			 		else{
			 			addition = false;
			 		}
			 		if (mouseY >= 600 && mouseY <= 700){
			 			subtraction = true;
			 		}
			 		else{
			 			subtraction = false;
			 		}
			 	}
			 	else{
			 		addition = false;
			 		integers = false;
			 		subtraction = false;
			 	}
			 		
			 	repaint();
		 }
		 public void mouseDragged(MouseEvent e){}
			 	
       }  
	 


class Panel2 extends JPanel implements ActionListener{//class Panel 2 is the page where the game starts (at level 1), for now this page will be left blank and later the game code will be added in
	private JButton d;//global button 
	JCOriginal jc7;
	
	Panel2(){
		setBackground(Color.GREEN);
		repaint();
		setLayout(new BorderLayout(5, 5));//set border layout
		d= new JButton("Back to Levels");//add button for leading back to home page
	    d.addActionListener(this);//add listener to button
	    add(d, BorderLayout.SOUTH); //add button to panel on the bottom
	    jc7= new JCOriginal();
	    add(jc7, BorderLayout.CENTER);
	}
	public void paintComponent(Graphics g)
        {//paint component
                super.paintComponent(g);//draw background
                     
        }    
	public void actionPerformed (ActionEvent e) { //event handler for button\(actionPreformed)
				jc7.panel1.redo();
	        	 ccc.show(cP, "p1");		// go back to the front page card
	      	 }  
}

class Panel3 extends JPanel implements ActionListener{//class Panel 3 is the instructions page. We will use a text area for this
	private JButton d;//global button 
	JCAddition jcAddition;
	
	Panel3(){
		setBackground(Color.GREEN);
		repaint();
		setLayout(new BorderLayout(5, 5));//set border layout
		d= new JButton("Back to Levels");//add button for leading back to home page
	    d.addActionListener(this);//add listener to button
	    add(d, BorderLayout.SOUTH); //add button to panel on the bottom
	    jcAddition= new JCAddition();
	    add(jcAddition, BorderLayout.CENTER);
	}
	public void paintComponent(Graphics g)
        {//paint component
                super.paintComponent(g);//draw background
                     
        }    
	public void actionPerformed (ActionEvent e) { //event handler for button\(actionPreformed)
				jcAddition.panel1.redo();
	        	 ccc.show(cP, "p1");		// go back to the front page card
	      	 }  
}

class Panel4 extends JPanel implements ActionListener{//class Panel 4 is the credits page, for now this page will be left blank
	private JButton d;//global button 
	JCSubtraction jc;
	
	Panel4(){
		setBackground(Color.GREEN);
		repaint();
		setLayout(new BorderLayout(5, 5));//set border layout
		d= new JButton("Back to Levels");//add button for leading back to home page
	    d.addActionListener(this);//add listener to button
	    add(d, BorderLayout.SOUTH); //add button to panel on the bottom
	    jc= new JCSubtraction();
	    add(jc, BorderLayout.CENTER);
	}
	public void paintComponent(Graphics g)
        {//paint component
                super.paintComponent(g);//draw background
                System.out.println("Here 1");
                     
        }    
	public void actionPerformed (ActionEvent e) { //event handler for button\(actionPreformed)
	        	jc.panel1.redo();
				 ccc.show(cP, "p1");		// go back to the front page card
	      	 }  
}
}
