

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMIPrintServer {

	public static void main(String[] args) {
		
		try {
			
			// Create object from concrete class
			PrintImpl printImpl = new PrintImpl();
			
			// Bind object to server name
			Naming.rebind("MyServer", printImpl);
			
			// Print some message to indicate server is alive
			System.out.println("Server waiting ....");
			
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
