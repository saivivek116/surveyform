package com.swe645.surveyform.controller;

import com.swe645.surveyform.jpa.Surveyformresponse;
import com.swe645.surveyform.service.SurveyformService;
import com.swe645.surveyform.service.SurveyformServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyformController {

    @Autowired
    private SurveyformService surveyformService;
    @PostMapping("/surveyresponse")
    public Surveyformresponse printHello(@RequestBody Surveyformresponse surveyformresponse){
        return surveyformService.saveSurveyResponse(surveyformresponse);
    }

    @GetMapping("/surveyresponse")
    public List<Surveyformresponse> fetchSurveyResponses(){
        return surveyformService.fetchSurveyResponses();
    }
}
