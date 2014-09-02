
import java.text.DecimalFormat;
import java.util.*;

public class StockLedger {
	
	private Deque<StockPurchase>ledger;
	int totalNumShares;	
	double capitalGain;
	
	StockLedger(){
		ledger = new ArrayDeque<StockPurchase>();
		totalNumShares = 0;
	}
	
	public void buy(int sharesToBuy, double purchasePrice){
		StockPurchase stockPurchase = new StockPurchase();
		stockPurchase.numOfShares = sharesToBuy;
		stockPurchase.costPerShare = purchasePrice;
		totalNumShares += sharesToBuy;
		ledger.addLast(stockPurchase);
		
	}
	
	public int sell(int sharesToSell, double sellingPrice){
		int newAmountOfShares;  
		int ledgerShares;
		double ledgerShareCost;
		if(sharesToSell > totalNumShares){
			System.out.println("You do not have enough shares to sell");
			System.out.println("You only have " + totalNumShares + " shares");
			return 0;
		}
		
		
		ledgerShareCost = ledger.getFirst().returnCostShares();
		ledgerShares = ledger.removeFirst().returnNumShares();
		for(int i = 0; i < 100; i++){
			if(ledgerShares >= sharesToSell){
				StockPurchase newStockPurchase = new StockPurchase();
				if(i == 0){
					newAmountOfShares = totalNumShares - sharesToSell;
					totalNumShares -= sharesToSell;
					newStockPurchase.numOfShares = newAmountOfShares;
					newStockPurchase.costPerShare = sellingPrice;
				}else{
					newAmountOfShares = ledgerShares - sharesToSell;
					newStockPurchase.numOfShares = newAmountOfShares;
					newStockPurchase.costPerShare = sellingPrice;
				}
			ledger.addFirst(newStockPurchase);
			break;
			}else{
				totalNumShares -= sharesToSell;
				sharesToSell -= ledgerShares;
				ledgerShareCost = ledger.getFirst().returnCostShares();
				ledgerShares = ledger.removeFirst().returnNumShares();
			}		
		}
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		capitalGain = (sharesToSell*sellingPrice)-(ledgerShares* ledgerShareCost);
		System.out.println("Capital Gain/Loss = " + "$" + (df.format(capitalGain)));		
		return totalNumShares;		
	}
	
	public void displayAll(){
		System.out.println("Stock Ledger Display:");
		int i = 1;
		for(StockPurchase display : ledger){
			System.out.print("Stock " + i + ":");
			System.out.println(" Number of Shares: " + display.returnNumShares() + " Cost per Share: " + display.returnCostShares());
			i++;
		}
		System.out.println("Total Number of Shares: " + totalNumShares);
	}
	
	public static void main(String[] args) {
		StockLedger stockLedger = new StockLedger();
		Scanner input = new Scanner(System.in);
		int inputShares = 0;
		int loopAgain = 0;
		int choose = 0;
		boolean yes = true;
		double inputCost = 0;
		boolean number = true;
		boolean number2 = true;
		
		do{
			System.out.print("Do you want to buy(1) or sell(2)?: ");
			
			choose = Integer.parseInt(input.nextLine());
		
			if(choose == 1){
		
				System.out.print("How many shares of company X do you want to buy?: ");
				do{
					if(number == false){
						System.out.print("Please enter a number for the amount of shares: ");
					}
					
					try{
						
						inputShares = Integer.parseInt(input.nextLine());
						number = true;
					}catch(NumberFormatException ex){
						System.out.print("Not a Number! ");
						number = false;
					}
				}while(number == false); 		
				
				System.out.print("What is the cost per share?: ");
				do{
					if(number2 == false){
						System.out.print("Please enter a number for the cost per share: ");
					}
					
					try{
						
						inputCost = Double.parseDouble(input.nextLine());
						number = true;
					}catch(NumberFormatException ex){
						System.out.print("Not a Number! ");
						number = false;
					}
				}while(number2 == false);
				
				stockLedger.buy(inputShares, inputCost);
				System.out.print("Would you like to continue buying/selling stocks (yes = 1/no = 2)?: ");
				try{				
					loopAgain = Integer.parseInt(input.nextLine());
				}catch(NumberFormatException ex){
					System.out.print("Not a number! ");
				}
				
				if(loopAgain == 1){
					yes = true;
				}else{
					yes = false;
				}
			}else if(choose == 2){
				System.out.print("How many shares of company X do you want to sell?: ");
				do{
					if(number == false){
						System.out.print("Please enter a number for the number of shares: ");
					}
					
					try{
						
						inputShares = Integer.parseInt(input.nextLine());
						number = true;
					}catch(NumberFormatException ex){
						System.out.print("Not a Number! ");
						number = false;
					}
				}while(number == false); 		
				
				System.out.print("What is the cost per share?: ");
				do{
					if(number2 == false){
						System.out.print("Please enter a number for the cost per share: ");
					}
					
					try{
						
						inputCost = Double.parseDouble(input.nextLine());
						number = true;
					}catch(NumberFormatException ex){
						System.out.print("Not a Number! ");
						number = false;
					}
				}while(number2 == false);
				
				stockLedger.sell(inputShares, inputCost);
				System.out.print("Would you like to continue buying/selling stocks (yes = 1/no = 2)?: ");
				try{				
					loopAgain = Integer.parseInt(input.nextLine());
				}catch(NumberFormatException ex){
					System.out.print("Not a number! ");
				}
				
				if(loopAgain == 1){
					yes = true;
				}else{
					yes = false;
				}
			}
			
			System.out.println("");
			stockLedger.displayAll();
			System.out.println("");
		}while(yes == true); 
		
		input.close();
	}

	private class StockPurchase{
		int numOfShares;
		double costPerShare;
		StockPurchase(){
			numOfShares = 0;
			costPerShare = 0;
		}
		
		public int returnNumShares(){
			return numOfShares;
		}
		
		public double returnCostShares(){
			return costPerShare;
		}		
	}	
}
