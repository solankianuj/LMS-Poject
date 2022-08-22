package com.bridgelabz.lmsproject.model;


import com.bridgelabz.lmsproject.dto.TechStackDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "techStackData")
@Data
public class TechStackModel {
    @Id
    @GenericGenerator(name = "techStackData",strategy = "increment")
    @GeneratedValue(generator = "techStackData")
    @Column(name = "techStackId")
    private long id;
    @OneToOne
    private AdminModel creatorUser;
    private String imagePath;
    private boolean status;
    private String techName;
    @JsonIgnore
    private LocalDateTime creatorTime;

    public TechStackModel(TechStackDTO techStackDTO) {
        this.techName=techStackDTO.getTechName();
        this.imagePath=techStackDTO.getImagePath();
        this.status=techStackDTO.isStatus();
    }

    public TechStackModel() {

    }
}
