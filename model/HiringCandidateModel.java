package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.dto.HiringCandidateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hiringCandidateData")
@Data

public class HiringCandidateModel {
    @Id
    @GenericGenerator(name = "hiringCandidateData",strategy = "increment")
    @GeneratedValue(generator = "hiringCandidateData")
    private Long id;
    private String cicId;
    private String fullName;
    private String email;
    private String mobileNo;
    private String hireDate;
    private String degree;
    private Double aggPer;
    private String city;
    private String state;
    private String jobLocation;
    private String status;
    private String passOutYear;
    @OneToOne
    private BankDetailsModel bankDetails;
    private String creatorUser;
    private String candidateStatus;
    @CreationTimestamp
    private LocalDateTime creationTimeStamp;
    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;


    public HiringCandidateModel(HiringCandidateDTO hiringCandidateDTO) {
        this.fullName=hiringCandidateDTO.getFullName();
        this.cicId=hiringCandidateDTO.getCicId();
        this.email=hiringCandidateDTO.getEmail();
        this.mobileNo=hiringCandidateDTO.getMobileNo();
        this.hireDate=hiringCandidateDTO.getHireDate();
        this.degree=hiringCandidateDTO.getDegree();
        this.aggPer=hiringCandidateDTO.getAggPer();
        this.city=hiringCandidateDTO.getCity();
        this.state=hiringCandidateDTO.getState();
        this.jobLocation=hiringCandidateDTO.getJobLocation();
        this.status=hiringCandidateDTO.getStatus();
        this.passOutYear=hiringCandidateDTO.getPassOutYear();
        this.creatorUser=hiringCandidateDTO.getCreatorUser();
        this.candidateStatus=hiringCandidateDTO.getCandidateStatus();
    }

    public HiringCandidateModel() {

    }
}

