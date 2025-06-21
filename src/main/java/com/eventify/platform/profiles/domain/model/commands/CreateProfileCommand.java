package com.eventify.platform.profiles.domain.model.commands;

/**
 * CreateProfileCommand
 *
 * @summary
 * Command to create a new profile with personal information.
 * Contains all necessary data for profile creation.
 *
 * @param firstName First name of the person
 * @param lastName Last name of the person
 * @param email Email address
 * @param street Street address
 * @param number Street number
 * @param city City
 * @param postalCode Postal code
 * @param country Country
 * @since 1.0
 */
public record CreateProfileCommand(
        String firstName,
        String lastName,
        String email,
        String street,
        String number,
        String city,
        String postalCode,
        String country
) {
    /**
     * Constructor with validation
     *
     * @param firstName First name of the person
     * @param lastName Last name of the person
     * @param email Email address
     * @param street Street address
     * @param number Street number
     * @param city City
     * @param postalCode Postal code
     * @param country Country
     * @throws IllegalArgumentException if required fields are null or empty
     */
    public CreateProfileCommand {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is required");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
    }
}