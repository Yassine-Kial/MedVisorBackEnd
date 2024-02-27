package com.emi.medicalimageprocessing.services.impl;

import com.emi.medicalimageprocessing.dto.SurveyDto;
import com.emi.medicalimageprocessing.services.AiModelService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;



@Service
@Slf4j
public class AiModelServiceImpl implements AiModelService {


    private RestTemplate restTemplate;

    @Autowired
    public AiModelServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    final String AIAPIURL = "http://localhost:4090/submitData";
    @Override
    public SurveyDto preProcessData(SurveyDto dto) {
        return dto;
    }
    @Override
    public ResponseEntity<String> sendRequestToAiModel(SurveyDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SurveyDto> requestEntity = new HttpEntity<>(dto, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(AIAPIURL, requestEntity, String.class);
        return responseEntity;
    }

    @Override
    public double extractResultValue(ResponseEntity<String> responseEntity) {
        if (responseEntity != null && responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();
            int startIndex = responseBody.indexOf("\"prediction\":");
            if (startIndex >= 0) {
                try {
                    // Find the index of the end of the prediction value
                    int endIndex = responseBody.indexOf(",", startIndex);
                    if (endIndex == -1) {
                        endIndex = responseBody.indexOf("}", startIndex);
                    }
                    // Extract the prediction value
                    String predictionString = responseBody.substring(startIndex + 13, endIndex).trim();
                    return Double.parseDouble(predictionString);
                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    return -1.0; // Return -1.0 for error or if prediction value is not found
                }
            } else {
                return -1.0; // Prediction value not found in response body
            }
        } else {
            return -1.0; // Non-successful response status
        }
    }


}



