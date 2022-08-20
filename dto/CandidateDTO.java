package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class CandidateDTO {

    @NotNull(message = "CICID can't be empty.")
    private String cicId;
    @Pattern(regexp = "^[A-Z]{1}[a-z A-Z \\s]{2,}$",message = "name is not valid")
    private String fullName;
    @Pattern(regexp = "^[a-z]{1,}[@]{1}[a-z]{2,}[.]{1}[a-z]{3,}",message = "invalid email id ")
    private String email;
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}",message = "Invalid Mobile Number !")
    private String mobileNo;
    @NotNull(message = "Hiring Date Can Not Be Noll ")
    private String hireDate;
    @NotEmpty(message = "Required.")
    private String degree;
    @NotNull(message = "aggregate percentage required.")
    private Double aggPer;
    @NotEmpty(message = "city required.")
    private String city;
    @NotEmpty(message = " required.")
    private String state;
    @NotEmpty(message = "Required.")
    private String preferredJobLocation;
    @NotEmpty(message = "Required.")
    private String status;
    @NotEmpty(message = "Required.")
    private String passOutYear;
    @NotEmpty(message = "Required.")
    private String creatorUser;
    @NotEmpty(message = "Required.")
    private String candidateStatus;
}
