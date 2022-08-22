package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.BankDetailsDTO;
import com.bridgelabz.lmsproject.model.BankDetailsModel;
import com.bridgelabz.lmsproject.service.IBankDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bankDetails")
public class BankDetailsController {

    @Autowired
    IBankDetailsServices bankDetailsServices;

    @PostMapping("/addBankDetails")
    public BankDetailsModel addBankDetails(@RequestParam String token, @RequestBody BankDetailsDTO bankDetailsDTO){
        return bankDetailsServices.addBankDetails(token,bankDetailsDTO);
    }
    @GetMapping("/getBankDetails")
    public BankDetailsModel getBankDetails(@RequestParam String token,@RequestParam long accountId){
        return bankDetailsServices.getBankDetails(token,accountId);
    }

    @PutMapping("/updateBankDetails")
    public BankDetailsModel updateBankDetails(@RequestParam String token,@RequestParam long accountId, @Valid @RequestBody BankDetailsDTO bankDetailsDTO){
        return bankDetailsServices.updateBankDetails(token,accountId,bankDetailsDTO);
    }

    @DeleteMapping("/deleteBankDetails")
    public BankDetailsModel deleteBankDetails(@RequestParam String token,@RequestParam long accountId){
        return bankDetailsServices.deleteBankDetails(token,accountId);
    }
}
