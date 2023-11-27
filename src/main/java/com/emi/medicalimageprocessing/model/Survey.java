package com.emi.medicalimageprocessing.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name="survey")
public class Survey extends AbstractEntity {
    @Column(name = "id")
    private Integer id;


    @Column(name = "gender")
    private String gender;
    @Column(name = "workType")
    private String workType;
    @Column(name = "residenceType")
    private String residenceType;
    @Column(name = "smokingStatus")
    private String smokingStatus;
    @Column(name = "age")
    private int age;
    @Column(name = "avgGlucoseLevel")
    private float avgGlucoseLevel;
    @Column(name = "bmi")
    private float bmi;
    @Column(name = "hypertension")
    private int hypertension;
    @Column(name = "heartDisease")
    private int heartDisease;
    @Column(name = "everMarried")
    private int everMarried;


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
    public int getEverMarried() {
        return everMarried;
    }
    public void setEverMarried(int everMarried) {
        this.everMarried = everMarried;
    }
}
