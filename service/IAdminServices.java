package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.AdminDTO;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.util.Response;

public interface IAdminServices {
    AdminModel addAdmin(AdminDTO adminDTO);
    AdminModel getAdmin(long id);
    AdminModel updateAdmin(long id,AdminDTO adminDTO);

    AdminModel deleteAdmin(long id);

    String resetPassword(String emailId);
    AdminModel changePassword(String token,AdminDTO adminDTO);
    AdminModel addProfile(String token,AdminDTO adminDTO);
    Response login(String emailId, String password);
}
