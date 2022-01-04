package AvailabilityDemand;

import java.util.Date;

public class Customer implements ISubscriber {

	private String name;
	private Room roomArrangement;
	

	public Customer(String cxName, String cxLocation, Date startDate, Date endDate) {
		name = cxName;
		
		roomArrangement = new Room(cxLocation, startDate, endDate);
	}

	public boolean subscribe(String location, Date from, Date to) {
		//in the broker class, addSubscriber method, check to see if the passed in info is already inside the list. 
		//If so, don't add it the list again.
		boolean isSuccessful = Broker.getBroker().addSubscription(name, location, from, to);
		return isSuccessful;
	}

	public boolean unsubscribe(String location, Date from, Date to) {
		boolean isSuccessful = Broker.getBroker().removeSubscription(name, location, from, to);
		return isSuccessful;
	}
	
	public String getName() {
		return name;
	}
	
	public Room getRoomArrangement() {
		return roomArrangement;
	}
	
	public boolean equals(Customer cx) {
		boolean bool = false;
		if(this.name.equalsIgnoreCase(cx.name) && this.roomArrangement.equals(cx.roomArrangement)) {
			bool = true;
		}
		return bool;
	}
}
