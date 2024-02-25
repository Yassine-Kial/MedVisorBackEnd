package com.emi.medicalimageprocessing.Controller;


import com.emi.medicalimageprocessing.Controller.api.SurveyApi;
import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.services.AiModelService;
import com.emi.medicalimageprocessing.services.SurveyService;
import com.emi.medicalimageprocessing.validator.SurveyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class SurveyController implements SurveyApi {
    private SurveyService surveyService;
    private AiModelService aiModelService;

    private SurveyValidator surveyValidator;


    @Autowired

    public SurveyController(SurveyService surveyService, AiModelService aiModelService,SurveyValidator surveyValidator) {
        this.surveyService = surveyService;
        this.aiModelService = aiModelService;
        this.surveyValidator = surveyValidator;
    }
    @Override
    public ResponseEntity<String> save(SurveyDto dto) {

        List<String> validationErrors = SurveyValidator.validate(dto);

        if(!validationErrors.isEmpty()) {
            String errorMessage = "Validation errors: " + String.join(", ", validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }


        surveyService.save(dto);
        SurveyDto data = aiModelService.preProcessData(dto);
        return aiModelService.sendRequestToAiModel(data);
    }
}
