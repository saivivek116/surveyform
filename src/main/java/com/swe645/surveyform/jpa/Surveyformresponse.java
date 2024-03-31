package com.swe645.surveyform.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;


@Data
@Entity
public class Surveyformresponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surveyId;
    private String first_name;
    private String last_name;
    private String street_address;
    private String city;
    private String state;
    private String zip;

    private String telephone_number;

    private String email;

    private Date date_of_survey;

    @Enumerated(EnumType.STRING)
    private CampusPreference likedMostAboutCampus;

    @Enumerated(EnumType.STRING)
    private InterestSource interestSource;

    @Enumerated(EnumType.STRING)
    private RecommendationLikelihood recommendationLikelihood;

    public enum CampusPreference {
        STUDENTS, LOCATION, CAMPUS, ATMOSPHERE, DORM_ROOMS, SPORTS
    }

    public enum InterestSource {
        FRIENDS, TELEVISION, INTERNET, OTHER
    }

    public enum RecommendationLikelihood {
        VERY_LIKELY, LIKELY, UNLIKELY
    }


    @PrePersist
    public void prePersist() {
        if (date_of_survey == null) { // Only set the current date if it hasn't been set already
            date_of_survey = Date.valueOf(LocalDate.now());
        }
    }

}
