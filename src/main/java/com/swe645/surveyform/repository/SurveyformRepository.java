package com.swe645.surveyform.repository;

import com.swe645.surveyform.jpa.Surveyformresponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyformRepository extends JpaRepository<Surveyformresponse, Long> {
}
