package transaction;

public class Sales extends OrderedItem{
	
	private OrderedItem[] orderedItem;
	private double totalAmount=0;
	private double paid;
	
	public Sales() {
		super();
	}

	public OrderedItem[] getOrderedItem() {
		return orderedItem;
	}

	public void setOrderedItem(OrderedItem[] orderedItem) {
		this.orderedItem = orderedItem;
		for(OrderedItem o: orderedItem)
		{
			totalAmount += o.getSubTotal();
		}
	}

	public double getPaid() {
		return Math.round(paid-totalAmount);
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}
	
	
	

}
