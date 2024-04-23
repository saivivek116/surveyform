/* 
# author:
# Sai Vivek Vangaveti - G01413358
# Venkata Sree Divya Kasturi - G01411963
# Mary Ashwitha Gopu - G01408743
# Gangadhara Sai Kutukuppala - G01444780
# functionality: File where the business logic for the survey form is implemented

*/
package com.swe645.surveyform.service;

import com.swe645.surveyform.jpa.Surveyformresponse;
import com.swe645.surveyform.repository.SurveyformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SurveyformServiceImpl implements SurveyformService {
    @Autowired
    private SurveyformRepository surveyformRepository;

    @Override
    public Surveyformresponse saveSurveyResponse(Surveyformresponse surveyformresponse) {
        return surveyformRepository.save(surveyformresponse);
    }

    @Override
    public List<Surveyformresponse> fetchSurveyResponses() {
        return surveyformRepository.findAll();
    }

    @Override
    public void deleteSurveyResponse(Long id) {
        surveyformRepository.deleteById(id);
    }

    @Override
    public Surveyformresponse updateSurveyResponse(Long id, Surveyformresponse surveyformresponse) {
        Surveyformresponse sur = surveyformRepository.findById(id).get();
        if (surveyformresponse.getFirst_name() != null && !surveyformresponse.getFirst_name().isEmpty()) {
            sur.setFirst_name(surveyformresponse.getFirst_name());
        }

        // Update last name if provided
        if (surveyformresponse.getLast_name() != null && !surveyformresponse.getLast_name().isEmpty()) {
            sur.setLast_name(surveyformresponse.getLast_name());
        }

        // Update street address if provided
        if (surveyformresponse.getStreet_address() != null && !surveyformresponse.getStreet_address().isEmpty()) {
            sur.setStreet_address(surveyformresponse.getStreet_address());
        }

        // Update city if provided
        if (surveyformresponse.getCity() != null && !surveyformresponse.getCity().isEmpty()) {
            sur.setCity(surveyformresponse.getCity());
        }

        // Update state if provided
        if (surveyformresponse.getState() != null && !surveyformresponse.getState().isEmpty()) {
            sur.setState(surveyformresponse.getState());
        }

        // Update zip if provided
        if (surveyformresponse.getZip() != null && !surveyformresponse.getZip().isEmpty()) {
            sur.setZip(surveyformresponse.getZip());
        }

        // Update telephone number if provided
        if (surveyformresponse.getTelephone_number() != null && !surveyformresponse.getTelephone_number().isEmpty()) {
            sur.setTelephone_number(surveyformresponse.getTelephone_number());
        }

        // Update email if provided
        if (surveyformresponse.getEmail() != null && !surveyformresponse.getEmail().isEmpty()) {
            sur.setEmail(surveyformresponse.getEmail());
        }

        // Update date of survey if provided
        if (surveyformresponse.getDate_of_survey() != null) {
            sur.setDate_of_survey(surveyformresponse.getDate_of_survey());
        }

        // Update liked most about campus if provided
        if (surveyformresponse.getLikedMostAboutCampus() != null) {
            sur.setLikedMostAboutCampus(surveyformresponse.getLikedMostAboutCampus());
        }

        // Update interest source if provided
        if (surveyformresponse.getInterestSource() != null) {
            sur.setInterestSource(surveyformresponse.getInterestSource());
        }

        // Update recommendation likelihood if provided
        if (surveyformresponse.getRecommendationLikelihood() != null) {
            sur.setRecommendationLikelihood(surveyformresponse.getRecommendationLikelihood());
        }

        return surveyformRepository.save(sur);

    }

}
