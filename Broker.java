package AvailabilityDemand;

import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Broker {

	private LinkedList<Customer> customerList;
	private LinkedList<BnBProvider> publishedList;
	private LinkedList<String> finalOutput;
	
	private static Broker broker;
	
	
	private Broker() {
		customerList = new LinkedList<Customer>();
		publishedList = new LinkedList<BnBProvider>();
		finalOutput =  new LinkedList<String>();
	}
	
	public static Broker getBroker() {
		if(broker == null) {
			broker = new Broker();
		}
		return broker;
	}
	
	public LinkedList<String> getOutputlist(){
		
		return finalOutput;
	}
	
	public boolean addSubscription(String name, String location, Date from, Date to) {
		boolean isSuccessful;
		
		Customer tempCx = new Customer(name, location, from, to);
		
		// check for duplicates
		for(Customer cx : customerList) {
			if(tempCx.equals(cx)) {
				isSuccessful = false;
				return isSuccessful;
			}
		}
		isSuccessful = customerList.add(tempCx);
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		for(BnBProvider prov : publishedList) {
			if(tempCx.getRoomArrangement().equals(prov.getRoomArrangement()) || 
					(tempCx.getRoomArrangement().getStayLength().inMiddle(prov.getRoomArrangement().getStayLength()) &&
							tempCx.getRoomArrangement().getLocation().equalsIgnoreCase(prov.getRoomArrangement().getLocation())) ) {
				String result = "";
				String date1 = formatter.format(prov.getRoomArrangement().getStayLength().getStartDate()); 
				String date2 = formatter.format(prov.getRoomArrangement().getStayLength().getEndDate());
				result = tempCx.getName() + " notified of B&B availability in " + prov.getRoomArrangement().getLocation() 
						+ " from " + date1 + " to " + date2 + " by " + prov.getName() + " B&B";
				finalOutput.add(result);
			}
			
		}

		return isSuccessful;
	}

	public boolean roomPublication(String providerName, String location, Date availableFrom, Date availableTo) { 
		boolean isSuccessful;
		
		BnBProvider provider = new BnBProvider(providerName, location, availableFrom, availableTo);
		
		// check for duplicates
		if(publishedList.size() == 0) {
			isSuccessful = publishedList.add(provider);
		} else {
			for(BnBProvider p : publishedList) { 
				if(provider.equals(p) 
						|| (provider.getRoomArrangement().getLocation().equalsIgnoreCase(p.getRoomArrangement().getLocation()) 
						&& provider.getRoomArrangement().getStayLength().overLap(p.getRoomArrangement().getStayLength())
						&& provider.getName().equalsIgnoreCase(p.getName())) ) { 
					isSuccessful = false;
					return isSuccessful;
				}
			}
			isSuccessful = publishedList.add(provider);
		}
		
		   SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  

		for(Customer cx : customerList) {

			//if(provider.getRoomArrangement().equals(cx.getRoomArrangement())) {
			if(provider.getRoomArrangement().equals(cx.getRoomArrangement()) || 
					(cx.getRoomArrangement().getStayLength().inMiddle(provider.getRoomArrangement().getStayLength()) &&
							provider.getRoomArrangement().getLocation().equalsIgnoreCase(cx.getRoomArrangement().getLocation()))){
				String result = "";
				String date1 = formatter.format(provider.getRoomArrangement().getStayLength().getStartDate()); 
				String date2 = formatter.format(provider.getRoomArrangement().getStayLength().getEndDate());
				result = cx.getName() + " notified of B&B availability in " + provider.getRoomArrangement().getLocation() 
						+ " from " + date1 + " to " + date2 + " by " + provider.getName() + " B&B";
				finalOutput.add(result);
			}
			
		}

		return isSuccessful;
	}
	
	public boolean removeSubscription(String name, String location, Date from, Date to) {
		boolean isSuccessful = false;	
		Customer tempCx = new Customer(name, location, from, to);
		
		for( Customer cx : customerList) {
			if(cx.equals(tempCx)) {
				customerList.remove(cx);
				return true;
			}
		}

		return isSuccessful;
	}

	
	public void clear() {
		customerList.clear();
		publishedList.clear();
		finalOutput.clear();
		
	}
	

}
