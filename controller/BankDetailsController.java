package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.BankDetailsDTO;
import com.bridgelabz.lmsproject.model.BankDetailsModel;
import com.bridgelabz.lmsproject.service.IBankDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *  Purpose:Bank Details Operation Controller
 * @author Anuj Solanki
 */

@RestController
@RequestMapping("/bankDetails")
public class BankDetailsController {


    @Autowired
    IBankDetailsServices bankDetailsServices;

    /**
     *  Purpose:adding bank details of candidate
     * @param token
     * @param bankDetailsDTO
     * @return
     */
    @PostMapping("/addBankDetails")
    public BankDetailsModel addBankDetails(@RequestParam String token, @Valid @RequestBody BankDetailsDTO bankDetailsDTO){
        return bankDetailsServices.addBankDetails(token,bankDetailsDTO);
    }

    /**
     *  Purpose:getting bank details
     * @param token
     * @param accountId
     * @return
     */
    @GetMapping("/getBankDetails")
    public BankDetailsModel getBankDetails(@RequestParam String token,@RequestParam long accountId){
        return bankDetailsServices.getBankDetails(token,accountId);
    }

    /**
     *  Purpose:updating bank details
     * @param token
     * @param accountId
     * @param bankDetailsDTO
     * @return
     */
    @PutMapping("/updateBankDetails")
    public BankDetailsModel updateBankDetails(@RequestParam String token,@RequestParam long accountId, @Valid @RequestBody BankDetailsDTO bankDetailsDTO){
        return bankDetailsServices.updateBankDetails(token,accountId,bankDetailsDTO);
    }

    /**
     *  Purpose:deleting bank details
     * @param token
     * @param accountId
     * @return
     */
    @DeleteMapping("/deleteBankDetails")
    public BankDetailsModel deleteBankDetails(@RequestParam String token,@RequestParam long accountId){
        return bankDetailsServices.deleteBankDetails(token,accountId);
    }
}
