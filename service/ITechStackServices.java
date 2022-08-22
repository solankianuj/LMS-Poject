package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.TechStackDTO;
import com.bridgelabz.lmsproject.model.TechStackModel;

public interface ITechStackServices {

    TechStackModel addTechStack(String token,TechStackDTO techStackDTO);

    TechStackModel getTechStack(String token, long techStackId);

    TechStackModel updateTechStack(String token, long techStackId, TechStackDTO techStackDTO);

    TechStackModel deleteTechStack(String token, long techStackId);
}
