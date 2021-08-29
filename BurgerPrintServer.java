
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class BurgerPrintServer {

	public static void main(String[] args) {
		
		try {
			
			// Create object from concrete class
			BurgerPrintImpl printImpl = new BurgerPrintImpl();
			
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
