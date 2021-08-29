
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface is used to demonstrate RMI application
 * @author emalianakasmuri
 *
 */
public interface PrintInterface extends Remote {
	
	public void printGreeting () throws RemoteException;
	public String printName(String name) throws RemoteException;
	
}
