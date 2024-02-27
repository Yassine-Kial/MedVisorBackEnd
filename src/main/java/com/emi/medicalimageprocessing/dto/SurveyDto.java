package com.emi.medicalimageprocessing.dto;


import com.emi.medicalimageprocessing.model.Survey;
import com.emi.medicalimageprocessing.model.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class SurveyDto {

    private Integer id;
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    private String gender;
    private String workType;
    private String residenceType;
    private String smokingStatus;
    private int age;
    private float avgGlucoseLevel;
    private float bmi;
    private int hypertension;
    private int heartDisease;
    private String everMarried;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAvgGlucoseLevel() {
        return avgGlucoseLevel;
    }

    public void setAvgGlucoseLevel(float avgGlucoseLevel) {
        this.avgGlucoseLevel = avgGlucoseLevel;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public int getHypertension() {
        return hypertension;
    }

    public void setHypertension(int hypertension) {
        this.hypertension = hypertension;
    }

    public int getHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(int heartDisease) {
        this.heartDisease = heartDisease;
    }

    public String getEverMarried() {
        return everMarried;
    }

    public void setEverMarried(String everMarried) {
        this.everMarried = everMarried;
    }

    public static SurveyDto fromEntity (Survey survey){
        if (survey ==null) {
            return null;
        }
        return SurveyDto.builder()

                .id(survey.getId())
                .gender(survey.getGender())
                .workType(survey.getWorkType())
                .residenceType(survey.getResidenceType())
                .smokingStatus(survey.getSmokingStatus())
                .age(survey.getAge())
                .avgGlucoseLevel(survey.getAvgGlucoseLevel())
                .bmi(survey.getBmi())
                .hypertension(survey.getHypertension())
                .heartDisease(survey.getHeartDisease())
                .everMarried(survey.getEverMarried())
                .result(survey.getResult())
                .build();
    }
    public static Survey toEntity (SurveyDto surveyDto){
        if (surveyDto ==null) {
            return null;
        }
        Survey survey=new Survey();
        survey.setId(surveyDto.getId());
        survey.setGender(surveyDto.getGender());
        survey.setWorkType(surveyDto.getWorkType());
        survey.setResidenceType(surveyDto.getResidenceType());
        survey.setSmokingStatus(surveyDto.getSmokingStatus());
        survey.setAge(surveyDto.getAge());
        survey.setAvgGlucoseLevel(surveyDto.getAvgGlucoseLevel());
        survey.setBmi(surveyDto.getBmi());
        survey.setHypertension(surveyDto.getHypertension());
        survey.setHeartDisease(surveyDto.getHeartDisease());
        survey.setEverMarried(surveyDto.getEverMarried());
        survey.setResult(surveyDto.getResult());
        return survey;
    }
}


