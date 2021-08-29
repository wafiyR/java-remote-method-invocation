
import java.rmi.Remote;
import java.rmi.RemoteException;
import product.Product;
import java.util.ArrayList;

/**
 * 
 * @author toh jing wei
 *
 */
public interface BurgerPrintInterface extends Remote {
	
	public String printProduct() throws RemoteException;
	public String printOrder (ArrayList<Integer> code, ArrayList<Integer> amount) throws RemoteException;
	public boolean payMoney(double pay) throws RemoteException;
	public double getBalance()throws RemoteException;
	public void printReceipt() throws RemoteException;
	
}
