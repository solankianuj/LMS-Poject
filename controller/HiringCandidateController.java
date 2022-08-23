package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.HiringCandidateDTO;
import com.bridgelabz.lmsproject.model.HiringCandidateModel;
import com.bridgelabz.lmsproject.service.IHiringCandidateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *  Purpose:Hired Candidate Operation Controller
 * @author Anuj Solanki
 */
@RestController
@RequestMapping("/hireCandidate")
public class HiringCandidateController {

    @Autowired
    IHiringCandidateServices hiringCandidateServices;

    /**
     *  Purpose:adding hired candidate
     * @param accountId
     * @param hiringCandidateDTO
     * @return
     */
    @PostMapping("/addHireCandidate")
    HiringCandidateModel addHiredCandidate(@RequestParam long accountId,@Valid @RequestBody HiringCandidateDTO hiringCandidateDTO){
        return hiringCandidateServices.addHiredCandidate(accountId,hiringCandidateDTO);
    }

    /**
     *  Purpose:getting hired candidate
     * @param token
     * @param candidateId
     * @return
     */
    @GetMapping("/getHiredCandidate")
    HiringCandidateModel getHiredCandidate(@RequestParam String token,@RequestParam long candidateId){
        return hiringCandidateServices.getHiredCandidate(token,candidateId);
    }

    /**
     *  Purpose:updating hired candidate details
     * @param token
     * @param candidateId
     * @param hiringCandidateDTO
     * @return
     */
    @PutMapping("/updateHiredCandidate")
    HiringCandidateModel updateHiredCandidate(@RequestParam String token,@RequestParam long candidateId, @Valid @RequestBody HiringCandidateDTO hiringCandidateDTO){
        return hiringCandidateServices.updateHireCandidate(token,candidateId,hiringCandidateDTO);
    }

    /**
     *  Purpose:deleting hired candidate
     * @param token
     * @param candidateId
     * @return
     */
    @DeleteMapping("/deleteHiredCandidate")
    HiringCandidateDTO deleteHiredCandidate(@RequestParam String token,@RequestParam long candidateId){
        return hiringCandidateServices.deleteHireCandidate(token,candidateId);
    }

    /**
     *  Purpose:listing total hired candidates
     * @param token
     * @return
     */
    @GetMapping("/getHireCandidateList")
    List<HiringCandidateModel> getCandidateList(String token){
        return hiringCandidateServices.getCandidateList(token);
    }
}
