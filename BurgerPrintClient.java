

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author toh jing wei
 *
 */
public class BurgerPrintClient {

	public static void main(String[] args) {
		
		
		try {
			
			// Look-up for the the interface
			BurgerPrintInterface printInterface = (BurgerPrintInterface) Naming.lookup("//localhost/MyServer");
			
			//Declare variable used
			ArrayList<Integer> pCode = new ArrayList<Integer>();
			ArrayList<Integer> orderNo = new ArrayList<Integer>();
			double pay=0;
			String decision = "Y";
			
			// Invoke interface service
			System.out.println(printInterface.printProduct());
			
			//Looping for user to order multiple product
			while(decision.equals("Y"))
			{
				//Scan in order number
				Scanner code = new Scanner(System.in);  // Create a Scanner object
				System.out.println("Enter product code wanted :");
				pCode.add(code.nextInt());
			
				//Scan in amount ordered
				Scanner amount = new Scanner(System.in);  // Create a Scanner object
				System.out.println("Enter amount :");
				orderNo.add(amount.nextInt());
			
				Scanner yesNo = new Scanner(System.in);  // Create a Scanner object
				System.out.println("Still want to order any other item?? ");
				//Make the input uppercase so that no case-sensitive problem
				decision = yesNo.nextLine().toUpperCase();
			}
			
			//Send client order to server
			System.out.println(printInterface.printOrder(pCode,orderNo));
			
			boolean payment = true;
			Scanner scanner = new Scanner(System.in);  // Create a Scanner object
			
			//loop if payment is insufficient
			while(payment){
				
				System.out.println("Enter the amount to pay:");
				payment=printInterface.payMoney(scanner.nextDouble());
				}
			
			//Get balance of the payment
			System.out.println("Payment done.The balance are RM"+printInterface.getBalance());
			
			
			//Print receipt in txt file
			printInterface.printReceipt();
			
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
