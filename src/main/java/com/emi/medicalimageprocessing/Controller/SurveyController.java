package com.emi.medicalimageprocessing.Controller;


import com.emi.medicalimageprocessing.Controller.api.SurveyApi;
import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.dto.UserDto;
import com.emi.medicalimageprocessing.model.Survey;
import com.emi.medicalimageprocessing.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyController implements SurveyApi {



    private SurveyService surveyService;


    @Autowired

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @Override
    public SurveyDto save(SurveyDto dto) {
        return surveyService.save(dto);
    }
}
