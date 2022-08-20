package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.dto.AdminDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "AdminData")
@Data
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String emailId;
    private String password;
    private String profilePath;
    private String status;
    private LocalDateTime creatorStamp =LocalDateTime.now();
    private LocalDateTime updatedStamp;

    public AdminModel(AdminDTO adminDTO) {
        this.firstName=adminDTO.getFirstName();
        this.lastName=adminDTO.getLastName();
        this.mobileNo=adminDTO.getMobileNo();
        this.emailId=adminDTO.getEmailId();
        this.profilePath=adminDTO.getProfilePath();
        this.status=adminDTO.getStatus();
        this.password= adminDTO.getPassword();
    }

    public AdminModel() {

    }
}
