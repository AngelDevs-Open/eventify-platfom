package com.eventify.platform.planning.domain.model.aggregates;

import com.eventify.platform.planning.domain.model.commands.CreateQuoteCommand;
import com.eventify.platform.planning.domain.model.valueobjects.EventType;
import com.eventify.platform.planning.domain.model.valueobjects.QuoteId;
import com.eventify.platform.planning.domain.model.valueobjects.QuoteStatus;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Quote extends AbstractAggregateRoot<Quote> {

    @Getter
    @Id
    QuoteId quoteId;

    @Getter
    String title;
    @Getter
    @Enumerated(EnumType.STRING)
    EventType eventType;
    @Getter
    int guestQuantity;
    @Getter
    String location;
    @Getter
    double totalPrice;
    @Getter
    @Enumerated(EnumType.STRING)
    QuoteStatus state;

    @Getter
    @Column(columnDefinition = "datetime")
    Date eventDate;



    @Getter
    @AttributeOverride(name = "profileId", column = @Column(name = "organizer_id"))
    int organizerId;

    @Getter
    @AttributeOverride(name = "profileId", column = @Column(name = "host_id"))
    int hostId;

    @Column(nullable=false, updatable=false,columnDefinition = "datetime")
    @CreatedDate
    Date createdAt;

    @Column(nullable=false, columnDefinition = "datetime")
    @LastModifiedDate
    Date updatedAt;

    public Quote(){
        this.quoteId = new QuoteId();
    }

    public Quote(CreateQuoteCommand command){
        this();
        this.title = command.title();
        this.eventType = command.eventType();
        this.guestQuantity = command.guestQuantity();
        this.location = command.location();
        this.totalPrice = command.totalPrice();
        this.eventDate = command.eventDate();
        this.state = command.state();
        this.organizerId = command.organizerId();
        this.hostId = command.hostId();
    }

    public Quote updateInformation(String title, EventType eventType, int guestQuantity, String location, double totalPrice, Date eventDate){
        if(title !=null && !title.isBlank()){
            this.title = title;
        }
        if(eventType != null ){
            this.eventType = eventType;
        }
        if(guestQuantity > 0){
            this.guestQuantity = guestQuantity;
        }
        if(location !=null && !location.isBlank()){
            this.location = location;
        }
        if(totalPrice > 0){
            this.totalPrice = totalPrice;
        }
        if(state != null){
            this.state = state;
        }
        if(eventDate != null){
            this.eventDate = eventDate;
        }
        return this;
    }

    public String getQuoteId(){
        return this.quoteId.quoteId();
    }


    public void accept(){
        this.state = QuoteStatus.ACCEPTED;
    }

    public void reject(){
        this.state = QuoteStatus.REJECTED;
    }


}
