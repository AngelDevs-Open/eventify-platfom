package com.eventify.platform.SocialEvent.domain.model.aggregates;



import com.eventify.platform.SocialEvent.domain.model.valueobjects.*;
import com.eventify.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

/*
*SocialEvent Aggregate Root
*
*/
@Entity
public class SocialEvent extends AuditableAbstractAggregateRoot<SocialEvent>
{

    @Embedded
    private SocialEventTitle title;

    @Embedded
    private CustomerName customerName;

    @Embedded
    private Place place;

    @Embedded
    private SocialEventDate date;

    @Embedded
    private SocialEventStatus status;






    /**
     * Constructor with full value objects.
     *
     * @param title        the title of the event
     * @param place        the location of the event
     * @param date         the scheduled date
     * @param customerName the customer full name
     * @param status       the current status of the event
     */
    public SocialEvent(SocialEventTitle title, Place place, SocialEventDate date,
                       CustomerName customerName, SocialEventStatus status) {
        this.title = title;
        this.place = place;
        this.date = date;
        this.customerName = customerName;
        this.status = status;

    }

    protected SocialEvent() {}

    // Getters for each embedded value object

    public String getTitle() {
        return title.title();
    }

    public String getPlace() {
        return place.place();
    }

    public String getCustomerName() {
        return customerName.customerName();
    }

    public java.time.LocalDate getDate() {
        return date.eventDate();
    }

    public String getEventStatus() {
        return status.valueStatus();
    }


    /**
     * Allows updating the event's status.
     *
     * @param newStatus the new status to set
     */
    public void updateStatus(String newStatus) {
        this.status = new SocialEventStatus(newStatus);


    }

    /**
     * Allows updating basic event details.
     *
     * @param newTitle new title
     * @param newPlace new place
     * @param newDate  new date
     */
    public void updateDetails(String newTitle, String newPlace, java.time.LocalDate newDate) {
        this.title = new SocialEventTitle(newTitle);
        this.place = new Place(newPlace);
        this.date = new SocialEventDate(newDate);
    }
}



