package com.swe642.hw3.controller;

/**
 * REST controller for survey service
 * @author Russell Bisker, Jonathan Hus, John Smolak
 */

import com.swe642.hw3.model.Survey;
import com.swe642.hw3.service.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        super();
        this.surveyService = surveyService;
    }

    @PostMapping
    public ResponseEntity<Survey> saveSurvey(@RequestBody Survey survey) {
        return new ResponseEntity<Survey>(surveyService.saveSurvey(survey), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @GetMapping("{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable("id") long surveyId) {
        return new ResponseEntity<Survey>(surveyService.getSurveyById(surveyId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable("id") long id, @RequestBody Survey survey) {
        return new ResponseEntity<Survey>(surveyService.updateSurvey(survey, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> deleteSurvey(@PathVariable("id") long id) {
        surveyService.deleteSurvey(id);

//        return new ResponseEntity<String>("Survey deleted successfully.", HttpStatus.OK);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Survey deleted successfully.");
        return ResponseEntity.ok(response);
    }

}
