package com.eventify.platform.operation.domain.model.aggreagates;

import com.eventify.platform.operation.domain.model.commands.CreateReviewCommand;
import com.eventify.platform.operation.domain.model.valueobjects.ProfileId;
import com.eventify.platform.operation.domain.model.valueobjects.ReviewRating;
import com.eventify.platform.operation.domain.model.valueobjects.SocialEventId;
import com.eventify.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
public class Review extends AuditableAbstractAggregateRoot<Review> {

    private String content;
    private Integer rating;

    @Embedded
    private ProfileId profileId;

    @Embedded
    private SocialEventId socialEventId;

    /**
     * Default constructor for JPA
     */
    public Review () {}

    public Review(CreateReviewCommand command, ProfileId profileId){
        this();
        this.content = command.content();
        this.rating = command.rating();
        this.profileId = profileId;
        this.socialEventId = command.socialEventId();
    }

    public Long getProfileId() {
        return this.profileId.profileId();
    }

    public Long getSocialEventId() {
        return this.socialEventId.socialEventId();
    }


}
