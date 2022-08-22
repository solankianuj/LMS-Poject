package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.dto.BankDetailsDTO;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bankDetails")
@Data
public class BankDetailsModel {
    @Id
    @GenericGenerator(name = "bankDetails",strategy = "increment")
    @GeneratedValue(generator = "bankDetails")
    private Long id;
    private String accountNumber;
    private String ifscCode;
    private String branch;
    private String linkedMobileNumber;
    private String accountHolderName;
    @OneToOne
    AdminModel creatorUser;
    @OneToOne
    AdminModel updatedUser;
    private LocalDateTime creatorDateTime;
    private LocalDateTime updatedDateTime;

    public BankDetailsModel(BankDetailsDTO bankDetailsDTO) {
        this.accountHolderName= bankDetailsDTO.getAccountHolderName();
        this.accountNumber= bankDetailsDTO.getAccountNumber();
        this.ifscCode= bankDetailsDTO.getIfscCode();
        this.branch= bankDetailsDTO.getBranch();
        this.linkedMobileNumber= bankDetailsDTO.getLinkedMobileNumber();
    }

    public BankDetailsModel() {

    }
}
