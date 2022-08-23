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

/**
 * purpose:creating different bankDetails services
 * @author Anuj Solanki
 */
@Service
public class BankDetailsServices implements IBankDetailsServices{

    @Autowired
    IBankDetailsRepository bankDetailsRepository;
    @Autowired
    IAdminRepository adminRepository;
    @Autowired
    Token tokenUtil;

    /**
     *  Purpose:adding bank details of candidate
     * @param token
     * @param bankDetailsDTO
     * @return
     */
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
    /**
     *  Purpose:getting bank details
     * @param token
     * @param accountId
     * @return
     */
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
    /**
     *  Purpose:updating bank details
     * @param token
     * @param accountId
     * @param bankDetailsDTO
     * @return
     */
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
    /**
     *  Purpose:deleting bank details
     * @param token
     * @param accountId
     * @return
     */
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
