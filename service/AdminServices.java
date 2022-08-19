package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.AdminDTO;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.repository.IAdminRepository;
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

    @Override
    public AdminModel addAdmin(AdminDTO adminDTO) {
        AdminModel adminModel=new AdminModel(adminDTO);
        iAdminRepository.save(adminModel);
        return adminModel;
    }

    @Override
    public AdminModel getAdmin(long id) {
        Optional<AdminModel> adminModel=iAdminRepository.findById(id);
        if (adminModel.isPresent()){
            return adminModel.get();
        }
        return null;
    }

    @Override
    public AdminModel updateAdmin(long id, AdminDTO adminDTO) {
        AdminModel adminModel=this.getAdmin(id);
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
    public AdminModel deleteAdmin(long id) {
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
                return "http://localhost:8080/admin/changePassword/"+token;
            }
        }
        return null;
    }

    @Override
    public AdminModel changePassword(String token, AdminDTO adminDTO) {
        Long id= tokenutil.decodeToken(token);
        AdminModel adminModel=this.getAdmin(id);
        adminModel.setPassword(adminDTO.getPassword());
        iAdminRepository.save(adminModel);
        return adminModel;
    }

    @Override
    public AdminModel addProfile(String token, AdminDTO adminDTO) {
        Long id= tokenutil.decodeToken(token);
        AdminModel adminModel=this.getAdmin(id);
        adminModel.setProfilePath(adminDTO.getProfilePath());
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
        }
        return null;
    }
}
