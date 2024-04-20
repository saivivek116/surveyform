package com.swe645.surveyform.controller;

import com.swe645.surveyform.jpa.Surveyformresponse;
import com.swe645.surveyform.service.SurveyformService;
import com.swe645.surveyform.service.SurveyformServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurveyformController {

    @Autowired
    private SurveyformService surveyformService;
    @PostMapping("/surveyresponse")
    public Surveyformresponse addSurvey(@RequestBody Surveyformresponse surveyformresponse){
        return surveyformService.saveSurveyResponse(surveyformresponse);
    }

    @GetMapping("/surveyresponse")
    public List<Surveyformresponse> fetchSurveyResponses(){
        return surveyformService.fetchSurveyResponses();
    }

    @PutMapping("/surveyresponse/{id}")
    public Surveyformresponse updateSurvey(@PathVariable("id") Long id, @RequestBody Surveyformresponse surveyformresponse){
        return surveyformService.updateSurveyResponse(id, surveyformresponse);
    }

    // API to delete a survey response
    @DeleteMapping("/surveyresponse/{id}")
    public String deleteSurveyResponse(@PathVariable("id") Long id) {
        surveyformService.deleteSurveyResponse(id);

        return "Survey deleted successfully.";
    }
}
