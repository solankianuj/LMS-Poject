package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.TechStackDTO;
import com.bridgelabz.lmsproject.model.TechStackModel;
import com.bridgelabz.lmsproject.service.ITechStackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/techStack")
public class TechStackController {

    @Autowired
    ITechStackServices techStackServices;

    @PostMapping("/addTechStack")
    public TechStackModel addTechStack(@RequestParam String token,@RequestBody TechStackDTO techStackDTO){
        return techStackServices.addTechStack(token,techStackDTO);
    }

    @GetMapping("/getTechStack")
    public TechStackModel getTechStack(@RequestParam String token,@RequestParam long techStackId){
        return techStackServices.getTechStack(token,techStackId);
    }

    @PutMapping("/updateTechStack")
    public TechStackModel updateTechStack(@RequestParam String token,@RequestParam long techStackId,@RequestBody TechStackDTO techStackDTO){
        return techStackServices.updateTechStack(token,techStackId,techStackDTO);
    }

    @DeleteMapping("/deleteTechStack")
    public TechStackModel deleteTechStack(@RequestParam String token,@RequestParam long techStackId){
        return techStackServices.deleteTechStack(token,techStackId);
    }
}
