package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.HiringCandidateDTO;
import com.bridgelabz.lmsproject.model.HiringCandidateModel;
import com.bridgelabz.lmsproject.service.IHiringCandidateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hireCandidate")
public class HiringCandidateController {

    @Autowired
    IHiringCandidateServices hiringCandidateServices;

    @PostMapping("/addHireCandidate")
    HiringCandidateModel addHiredCandidate(@RequestParam long accountId,@RequestBody HiringCandidateDTO hiringCandidateDTO){
        return hiringCandidateServices.addHiredCandidate(accountId,hiringCandidateDTO);
    }
    @GetMapping("/getHiredCandidate")
    HiringCandidateModel getHiredCandidate(@RequestParam String token,@RequestParam long candidateId){
        return hiringCandidateServices.getHiredCandidate(token,candidateId);
    }
    @PutMapping("/updateHiredCandidate")
    HiringCandidateModel updateHiredCandidate(@RequestParam String token,@RequestParam long candidateId, @Valid @RequestBody HiringCandidateDTO hiringCandidateDTO){
        return hiringCandidateServices.updateHireCandidate(token,candidateId,hiringCandidateDTO);
    }
    @DeleteMapping("/deleteHiredCandidate")
    HiringCandidateDTO deleteHiredCandidate(@RequestParam String token,@RequestParam long candidateId){
        return hiringCandidateServices.deleteHireCandidate(token,candidateId);
    }

    @GetMapping("/getHireCandidateList")
    List<HiringCandidateModel> getCandidateList(String token){
        return hiringCandidateServices.getCandidateList(token);
    }
}
