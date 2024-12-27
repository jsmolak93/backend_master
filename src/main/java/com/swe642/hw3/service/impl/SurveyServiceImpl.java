package com.swe642.hw3.service.impl;

/**
 * Implementation of SurveyService interface
 * @author Russell Bisker, Jonathan Hus, John Smolak
 */

import com.swe642.hw3.exception.ResourceNotFoundException;
import com.swe642.hw3.model.Survey;
import com.swe642.hw3.repository.SurveyRepository;
import com.swe642.hw3.service.SurveyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {

    public SurveyRepository surveyRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        super();
        this.surveyRepository = surveyRepository;
    }

    @Override
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey getSurveyById(long id) {
        Optional<Survey> survey = surveyRepository.findById(id);

        if (survey.isPresent()) {
            return survey.get();
        } else {
            throw new ResourceNotFoundException("Survey", "Id", id);
        }
    }

    @Override
    public Survey updateSurvey(Survey survey, long id) {
        Survey existingSurvey = surveyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "Id", id));
        existingSurvey.setFirstName(survey.getFirstName());
        existingSurvey.setLastName(survey.getLastName());
        existingSurvey.setAddress(survey.getAddress());
        existingSurvey.setCity(survey.getCity());
        existingSurvey.setState(survey.getState());
        existingSurvey.setZipcode(survey.getZipcode());
        existingSurvey.setTelephone(survey.getTelephone());
        existingSurvey.setEmail(survey.getEmail());
        existingSurvey.setComments(survey.getComments());
        existingSurvey.setSurvey_date(survey.getSurvey_date());
        existingSurvey.setRecommendation(survey.getRecommendation());
        existingSurvey.setInterest(survey.getInterest());
        existingSurvey.setLikes(survey.getLikes());

        surveyRepository.save(existingSurvey);

        return existingSurvey;
    }

    @Override
    public void deleteSurvey(long id) {
        surveyRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Survey", "Id", id));
        surveyRepository.deleteById(id);
    }
}
