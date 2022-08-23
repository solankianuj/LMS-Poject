package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.TechStackDTO;
import com.bridgelabz.lmsproject.model.TechStackModel;
import com.bridgelabz.lmsproject.service.ITechStackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *  Purpose:candidate technology allocation
 * @author Anuj Solanki
 */
@RestController
@RequestMapping("/techStack")
public class TechStackController {

    @Autowired
    ITechStackServices techStackServices;

    /**
     *  Purpose:adding technology
     * @param token
     * @param techStackDTO
     * @return
     */
    @PostMapping("/addTechStack")
    public TechStackModel addTechStack(@RequestParam String token,@Valid @RequestBody TechStackDTO techStackDTO){
        return techStackServices.addTechStack(token,techStackDTO);
    }

    /**
     *  Purpose:getting technology
     * @param token
     * @param techStackId
     * @return
     */
    @GetMapping("/getTechStack")
    public TechStackModel getTechStack(@RequestParam String token,@RequestParam long techStackId){
        return techStackServices.getTechStack(token,techStackId);
    }

    /**
     *  Purpose:updating technology
     * @param token
     * @param techStackId
     * @param techStackDTO
     * @return
     */
    @PutMapping("/updateTechStack")
    public TechStackModel updateTechStack(@RequestParam String token,@RequestParam long techStackId,@Valid @RequestBody TechStackDTO techStackDTO){
        return techStackServices.updateTechStack(token,techStackId,techStackDTO);
    }

    /**
     *  Purpose:deleting technology
     * @param token
     * @param techStackId
     * @return
     */
    @DeleteMapping("/deleteTechStack")
    public TechStackModel deleteTechStack(@RequestParam String token,@RequestParam long techStackId){
        return techStackServices.deleteTechStack(token,techStackId);
    }
}
