package AvailabilityDemand;

import java.util.Date;

public class StayPeriod {

	private Date startDate;

	private Date endDate;
	
	//constructor
	public StayPeriod(Date start, Date end) {
		startDate = start;
		endDate = end;
	}
	
	// getters and setters
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date newDate) {
		startDate = newDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date newDate) {
		endDate = newDate;
	}
	
	public boolean inMiddle(StayPeriod sp) {
		boolean bool = false;
		/* if this fails for some reason, keep in mind that you are not checking if
		 * the start date for cx is after the end date for provider & that end date  
		 * cx is after the start date for publisher
		 */ 
		if((this.startDate.after(sp.startDate) || this.startDate.equals(sp.startDate)) && 
		   (this.endDate.before(sp.endDate) || this.endDate.equals(sp.endDate))){
			bool = true;
		}
		return bool;
	}
	
	// this will be important for checking for duplicates
	public boolean equals(StayPeriod sp) {
		boolean bool = false;
		
		if(this.startDate.equals(sp.startDate) && this.endDate.equals(sp.endDate)) { 
			bool = true;
		}

		return bool;
	}
	
	// checks for overlaps 
	public boolean overLap(StayPeriod sp) {
		return(this.inMiddle(sp) || this.equals(sp) || 
			  ((this.startDate.after(sp.startDate) && this.startDate.before(sp.endDate)) || this.startDate.equals(sp.startDate)) 
			  || this.endDate.equals(sp.endDate) || (this.endDate.before(sp.endDate) && this.endDate.after(sp.startDate)));
	}
}
