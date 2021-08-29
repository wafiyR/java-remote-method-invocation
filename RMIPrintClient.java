

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * This class demonstrate implementation of RMI client
 * @author emalianakasmuri
 *
 */
public class RMIPrintClient {

	public static void main(String[] args) {
		
		
		try {
			
			// Look-up for the the interface
			PrintInterface printInterface = (PrintInterface) Naming.lookup("//localhost/MyServer");
			
			// Invoke interface service
			printInterface.printGreeting();
			
			System.out.println(printInterface.printName("Hubert Blaine"));
			System.out.println(printInterface.printName("Ashe"));
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
