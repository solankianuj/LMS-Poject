package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.service.ICandidateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public CandidateModel getCandidate(@RequestParam String token){
        return candidateServices.getCandidate(token);
    }

    @GetMapping("/getCandidateByStatus")
    public List<CandidateModel> getCandidateByStatus(@RequestParam String candidateStatus){

        return candidateServices.getCandidateByStatus(candidateStatus);
    }

    @PutMapping("/changeCandidateStatus")
    public CandidateModel changeCandidateStatus(@RequestParam String token,@RequestParam String candidatestatus){
      return   candidateServices.changeCandidateStatus(token, candidatestatus);
    }

    @GetMapping("/getCandidateCountByStatus")
    public  String candidateCount(@RequestParam String candidateStatus){
        return candidateServices.countCandidateByStatus(candidateStatus);
    }


    @PutMapping("/updateCandidate")
    public CandidateModel updateCandidate(@RequestParam long id,@Valid @RequestBody CandidateDTO candidateDTO){
        return candidateServices.updateCandidate(id, candidateDTO);

    }

    @DeleteMapping("/deleteCandidate")
    public CandidateModel deleteCandidate(@RequestParam long id){
        return candidateServices.deleteCandidate(id);
    }
}
