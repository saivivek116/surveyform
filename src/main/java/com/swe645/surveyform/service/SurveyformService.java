package com.swe645.surveyform.service;

import com.swe645.surveyform.jpa.Surveyformresponse;

import java.util.List;

public interface SurveyformService {
    public Surveyformresponse updateSurveyResponse(Long id, Surveyformresponse surveyformresponse);

    public Surveyformresponse saveSurveyResponse(Surveyformresponse surveyformresponse);

    public List<Surveyformresponse> fetchSurveyResponses();

//    Surveyformresponse updateSurveyResponse(Long id, Surveyformresponse surveyformresponse);

    void deleteSurveyResponse(Long id);
}
