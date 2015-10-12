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

public class JCAddition extends JPanel
{
	JC3 panel1= new JC3();
    GameOver panel2= new GameOver();
	YouWon panel3= new YouWon();
	CardPages cP;
	CardLayout ccc;
	boolean won = false;
	
	JCAddition()
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
					
		private String[][]data = {{"0+1", "0+2", "0+3", "0+4", "0+5", "0+6", "0+7", "0+8", "0+9", "0+10", "0+11", "0+12", "0+13", "0+14", "0+15"}, {"1+0", "1+1", "1+2", "1+3", "1+4", "1+5", "1+6", "1+7", "1+8", "1+9", "1+10", "1+11", "1+12", "1+13", "1+14"}, {"0+1", "2+0", "2+1", "2+2", "2+3", "2+4", "2+5", "2+6", "2+7", "2+8", "2+9", "2+10", "2+11", "2+12", "2+13"},{"1+0", "0+2", "3+0", "3+1", "3+2", "3+3", "3+4", "3+5", "3+6", "3+7", "3+8", "3+9", "3+10", "3+11", "3+12"},  {"0+1", "1+1", "0+3", "4+0", "4+1", "4+2", "4+3", "4+4", "4+5", "4+6", "4+7", "4+8", "4+9", "4+10", "4+11"}, {"1+0", "2+0", "1+2", "0+4", "5+0", "5+1", "5+2", "5+3", "5+4", "5+5", "5+6", "5+7", "5+8", "5+9", "5+10"}, {"0+1", "0+2", "2+1", "1+3", "0+5", "6+0", "6+1", "6+2", "6+3", "6+4", "6+5", "6+6", "6+7", "6+8", "6+9"},{"1+0", "1+1", "3+0", "2+2", "1+4", "0+6", "7+0", "7+1", "7+2", "7+3", "7+4", "7+5", "7+6", "7+7", "7+8"}, {"0+1", "2+0", "0+3", "3+1", "2+3", "1+5", "0+7", "8+0", "8+1", "8+2", "8+3", "8+4", "8+5", "8+6", "8+7"}, {"1+0", "0+2", "1+2", "4+0", "3+2", "2+4", "1+6", "0+8", "9+0", "9+1", "9+2", "9+3", "9+4", "9+5", "9+6"}, {"0+1", "1+1", "2+1", "0+4", "4+1", "3+3", "2+5", "1+7", "8+1", "10+0", "10+1", "10+2", "10+3", "10+4", "10+5"}, {"1+0", "2+0", "3+0", "1+3", "5+0", "4+2", "3+4", "2+6", "5+4", "7+3", "11+0", "11+1", "11+2", "11+3", "11+4"}, {"0+1", "0+2", "0+3", "2+2", "0+5", "5+1", "4+3", "3+5", "4+5", "6+4", "8+3", "12+0", "12+1", "12+2", "12+3"}, {"1+0", "1+1", "1+2", "3+1", "1+4", "6+0", "5+2", "4+4", "5+4", "10+0", "10+1", "12+1", "13+0", "13+1", "13+2"}, {"0+1", "2+0", "2+1", "4+0", "2+3", "0+6", "6+1", "5+3", "6+3", "0+10", "11+0", "10+2", "12+3", "14+0", "14+1"}, {"1+0", "0+2", "3+0", "0+4", "3+2", "1+5", "7+0", "6+2", "0+9", "9+1", "7+4", "0+12", "7+6", "6+8", "15+0"}};//give Array input, declare and initialize declare and initialize array called data with 100 cells//make public array values
		private int [] positionx = new int [15];//public array positionsx has same number of slots as values
		private int [] positiony = new int [15];//pubic array positionsy ""
		private int [] direction = new int [15];
		private String[] dataUsed= new String[15];
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
			dataUsed();
			//randNum2 = (int) (Math.random() *15+1); //use (int) (Math.random() *span+ start)
		}//constructor close
		
		public void paintComponent(Graphics g)
		{//paintcomponent method header
			
			int circleX;
			int circleY;
			int randomRow;
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
				//numberString = String.valueOf(data[0][index]);//convert integer from data array to string
				//g.drawImage(purplebubble, x,y,50,50,this);
				g.setColor(blue);//set red color of user's circle
				g.fillArc(x,y, 50, 50, 0, 360);//draw circle of user//use x and y to draw a circle
			
				numberString = dataUsed[index];//convert integer from data array to string
				Font u= new Font("Serif", Font.BOLD, 18);//set font serif to bold and size 40
				g.setColor(Color.WHITE);//set white color of font
				g.setFont(u);
				if(numberString.length()==3)
				g.drawString(numberString, x+10, y+32);//use drawstring to write value on the circle	
				else if(numberString.length()==4)
				g.drawString(numberString, x+7, y+32);//use drawstring to write value on the circle		
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
                                if (index>= userValue)
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
								//System.out.println(index+"help");
                                int circleValue = (index+=1);//use index to find value of circle that user interacted with
                                userValue+=circleValue;//concatenate to the user's value
                                userNumber = "" + userValue;
                                //System.out.println(userValue);
                                eaten++;
                                positionx[index-=1] = 1050;
								 //System.out.println(positionx[index-=1]+"testing1");
								 //System.out.println((index-=1)+"testing2");
                                positiony[index] = 850;
                                repaint();//repaint();//repaint
			
								if(eaten>=15)
									ccc.show(cP, "p3");//call you won method
                        }//eat method close
            public void redo(){
				int randNum;
            	//System.out.println("redo");
				for(int x = 0; x < data[0].length; x++){
					randNum = (int) (Math.random() *15+0); //use (int) (Math.random() *span+ start)
					data[0][x] = data[randNum][x];
					data[1][x] = data[randNum][x];//must reset all values to new value
					data[2][x] = data[randNum][x];
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
				//boolean won = false;
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
						if(!won)
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
			
			public void dataUsed()
			{
				int randNum;
				String work;
				for(int index = 0; index < 15; index++)//while loop to draw blue circles--index must be less than 15
				{
					randNum = (int) (Math.random() *15+0); //use (int) (Math.random() *span+ start)
					work= data[randNum][index];
					dataUsed[index]=work;
					//System.out.println(dataUsed[index]+"hi");
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
		won = true;
		panel1.timer.stop();
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		Font f = new Font("Snap ITC", Font.PLAIN, 20);
        super.paintComponent(g);//draw background
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
				won  = false;
				
                   ccc.show(cP, "p1");
				   panel1.redo();
	}
}
}
