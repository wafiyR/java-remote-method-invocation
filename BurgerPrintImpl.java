
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import product.Product;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.io.FileNotFoundException;


/**
 * 
 * @author toh jing wei
 *
 */
public class BurgerPrintImpl extends UnicastRemoteObject implements BurgerPrintInterface {
		
	Product whopper=new Product();
	Product whopperWithCheese=new Product();
	Product bkDoubleMushroomSwiss=new Product();
	double total=0;
	double pay=0;
	double balance=0;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   	LocalDateTime now = LocalDateTime.now();
	
	private static final long serialVersionUID = 1L;

	protected BurgerPrintImpl() throws RemoteException {
		super();
		
		//Initialize all the product
		whopper.setName("Whopper");
		whopper.setPrice(11.95);
		whopper.setProductCode(101);
	
		whopperWithCheese.setName("Whopper with Cheese");
		whopperWithCheese.setPrice(14.15);
		whopperWithCheese.setProductCode(102);
	
		bkDoubleMushroomSwiss.setName("BK Double Mushroom Swiss");
		bkDoubleMushroomSwiss.setPrice(11.45);
		bkDoubleMushroomSwiss.setProductCode(103);
		
		//Send the product list to client
		printProduct();
	}

	/**
	 * Overidden method
	 */
	public String printOrder(ArrayList<Integer> code, ArrayList<Integer> amount) throws RemoteException {
			
		ArrayList<Integer> productCode = new ArrayList<Integer>(code);
		ArrayList<Integer> quantity = new ArrayList<Integer>(amount);
		String orderedDetails = "Order Details\n";
		
		//loop by the size of arraylist and match the product to get subtotal
		for(int i=0; i<productCode.size(); i++){
			if(productCode.get(i) == 101){
				total+=quantity.get(i)*whopper.getPrice();
				
				orderedDetails+="Product code:"+whopper.getProductCode()+"\n"+"Product Name:"+whopper.getName()+"\n"+"Quantity:"+amount.get(i)+"\n\n";
			}
			else if(productCode.get(i) == 102){
				total+=quantity.get(i)*whopperWithCheese.getPrice();
			
				orderedDetails+="Product code:"+whopperWithCheese.getProductCode()+"\n"+"Product Name:"+whopperWithCheese.getName()+"\n"+"Quantity:"+amount.get(i)+"\n\n";
			}
			else if(productCode.get(i) == 103){
				total+=quantity.get(i)*bkDoubleMushroomSwiss.getPrice();
				
				orderedDetails+="Product code:"+bkDoubleMushroomSwiss.getProductCode()+"\n"+"Product Name:"+bkDoubleMushroomSwiss.getName()+"\n"+"Quantity:"+amount.get(i)+"\n\n";
			}
		}
		orderedDetails+="Total amount:"+total;
		return orderedDetails;
	}

	public String printProduct() throws RemoteException{
		
		//return product list to client
		return("Product Code:"+whopper.getProductCode()+"\t"+"Product Name:"+whopper.getName()+"\t\t\t"+"Product Price:"+whopper.getPrice()+"\n"+
		"Product Code:"+whopperWithCheese.getProductCode()+"\t"+"Product Name:"+whopperWithCheese.getName()+"\t"+"Product Price:"+whopperWithCheese.getPrice()+"\n"+
		"Product Code:"+bkDoubleMushroomSwiss.getProductCode()+"\t"+"Product Name:"+bkDoubleMushroomSwiss.getName()+"\t"+"Product Price:"+bkDoubleMushroomSwiss.getPrice());
	}	
	
	public boolean payMoney (double pay) throws RemoteException{
		System.out.println("Calculating payment from client...");
		// Check if the pay is greater than totalPrice
		if(pay>total){
			this.pay=pay;
			balance=pay-total;
			return false;
		}
		else{
			return true;
		}
	}
	
	//return balance of the payment to client
	public double getBalance () throws RemoteException{
		return balance;
	}
	
	//print receipt to txt file
	public void printReceipt() throws RemoteException{
		
		PrintWriter outputTxt;
		try {
			outputTxt = new PrintWriter("Receipt.txt");
			outputTxt.println("Receipt");
			outputTxt.println("Date Time:"+dtf.format(now));
			outputTxt.println("Amount Pay:"+pay);
			outputTxt.println("Total: "+total);
			outputTxt.println("Balance: "+balance);
			outputTxt.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
