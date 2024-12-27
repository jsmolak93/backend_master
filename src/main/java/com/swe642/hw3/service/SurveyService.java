package com.swe642.hw3.service;

/**
 * Defines a SurveyService interface
 * @author Russell Bisker, Jonathan Hus, John Smolak
 */

import com.swe642.hw3.model.Survey;

import java.util.List;

public interface SurveyService {
    Survey saveSurvey(Survey survey);
    List<Survey> getAllSurveys();
    Survey getSurveyById(long id);
    Survey updateSurvey(Survey survey, long id);
    void deleteSurvey(long id);
}
