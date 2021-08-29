
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This class demonstrtae the implementation of PrintInterface
 * @author emalianakasmuri
 *
 */
public class PrintImpl extends UnicastRemoteObject implements PrintInterface {

	
	private static final long serialVersionUID = 1L;

	protected PrintImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Overidden method
	 */
	public void printGreeting() throws RemoteException {
		
		System.out.println("This is a greeting from RMI program");
		
	}

	//Exercise 2 function which receive String variable(name) and return a string
	public String printName(String name) throws RemoteException{
		
		String validate = name.substring(0, Math.min(name.length(),10));
		return validate;
	}	
	
}
