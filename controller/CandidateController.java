package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.service.ICandidateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    ICandidateServices candidateServices;

    @PostMapping("/addCandidate")
    public CandidateModel addCandidate( @Valid @RequestBody  CandidateDTO candidateDTO){
       return candidateServices.addCandidate(candidateDTO);
    }

    @GetMapping("/getCandidate")
    public CandidateModel getCandidate(@RequestParam long id){
        return candidateServices.getCandidate(id);
    }

    @GetMapping("/getCandidateByStatus")
    public List<CandidateModel> getCandidate(@RequestParam String candidateStatus){

        return candidateServices.getCandidateByStatus(candidateStatus);
    }

    @PutMapping("/changeCandidateStatus")
    public CandidateModel changeCandidateStatus(@RequestParam long id,@RequestBody CandidateDTO candidateDTO){
      return   candidateServices.changeCandidateStatus(id, candidateDTO);
    }

    @GetMapping("/getCandidateCountByStatus")
    public  String candidateCount(@RequestParam String candidateStatus){
        return candidateServices.countCandidateByStatus(candidateStatus);
    }


    @PutMapping("/updateCandidate")
    public CandidateModel updateCandidate(@RequestParam long id, @RequestBody CandidateDTO candidateDTO){
        return candidateServices.updateCandidate(id, candidateDTO);

    }

    @DeleteMapping("/deleteCandidate")
    public CandidateModel deleteCandidate(@RequestParam long id){
        return candidateServices.deleteCandidate(id);
    }
}
