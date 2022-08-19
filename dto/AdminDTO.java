package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class AdminDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$", message = " First Name is invalid")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$", message = " Last Name is invalid")
    private String lastName;
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "Mobile Number is Invalid !")
    private String mobileNo;
    @Pattern(regexp = "^[a-z]{1,}[@]{1}[a-z]{2,}[.]{1}[a-z]{3,}",message = "invalid")
    private String emailId;
    private String password;
    @NotEmpty(message = "Profile Path Can't be Empty.")
    private String profilePath;
//    @NotEmpty(message = "Status Can't be Empty.")
    private String status;
}
