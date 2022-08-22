package com.bridgelabz.lmsproject.dto;

import lombok.Data;

@Data
public class BankDetailsDTO {
    private String accountNumber;
    private String ifscCode;
    private String branch;
    private String linkedMobileNumber;
    private String accountHolderName;
}
