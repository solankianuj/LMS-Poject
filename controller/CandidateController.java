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
    public CandidateModel getCandidate(@RequestParam String token,@RequestParam long candidateId){
        return candidateServices.getCandidate(token,candidateId);
    }

    @GetMapping("/getCandidateByStatus")
    public List<CandidateModel> getCandidateByStatus(@RequestParam String token,@RequestParam String candidateStatus){

        return candidateServices.getCandidateByStatus(token,candidateStatus);
    }

    @PutMapping("/changeCandidateStatus")
    public CandidateModel changeCandidateStatus(@RequestParam String token,@RequestParam String candidatestatus,@RequestParam long candidateId){
      return   candidateServices.changeCandidateStatus(token, candidatestatus,candidateId);
    }

    @GetMapping("/getCandidateCount")
    public  String countCandidateByStatus (@RequestParam String token, @RequestParam String candidateStatus){
        return candidateServices.countCandidateByStatus(token,candidateStatus);
    }


    @PutMapping("/updateCandidate")
    public CandidateModel updateCandidate(@RequestParam String token ,@RequestParam long id,@Valid @RequestBody CandidateDTO candidateDTO){
        return candidateServices.updateCandidate(token,id, candidateDTO);

    }

    @DeleteMapping("/deleteCandidate")
    public CandidateModel deleteCandidate(@RequestParam String token,@RequestParam long candidateId){
        return candidateServices.deleteCandidate(token,candidateId);
    }
}
