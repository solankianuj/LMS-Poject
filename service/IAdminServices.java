package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.AdminDTO;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.util.Response;

public interface IAdminServices {
    AdminModel addAdmin(AdminDTO adminDTO);
    AdminModel getAdmin(String token);
    AdminModel updateAdmin(String token,AdminDTO adminDTO);

    AdminModel deleteAdmin(String token);

    String resetPassword(String emailId );
    AdminModel changePassword(String token,String newPwd);
    AdminModel addProfile(String token,String path);
    Response login(String emailId, String password);
}
