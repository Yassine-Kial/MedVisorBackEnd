package com.emi.medicalimageprocessing.services;

import com.emi.medicalimageprocessing.dto.SurveyDto;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;

public interface AiModelService {
    SurveyDto preProcessData(SurveyDto dto) throws JSONException;
    ResponseEntity<String> sendRequestToAiModel(SurveyDto dto);
    public double extractResultValue(ResponseEntity<String> responseEntity);

}
