package com.emi.medicalimageprocessing.validator;


import com.emi.medicalimageprocessing.dto.SurveyDto;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SurveyValidator {



    public static List<String> validate(SurveyDto surveyDto) {
        List<String> errors = new ArrayList<>();

        validateGender(surveyDto.getGender(),"Gender",errors);
        validateAge(surveyDto.getAge(),"Age",errors);
        validateMaritalStatus(surveyDto.getEverMarried(),"MaritalStatus",errors);
        validateResidentialArea(surveyDto.getResidenceType(),"Residential Area",errors);

        validateHeartDisease(surveyDto.getHeartDisease(),"Heart disease",errors);
        validateSmokingStatus(surveyDto.getSmokingStatus(),"Smoking status",errors);
        validateHypertension(surveyDto.getHypertension(),"Hypertension",errors);
        validateWorkType(surveyDto.getWorkType(), "Work type",errors);

        validateBMI(surveyDto.getBmi(),"BMI",errors);
        validateGlucose(surveyDto.getAvgGlucoseLevel(),"Glucose",errors);





        return errors;
    }

    public static void validateAge(Integer fieldValue, String fieldName, List<String> errors) {
        int minAge = 2;
        int maxAge = 100;
        String pattern = "^\\d+$";

        if (fieldValue == null) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else {
            if (fieldValue < minAge || fieldValue > maxAge) {
                errors.add(fieldName + " must be between 18 and 100");
            }

            if (!String.valueOf(fieldValue).matches(pattern)) {
                errors.add(fieldName + " must be a positive integer");
            }
        }

    }

    public static void validateGender(String fieldValue,String fieldName,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("Female") && !fieldValue.equals("Male")) {
            errors.add(fieldName + " must be either Female or Male");
        }
    }

    public static void validateMaritalStatus(String fieldValue, String fieldName, List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("Yes") && !fieldValue.equals("No")) {
            errors.add(fieldName + " must be either Yes or No");
        }
    }



    public static void validateBMI(float fieldValue, String fieldName, List<String> errors) {
        float minValue = 10.0f;
        float maxValue = 40.0f;

        if (Float.isNaN(fieldValue)) {
            errors.add("Please provide a valid " + fieldName.toLowerCase());
        } else if (fieldValue < minValue || fieldValue > maxValue) {
            errors.add(fieldName + " must be between " + minValue + " and " + maxValue);
        }
    }


    public static void validateGlucose(float fieldValue, String fieldName, List<String> errors) {
        float minValue = 70.0f;   // Example minimum glucose value in mg/dL
        float maxValue = 140.0f;  // Example maximum glucose value in mg/dL

        if (Float.isNaN(fieldValue)) {
            errors.add("Please provide a valid " + fieldName.toLowerCase());
        } else if (fieldValue < minValue || fieldValue > maxValue) {
            errors.add(fieldName + " must be between " + minValue + " and " + maxValue + " mg/dL");
        }
    }


    public static void validateHypertension(int fieldValue,String fieldName ,List<String> errors) {
        if (fieldValue != 0 && fieldValue != 1) {
            errors.add(fieldName + " must be either 0 or 1");
        }
    }

    public static void validateHeartDisease(int fieldValue,String fieldName ,List<String> errors) {
        if (fieldValue != 0 && fieldValue != 1) {
            errors.add(fieldName + " must be either 0 or 1");
        }
    }


    public static void validateResidentialArea(String fieldValue,String fieldName ,List<String> errors) {
        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!fieldValue.equals("Urban") && !fieldValue.equals("Rural")) {
            errors.add(fieldName + " must be either Urban or Rural");
        }
    }


    public static void validateSmokingStatus(String fieldValue, String fieldName, List<String> errors) {
        List<String> allowedValues = Arrays.asList("formerly smoked", "never smoked", "smokes","Unknown");

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!allowedValues.contains(fieldValue)) {
            errors.add(fieldName + " must be one of the following values: " + String.join(", ", allowedValues));
        }
    }

    public static void validateWorkType(String fieldValue, String fieldName, List<String> errors) {
        List<String> allowedValues = Arrays.asList("children", "Govt_job","Never_worked","Private","Self-employed","Private");

        if (!StringUtils.hasLength(fieldValue)) {
            errors.add("Please provide " + fieldName.toLowerCase());
        } else if (!allowedValues.contains(fieldValue)) {
            errors.add(fieldName + " must be one of the following values: " + String.join(", ", allowedValues));
        }
    }

}
