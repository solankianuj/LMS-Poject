package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class CandidateDTO {

    @NotEmpty(message = "CICID can't be empty.")
    private String cicId;
    @Pattern(regexp = "^[A-Z]{1}[a-z A-Z \\s]{2,}$",message = "name is not valid")
    private String fullName;
    private String email;
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}",message = "Invalid Mobile Number !")
    private String mobileNo;
    private String hireDate;
    private String degree;
    private Double aggPer;
    private String city;
    private String state;
    private String preferredJobLocation;
    private String status;
    private String passOutYear;
    private String creatorUser;
    private String candidateStatus;
}
