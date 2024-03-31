package com.swe645.surveyform.service;

import com.swe645.surveyform.jpa.Surveyformresponse;
import com.swe645.surveyform.repository.SurveyformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyformServiceImpl implements SurveyformService{
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
}
