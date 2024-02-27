package com.emi.medicalimageprocessing.Controller;


import com.emi.medicalimageprocessing.Controller.api.SurveyApi;
import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.model.Survey;
import com.emi.medicalimageprocessing.services.AiModelService;
import com.emi.medicalimageprocessing.services.SurveyService;
import com.emi.medicalimageprocessing.validator.SurveyValidator;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> save(SurveyDto dto) throws JSONException {

        List<String> validationErrors = SurveyValidator.validate(dto);

        if(!validationErrors.isEmpty()) {
            String errorMessage = "Validation errors: " + String.join(", ", validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }


        SurveyDto data = aiModelService.preProcessData(dto);
        ResponseEntity<String> stringResult = aiModelService.sendRequestToAiModel(data);

        double result = this.aiModelService.extractResultValue(stringResult);
        int realResult = (int)result;
        dto.setResult(realResult);
        surveyService.save(dto);
        System.out.println(realResult);
        System.out.println(stringResult);


        return stringResult;
    }
    @Override
    public int getByMaxId(){
        Optional<Survey> survey =this.surveyService.getRowWithMaxId();
        int result = survey.get().getResult();
        return result;
    }
}
