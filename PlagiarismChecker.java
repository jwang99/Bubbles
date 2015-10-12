//Jasmine Wang
//5-26-15
//PlagiarismChecker.java checks two files and compares them, then sees if it has similar words

//import

class PlagiarismChecker extends JFrame{//JFrame header
	MainPanel m = new MainPanel();//instance of mainPanel
	public static void main(String[]args){//main method header
		PlagiarismChecker p = new PlagiarismChecker();//instance of JFrame
	}//main close
	public PlagiarismChecker(){//constructor header
		super("Plagiarism Checker");//super
		setSize(500,500);//set size
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);//set close operation
		setResizable(false);//set resizable to false
		setContentPane(m);
	}//constructor close
	
	class MainPanel extends JPanel{//MainPanel class header
		LeftPanel left = new LeftPanel();//create instance of LeftPanel
		RightPanel right = new RightPanel();//create instance of RightPanel
		public MainPanel(){//constructor header
			GridLayout g = new GridLayout(1,2);//gridlayout 1 by 2
			setLayout(g);//set layout to gridlayout
			add(left);//add left panel
			add(right);//add right panel
		}//constructor close
	}//MainPanel class close
	
	class LeftPanel exends JPanel implements ActionListener{//LeftPanel class header implements ActionListener
		TextField txt1 = new TextField("Type name of first file");//create TextField 1
		TextField txt2 = new TextField("Type name of second file");//create TextField 2
		JButton compare = new JButton("Compare");//create JButton compare
		Check c = null;//create instance of class Check is null
		String x = "";//String x
		String y = "";//String y
		boolean used1 = false;//boolean used1
		boolean used2 = false;//boolean used2
		public LeftPanel(){//constructor header
			//instantiate buttons and textareas
			compare.addActionListener(this);//addActionListener
			GridLayout g = new GridLayout(3,1);//create GridLayout
			add(txt1);//add text field 1
			add(txt2);//add text field 2
			add(compare);//add button
		public void actionPerformed(//actionperformed method
			String x = txt1.getText();
			String y = txt2.getText();//save string x and string y
				
	class RightPanel extends JPanel{//RightPanel class header 
		BorderLayout bl = new BorderLayout();//borderlayout
		TextArea t = new TextArea();//text area
		//color panel
		//constructor header
			//set as borderlayout
			//add text area(color)
			//add color panel
		//
	
	//ColorPanel class header
		//constructor header with color
		//paintcomponent
		//set background as color
		//draw background
		
	//Check class header
	
		//constructor header with two strings