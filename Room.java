package AvailabilityDemand;

import java.util.Date;

public class Room {

	private String location;
	
	private StayPeriod stayLength;
	
	public Room(String holderLocation, Date start, Date end) {
		this.location = holderLocation;
		stayLength = new StayPeriod(start, end);
	}
	
	public StayPeriod getStayLength() {
		
		return stayLength;
	}
	
	public String getLocation() {
		
		return location;
	}
	
	public boolean equals(Room room) {
		boolean bool = false;
		if(this.location.equalsIgnoreCase(room.location) && this.stayLength.equals(room.stayLength)) {
			bool = true;
		}
		return bool;
	}
	
	
	
	
	
	

//	private Date availableFrom;
//
//	private Date availableTo;
//	
//	private boolean isRoomTaken;
//	private String name;
//	
//	public void roomMaker(String holderName, String locationName, Date start, Date end) {
//		name = holderName;
//		location = locationName;
//		availableFrom = start;
//		availableTo = end;
//	}
//	/*
//	 * inside broker you compare the location of publisher and subscriber. 
//	 * If they match, call this function and pass in a from and to parameters
//	 */
//
//	public boolean findRoom(String passedInLocation, Date start, Date end, boolean isSubscriber) {
//		boolean bool = false;
//		if(passedInLocation.equals(location)) {
//			
//			if(isSubscriber == true) { // if it's a subscriber
//				/* check to see that the start date of cx is => start date of provider
//				 * and that the end date for cx is =< the end date of provider
//				 * if all that match, bool = true
//				 */
//			} else { // if it's a publisher
//				/* check to see that the start date of cx is =< start date of provider
//				 * and that the end date for cx is => the end date of provider
//				 *  if all that match, bool = true
//				 */
//			}
//			
//		} else {
//			/*
//			 * Do nothing. Leave black
//			 */
//			
//		}
//		return bool;
//	}
//	
//	public boolean duplicates(Room tempRoom, boolean isSubscriber) {
//		boolean bool = false;
//		if (isSubscriber) {
//			if(tempRoom.name.equals(name)) {
//				if(tempRoom.name.equals(name)) {
//					if(tempRoom.name.equals(name)) {
//						
//					}
//				}
//			}
//		}
//		else { // if it's a publisher
//			// date ranges of publishers can't overlap. you need to account for that
//		}
//		return bool;
//	}
//	
//	
//
//	public boolean roomAvailability() {
//		
//		return isRoomTaken;
//	}
//	
//	
//	
//	public Date getAvailableFrom() {
//		return availableFrom;
//	}
//
//	public void setAvailableFrom(Date newDate) {
//		availableFrom = newDate;
//	}
//
//	public Date getAvailableTo() {
//		return availableTo;
//	}
//
//	public void setAvailableTo(Date newDate) {
//		availableTo = newDate;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String newLocation) {
//		location = newLocation;
//	}	
}
