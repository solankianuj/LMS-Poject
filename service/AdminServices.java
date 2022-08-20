package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.AdminDTO;
import com.bridgelabz.lmsproject.exception.AdminNotFound;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.repository.IAdminRepository;
import com.bridgelabz.lmsproject.service.mailService.MailServices;
import com.bridgelabz.lmsproject.util.Response;
import com.bridgelabz.lmsproject.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminServices implements IAdminServices{

    @Autowired
    IAdminRepository iAdminRepository;
    @Autowired
    Token tokenutil;
    @Autowired
    MailServices mailServices;

    @Override
    public AdminModel addAdmin(AdminDTO adminDTO) {
        AdminModel adminModel=new AdminModel(adminDTO);
        iAdminRepository.save(adminModel);
        return adminModel;
    }

    @Override
    public AdminModel getAdmin(String token) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=iAdminRepository.findById(id);
        if (adminModel.isPresent()){
            return adminModel.get();
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    @Override
    public AdminModel updateAdmin(String token, AdminDTO adminDTO) {
        AdminModel adminModel=this.getAdmin(token);
        adminModel.setFirstName(adminDTO.getFirstName());
        adminModel.setLastName(adminDTO.getLastName());
        adminModel.setEmailId(adminDTO.getEmailId());
        adminModel.setMobileNo(adminDTO.getMobileNo());
        adminModel.setUpdatedStamp(LocalDateTime.now());
        adminModel.setStatus(adminDTO.getStatus());
        adminModel.setProfilePath(adminDTO.getProfilePath());
        adminModel.setPassword(adminDTO.getPassword());
        iAdminRepository.save(adminModel);
        return adminModel;
    }

    @Override
    public AdminModel deleteAdmin(String token) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=iAdminRepository.findById(id);
        iAdminRepository.delete(adminModel.get());
        return adminModel.get();
    }

    @Override
    public String  resetPassword(String emailId) {
        Optional<AdminModel> adminModel=iAdminRepository.findByEmailId(emailId);
        if (adminModel.isPresent()){
            if (adminModel.get().getEmailId().equals(emailId)){
                String token=tokenutil.createToken(adminModel.get().getId());
                String URL="click here "+"http://localhost:8080/admin/changePassword/"+token;
                String subject="Reset Password ..";
                mailServices.send(emailId,subject,URL);
            }
            throw new AdminNotFound(200,"Invalid Email ID !");
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    @Override
    public AdminModel changePassword(String token, String newPwd) {
        AdminModel adminModel=this.getAdmin(token);
        adminModel.setPassword(newPwd);
        iAdminRepository.save(adminModel);
        return adminModel;
    }

    @Override
    public AdminModel addProfile(String token, String path) {
        AdminModel adminModel=this.getAdmin(token);
        adminModel.setProfilePath(path);
        iAdminRepository.save(adminModel);
        return adminModel;
    }


    @Override
    public Response login(String emailId, String password) {
        Optional<AdminModel> adminModel=iAdminRepository.findByEmailId(emailId);
        if (adminModel.isPresent()){
            if (adminModel.get().getPassword().equals(password)){

                String tokenobj= tokenutil.createToken(adminModel.get().getId());
                return new Response("Login Success Full",200,tokenobj);
            }
            throw new AdminNotFound(200,"Invalid Credential !");
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }
}
