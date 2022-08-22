package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.AdminDTO;
import com.bridgelabz.lmsproject.dto.BankDetailsDTO;
import com.bridgelabz.lmsproject.exception.AdminNotFound;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.BankDetailsModel;
import com.bridgelabz.lmsproject.repository.IAdminRepository;
import com.bridgelabz.lmsproject.repository.IBankDetailsRepository;
import com.bridgelabz.lmsproject.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BankDetailsServices implements IBankDetailsServices{

    @Autowired
    IBankDetailsRepository bankDetailsRepository;
    @Autowired
    IAdminRepository adminRepository;
    @Autowired
    Token tokenUtil;
    @Override
    public BankDetailsModel addBankDetails(String token,BankDetailsDTO bankDetailsDTO) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            BankDetailsModel bankDetailsModel = new BankDetailsModel(bankDetailsDTO);
            bankDetailsModel.setCreatorDateTime(LocalDateTime.now());
            bankDetailsModel.setCreatorUser(adminModel.get());
            bankDetailsRepository.save(bankDetailsModel);
            return bankDetailsModel;
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    @Override
    public BankDetailsModel getBankDetails(String token, long accountId) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()){
            Optional<BankDetailsModel> bankDetailsModel=bankDetailsRepository.findById(accountId);
            return bankDetailsModel.get();
        }
       throw new AdminNotFound(200,"Admin Not Found !");
    }

    @Override
    public BankDetailsModel updateBankDetails(String token,long accountId, BankDetailsDTO bankDetailsDTO) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()){
            BankDetailsModel bankDetailsModel=this.getBankDetails(token,accountId);
            bankDetailsModel.setAccountHolderName(bankDetailsDTO.getAccountHolderName());
            bankDetailsModel.setAccountNumber(bankDetailsDTO.getAccountNumber());
            bankDetailsModel.setIfscCode(bankDetailsDTO.getIfscCode());
            bankDetailsModel.setBranch(bankDetailsDTO.getBranch());
            bankDetailsModel.setLinkedMobileNumber(bankDetailsDTO.getLinkedMobileNumber());
            bankDetailsModel.setUpdatedUser(adminModel.get());
            bankDetailsModel.setUpdatedDateTime(LocalDateTime.now());
            bankDetailsRepository.save(bankDetailsModel);
            return bankDetailsModel;
        }
       throw new AdminNotFound(200,"Admin Not Found !");
    }

    @Override
    public BankDetailsModel deleteBankDetails(String token, long accountId) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()){
            BankDetailsModel bankDetailsModel=this.getBankDetails(token,accountId);
            bankDetailsRepository.delete(bankDetailsModel);
            return bankDetailsModel;
        }

        throw new AdminNotFound(200,"Admin Not Found !");
    }
}
