package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.BankDetailsDTO;
import com.bridgelabz.lmsproject.model.BankDetailsModel;

public interface IBankDetailsServices {
    BankDetailsModel addBankDetails(String token,BankDetailsDTO bankDetailsDTO);

    BankDetailsModel getBankDetails(String token, long id);

    BankDetailsModel updateBankDetails(String token,long accountId, BankDetailsDTO bankDetailsDTO);

    BankDetailsModel deleteBankDetails(String token, long accountId);
}
