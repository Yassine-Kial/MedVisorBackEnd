package com.emi.medicalimageprocessing.repository;

import com.emi.medicalimageprocessing.model.Survey;
import com.emi.medicalimageprocessing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    Survey save(Survey survey);
    Optional<Survey> findById(Integer id);

    Optional<Survey> findFirstByOrderByIdDesc();
}
