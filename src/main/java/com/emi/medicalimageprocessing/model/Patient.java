package com.emi.medicalimageprocessing.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="patient")
public class Patient extends AbstractEntity {

    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="dateOfBirth")
    private Instant dateOfBirth;
    @Column(name="gender")
    private String gender;
    @Column(name="age")
    private Integer Age;
    @Column(name="adress")
    private String address;
    @Column(name="phoneNumber")
    private String phoneNumber;
}
