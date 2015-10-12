//Christina Lau
//4-21-15
////First draft of game- level one only
//Testing plan: a bubble should follow the user's mouse. Should not need to click. 
//If the user encounters a bubble that is larger in value than itself: the user "dies" and must start over
//if the user encounters a bubble that is smaller in value than itself: the user's bubble adds the value to itself.

//all pseudocode was done by Jasmine

import javax.swing.*;

import java.awt.event.*;//import
import java.awt.*;

public class JCOriginal extends JPanel
{
	JC3 panel1= new JC3();
    GameOver panel2= new GameOver();
	YouWon panel3= new YouWon();
	CardPages cP;
	CardLayout ccc;
	
	JCOriginal()
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
	}
}
	
class JC3 extends JPanel implements MouseMotionListener, MouseListener, ActionListener//class GamePanel1 header, extends JPanel implements mousemotionlistener
{
		int mouseX=500;//make int mousex
		int mouseY=400;//make int mousey
		int x, y;
		String numberString;
		int xIndex, yIndex;
		int userValue = 2;//make int userValue = 2;
		String userNumber= "2";
		boolean userDied=false;
		int eaten = 0;//int eaten
		private int boxheight=195;
		private Timer timer;
					
		private int[][]data = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}};//give Array input, declare and initialize declare and initialize array called data with 100 cells//make public array values
		private int [] positionx = new int [15];//public array positionsx has same number of slots as values
		private int [] positiony = new int [15];//pubic array positionsy ""
		private int [] direction = new int [15];
		private Image i = Toolkit.getDefaultToolkit().getImage("game.PNG");
		private Image purplebubble = Toolkit.getDefaultToolkit().getImage("purplebubble.PNG");
		
		public JC3()
		{//constructor header
			if (timer == null) {
				timer = new Timer ( 100, this );
				timer.start ( );
			}
			addMouseListener(this);//add both math listeners
			addMouseMotionListener(this);
			makePositions();
			direction();
			//randNum2 = (int) (Math.random() *15+1); //use (int) (Math.random() *span+ start)
		}//constructor close
		
		public void paintComponent(Graphics g)
		{//paintcomponent method header
			
			int circleX;
			int circleY;
			super.paintComponent(g);//draw background
			//get background image
			//draw background image at position 0,0 with 1000 by 800
			Color user = new Color(255,90,100);
			Color blue = new Color (100,60,180);
			g.drawImage(i, 0,0,1000,800,this);
			g.setColor ( Color.white );
			g.fillRect (450, 600, 200, 20 );
			g.setColor (Color.RED);
			g.fillRect ( 455, 605, boxheight, 10 );
					
			for(int index = 0; index < 15; index++)//while loop to draw blue circles--index must be less than 15
			{
				x=positionx[index];//get value at the index for the x array, save as x
				y=positiony[index];//get value at index for y array, save as y
				numberString = String.valueOf(data[0][index]);//convert integer from data array to string
				//g.drawImage(purplebubble, x,y,50,50,this);
				g.setColor(blue);//set red color of user's circle
				g.fillArc(x,y, 50, 50, 0, 360);//draw circle of user//use x and y to draw a circle
				
				numberString = String.valueOf(data[0][index]);//convert integer from data array to string
				Font u= new Font("Serif", Font.BOLD, 30);//set font serif to bold and size 40
				g.setColor(Color.WHITE);//set white color of font
				g.setFont(u);
				g.drawString(numberString, x+10, y+38);//use drawstring to write value on the circle		
			}
			
			g.setColor(user);//set red color of user's circle
            g.fillArc(mouseX-25,mouseY-25, 50, 50, 0, 360);//draw circle of user
			Font f= new Font("Serif", Font.BOLD, 45);//set font serif to bold and size 40
			g.setColor(Color.WHITE);//set white color of font
			g.setFont(f);
            g.drawString(userNumber, mouseX-10, mouseY+15);//print string
            //determineOverlap();
		}//paintcomponent method close
		
		public void makePositions()
		{//makePostitions method header
			int circleX;
			int circleY;
			int index;
			int indexNew;
			for(index = 0; index < 15; index++)//loop to generate positionsz
			{
				circleX = (int)(Math.random()*950);//generate random x positions for each bubble
				positionx[index] = circleX;//fill array with positionsx (will be used in correspondence with each value in the array "value"
				circleY= (int)(Math.random()*650);//generate random y positions for each bubble
				positiony[index] = circleY;//fill array positionsy with values
			}
			
			for(index = 0; index < 15; index++)//loop to generate positionsz
			{
				for (indexNew=0; indexNew<index; indexNew++)
				{
					x=positionx[index];//get value at the index for the x array, save as x
					y=positiony[index];//get value at index for y array, save as y
					xIndex=positionx[indexNew];
					yIndex=positiony[indexNew];
					if((((x+50)>=xIndex)&&((x+50)<=(xIndex+50)))||((x<=(xIndex+50))&&(x>=xIndex)))
					{
						circleX = (int)(Math.random()*950);//generate random x positions for each bubble
						positionx[index] = circleX;//fill array with positionsx (will be used in correspondence with each value in the array "value"
						//System.out.println("working 1");
						//System.out.println(index);
						//System.out.println(indexNew);
					}
					if((((y+50)>=yIndex)&&((y+50)<=(yIndex+50)))||((y<=(yIndex+50))&&(y>=yIndex)))
					{
						circleY= (int)(Math.random()*650);//generate random y positions for each bubble
						positiony[index] = circleY;//fill array positionsy with values
						//System.out.println("working 2");
						//System.out.println(index);
						//System.out.println(indexNew);
					}			
				}
			}
			timer.start();
			repaint();//repaint paintcomponent
		}//makePositions method close
		
		public void mouseClicked(MouseEvent e) {}//mouse methods 
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseDragged(MouseEvent e){}//mouse motion listener methods
		public void mouseMoved(MouseEvent e){//mousemoved method
			mouseX=e.getX();//get value of x, save as mousex
			mouseY=e.getY();//get value of y, save as mousey
			determineOverlap();
			repaint();//repaint
		}
	    
		public void determineOverlap()
        {//determineOverlap method header. 
                //System.out.println("Determineoverlap");
        //This method will see if the user touches a circle. If the user does not, it will return -1. if it does, it will return the index of the array with 
				 boolean touching = false;
			     boolean die = false;
			     //make int variables:
			     int h;//h
			     int k;//k
			     int circlex;//circlex
			     int circley;//circley
					int distancesquared;	
			     //int distance = 100;
			     for(int index = 0; index < 15; index++)
			     {// loop to check each index
			             circlex = positionx[index];//get value at the index for the x array, save as x
			             circley = positiony[index];//get value at index for y array, save as y
			             h = circlex + 25;//find center of circle (x + 25, y+25), save as h and k
			             k = circley + 25;
							distancesquared =  (int) ((int)Math.pow((h-(int)mouseX),2)+Math.pow((k-(int)mouseY),2));
							if (distancesquared >=0 && distancesquared <= 2500){
								touching = true;
							}
							else
								touching = false;
			                        if (touching)
			                        {//if the user's circle is touching another circle:
			                                //System.out.println("Hallelujah");
			                                die = dieOrEat(index);//call method dieOrEat with index as parameter, save as boolean die 
			                                //(if the user dies, it is true; if the user does not die and eats the other circle, it is false)
			                                if (die)
			                                {//if die is true
			                                        ccc.show(cP, "p2");//call game over method
			                                }
			                                else
			                                {//else if die is false, 
			                                        //System.out.println("eat called");
			                                        eat(index);//call eat method, passing on index
			                                }
			                        
			                      }
			      }
        }//determineOverlap method close
        
                
                        public boolean dieOrEat(int index)
                        {//dieOrEat method header, ( int index)
                                boolean die;
                                if (data[0][index] > userValue)
                                {//if the value is greater than or equal to the user's
                                        //System.out.println("die");
                                        die = true;//boolean die = true
                                }
                                else
                                {//else if the value is less than the user's
                                        //System.out.print("not die");
                                        die = false;//boolean die = false
                                }
                                return die;//return die
                        }//dieOrEat method close
                  
                
                        public void eat(int index)
                        {//eat method header
                               // System.out.println("eat");
                                int circleValue = data[0][index];//use index to find value of circle that user interacted with
                                userValue+=circleValue;//concatenate to the user's value
                                userNumber = "" + userValue;
                               // System.out.println(userValue);
                                eaten++;
                                positionx[index] = 1050;
                                positiony[index] = 850;
                                repaint();//repaint();//repaint
			
								if(userValue==122)
									ccc.show(cP, "p3");//call you won method
                        }//eat method close
            public void redo(){
            	//System.out.println("redo");
				for(int x = 0; x < data[0].length; x++){
					//System.out.println(data[0].length+"HERE");
					data[0][x] = x+1;
					data[1][x] = x+1;//must reset all values to new value
				}
				userValue = 2;
				userNumber = "" + userValue;
				eaten = 0;
				boxheight = 195;
				timer.stop();
				timer = null;
				timer = new Timer (100, this);
				makePositions();//must reset all values to new value
				ccc.show(cP, "p1");
            }
			
			public void actionPerformed(ActionEvent evt)
			{
				int newly;
				int produced;
				int wow;
				//System.out.println("Action performed");
				if ( boxheight > 0 )   
				{
					//System.out.println("reduce boxheight");
							boxheight--;
							
							for(int x = 0; x < 15; x++){
								newly = (int) (Math.random() *3+1); //use (int) (Math.random() *span+ start)
								produced=direction[x];
								if(produced==1)
									positionx[x]-=1;
									wow=positionx[x];
									//System.out.println("Here"+x);
									if(positionx[x]<=0)
									{
										if(newly==1)
											direction[x]=5;
										
										else if (newly==2)
											direction[x]=3;
											
										else if (newly==3)
											direction[x]=8;
									}
								else if(produced==2)
									positiony[x]-=1;
									if(positiony[x]<=0)
									{
										if(newly==1)
											direction[x]=6;
										
										else if (newly==2)
											direction[x]=4;
										
										else if (newly==3)
											direction[x]=5;
									}
								else if(produced==3)
									positionx[x]+=1;
									if(positionx[x]>=950)
									{
										if(newly==1)
											direction[x]=6;
										
										else if (newly==2)
											direction[x]=1;
										
										else if (newly==3)
											direction[x]=7;
									}
								else if(produced==4)
									positiony[x]+=1;
									if(positiony[x]>=650)
									{
										if(newly==1)
											direction[x]=7;
										
										else if (newly==2)
											direction[x]=2;
										
										else if (newly==3)
											direction[x]=8;
									}
								else if(produced==5)
								{
									positionx[x]+=1;
									positiony[x]+=1;
									
									if(positionx[x]>=950)
									{
										if(newly==1)
											direction[x]=6;
										
										else if (newly==2)
											direction[x]=1;
										
										else if (newly==3)
											direction[x]=7;
									}
									
									if(positiony[x]>=650)
									{
										if(newly==1)
											direction[x]=7;
										
										else if (newly==2)
											direction[x]=2;
										
										else if (newly==3)
											direction[x]=8;
									}
								}
								else if(produced==6)
								{
									positionx[x]-=1;
									positiony[x]+=1;
									
									if(positionx[x]<=0)
									{
										if(newly==1)
											direction[x]=5;
										
										else if (newly==2)
											direction[x]=3;
										
										else if (newly==3)
											direction[x]=8;
									}
									
									if(positiony[x]>=650)
									{
										if(newly==1)
											direction[x]=7;
										
										else if (newly==2)
											direction[x]=2;
										
										else if (newly==3)
											direction[x]=8;
									}
								}
								else if(produced==7)
								{
									positionx[x]-=1;
									positiony[x]-=1;
									
									if(positionx[x]<=0)
									{
										if(newly==1)
											direction[x]=5;
										
										else if (newly==2)
											direction[x]=3;
										
										else if (newly==3)
											direction[x]=8;
									}
									
									if(positiony[x]<=0)
									{
										if(newly==1)
											direction[x]=6;
										
										else if (newly==2)
											direction[x]=4;
										
										else if (newly==3)
											direction[x]=5;
									}
								}
								else if(produced==8)
								{
									positionx[x]+=1;
									positiony[x]-=1;
									if(positionx[x]>=950)
									{
										if(newly==1)
											direction[x]=6;
										
										else if (newly==2)
											direction[x]=1;
										
										else if (newly==3)
											direction[x]=7;
									}
									
									if(positiony[x]<=0)
									{
										if(newly==1)
											direction[x]=6;
										
										else if (newly==2)
											direction[x]=4;
										
										else if (newly==3)
											direction[x]=5;
									}
								}
								//randNum = (int) (Math.random() *8+1);
									repaint();
							}
				}
				else   {
					//System.out.println("boxheight <= 0");
					
							//timer.stop();
							//timer = null;
							ccc.show(cP, "p2");
							
						}
	
			}
			
			public void direction()
			{
				int randNum;
				for(int index = 0; index < 15; index++)//while loop to draw blue circles--index must be less than 15
				{
					randNum = (int) (Math.random() *8+1); //use (int) (Math.random() *span+ start)
					direction[index]=randNum;
				}
			}
			
	}//close class GamePanel1

class GameOver extends JPanel implements MouseListener{
	private JLabel bLabel;
	private JButton b;//global button
	private Image over = Toolkit.getDefaultToolkit().getImage("gameover.png");
	public GameOver()
	{
		//System.out.println("game over");
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
        super.paintComponent(g);//draw background
		Font f = new Font("Snap ITC", Font.PLAIN, 20);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.drawImage(over, 0,0,this);
		g.drawString("Click anywhere to reset", 100, 30);
	}
	public void mousePressed(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{
                   ccc.show(cP, "p1");
				   panel1.redo();
	}
    
}

class YouWon extends JPanel implements MouseListener{
	private JLabel bLabel;
	private JButton b;//global button
	private Image over = Toolkit.getDefaultToolkit().getImage("youwin.png");
	public YouWon()
	{
		panel1.timer.stop();
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		Font f = new Font("Snap ITC", Font.PLAIN, 20);
        super.paintComponent(g);//draw background
		g.setColor(Color.WHITE);
		g.setFont(f);
		g.drawImage(over, 0,0,this);
		g.drawString("Click anywhere to reset", 100, 30);
	}
	public void mousePressed(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{
                   ccc.show(cP, "p1");
				   panel1.redo();
	}
}
}