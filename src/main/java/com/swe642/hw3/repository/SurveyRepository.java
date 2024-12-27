package com.swe642.hw3.repository;

/**
 * Define SurveyRepository interface
 * @author Russell Bisker, Jonathan Hus, John Smolak
 */

import com.swe642.hw3.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
