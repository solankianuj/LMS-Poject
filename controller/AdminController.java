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

    @GetMapping("/getAdmin/{id}")
    public AdminModel getAdmin(@PathVariable long id){
      return   adminServices.getAdmin(id);
    }

    @PutMapping("/updateAdmin")
    public AdminModel updateAdmin( @Valid @RequestParam long id,@RequestBody AdminDTO adminDTO){
        return adminServices.updateAdmin(id, adminDTO);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public AdminModel deleteAdmin(@PathVariable long id){
        return adminServices.deleteAdmin(id);
    }

    @GetMapping("/resetPassword")
    public String resetPassword(@RequestParam String emailId){
        return adminServices.resetPassword(emailId);
    }

    @PutMapping("/changePassword/{token}")
    public AdminModel changePassword(@PathVariable String token,@RequestBody AdminDTO adminDTO){
        return adminServices.changePassword(token,adminDTO);
    }

    @PutMapping("/addProfile/{token}")
    public AdminModel addProfile(@PathVariable String token,@RequestBody AdminDTO adminDTO){
        return adminServices.addProfile(token, adminDTO);
    }

    @GetMapping("/login")
    public Response login( @RequestParam String email,@RequestParam String password){
        return adminServices.login(email, password);
    }
}
