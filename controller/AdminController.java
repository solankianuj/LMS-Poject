package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.AdminDTO;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.service.IAdminServices;
import com.bridgelabz.lmsproject.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAdminServices adminServices;

    @PostMapping("/addAdmin")
    public AdminModel addAdmin(@Valid @RequestBody AdminDTO  adminDTO){
        return adminServices.addAdmin(adminDTO);
    }

    @GetMapping("/getAdmin")
    public AdminModel getAdmin(@RequestHeader String token){
      return   adminServices.getAdmin(token);
    }

    @PutMapping("/updateAdmin")
    public AdminModel updateAdmin( @RequestHeader String token,@Valid @RequestBody AdminDTO adminDTO){
        return adminServices.updateAdmin(token, adminDTO);
    }

    @DeleteMapping("/deleteAdmin")
    public AdminModel deleteAdmin(@RequestHeader String token){
        return adminServices.deleteAdmin(token);
    }

    @GetMapping("/resetPassword")
    public String resetPassword( @RequestParam String emailId){
        return adminServices.resetPassword(emailId);
    }

    @PutMapping("/changePassword")
    public AdminModel changePassword( @RequestHeader String token,@RequestParam String newPwd){
        return adminServices.changePassword(token,newPwd);
    }

    @PutMapping("/addProfile")
    public AdminModel addProfile(@RequestHeader String token,@RequestParam String path){
        return adminServices.addProfile(token, path);
    }

    @GetMapping("/login")
    public Response login( @RequestParam String email,@RequestParam String password){
        return adminServices.login(email, password);
    }
}
