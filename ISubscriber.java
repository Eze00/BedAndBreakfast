package AvailabilityDemand;

import java.util.Date;

public interface ISubscriber {

	public abstract boolean subscribe(String location, Date from, Date to);

	public abstract boolean unsubscribe(String location, Date from, Date to);

}
