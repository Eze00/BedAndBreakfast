package AvailabilityDemand;

import java.util.Date;

public class BnBProvider implements IPublisher {

	private String name;
	private Room roomArrangement;


	public BnBProvider(String providerName, String providerLocation, Date startDate, Date endDate) {
		name = providerName;
		this.roomArrangement = new Room(providerLocation, startDate, endDate);
	}

	
	public boolean publish(String providerName, String location, Date availableFrom, Date availableTo) { 
		boolean isSuccessful = Broker.getBroker().roomPublication(providerName, location, availableFrom, availableTo);
		
		return isSuccessful;
	}

	public String getName() {
		return name;
	}

	public Room getRoomArrangement() {
		return roomArrangement;
	}
	
	public boolean equals(BnBProvider provider) {
		boolean bool = false;
		
		if(this.name.equalsIgnoreCase(provider.name) && this.roomArrangement.equals(provider.roomArrangement)) {
			bool = true;
		}
		return bool;
	}
}
