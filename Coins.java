public class Coins{
		private int quarters = 0;
		private int dimes = 0;
		private int nickels = 0;
		private int pennies = 0;
		private int combos = 0;
		private int value;
	public Coins(){
		prompt();
		calculate();
	}
	public static void main(String[]args){
		Coins x = new Coins();
	}
	
	public void prompt(){
		System.out.println("\n\n");
		value = Prompt.getInt("Please enter the number of cents:",1,1000);
		System.out.println("\n\n");

	}
	
	public void calculate(){
		int count = 0;
	boolean x = false;
		for(int quarters = value/25;quarters>=0;quarters--){
			for(int dimes = (value-quarters*25)/10;dimes>=0;dimes--){
			//x = true;
				for(int nickels =(value-quarters*25-dimes*10)/5; nickels >=0;nickels--){
				/*
				if(x){
					nickels ++;
					x = false;
				}
				*/
					//for (int pennies = (value-quarters*25-dimes*10-nickels*5); pennies >=0;pennies-=5 ){
					int pennies = (value-quarters*25-dimes*10-nickels*5);
						System.out.println(value + " = " + quarters + " quarters + " + dimes + " dimes + "+nickels+" nickels + "+ pennies + " pennies.");
						count++;
					//}
				}
			}
		}
		System.out.print(count);
		System.out.println("\nNumber of combinations:	" + combos);
		
				
	}
	
	public void print(){
		System.out.printf("%d = %3d quarters + %3d dimes + %3d nickels + %3d pennies\n",value,quarters,dimes,nickels,pennies);
	}
}
