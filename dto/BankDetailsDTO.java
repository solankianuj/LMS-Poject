package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *  Purpose:creating bankDetails dto and adding validation on bankDetails dto
 * @author Anuj Solanki
 */
@Data
public class BankDetailsDTO {
    @Pattern(regexp = "[A-Z a-z 0-9]{4,}",message = "invalid account number")
    private String accountNumber;
    @Pattern(regexp = "[A-Z a-z 0-9]{4,}",message = "invalid ifsc number")
    private String ifscCode;
    @NotNull(message = "branch is required")
    private String branch;
    @Pattern(regexp = "[0-9]{10}",message = "invalid mobile number")
    private String linkedMobileNumber;
    @Pattern(regexp = "^[A-Z]{1}[a-z A-Z \\s]{2,}",message = "invalid name ")
    private String accountHolderName;
}
