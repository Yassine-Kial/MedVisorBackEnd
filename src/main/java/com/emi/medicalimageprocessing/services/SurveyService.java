package com.emi.medicalimageprocessing.services;

import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.dto.UserDto;
import com.emi.medicalimageprocessing.model.Survey;

import java.util.Optional;

public interface SurveyService {
    SurveyDto save(SurveyDto dto);

    Optional<Survey> getRowWithMaxId();
}
