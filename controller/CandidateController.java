package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.service.ICandidateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 *  Purpose:candidate operation controller
 * @author Anuj Solanki
 */

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    ICandidateServices candidateServices;

    /**
     *  Purpose:adding candidate
     * @param candidateDTO
     * @param techStackId
     * @return
     */
    @PostMapping("/addCandidate")
    public CandidateModel addCandidate( @Valid @RequestBody  CandidateDTO candidateDTO,@RequestParam List<Long> techStackId){
       return candidateServices.addCandidate(candidateDTO,techStackId);
    }

    /**
     *  Purpose:getting candidate details
     * @param token
     * @param candidateId
     * @return
     */
    @GetMapping("/getCandidate")
    public CandidateModel getCandidate(@RequestParam String token,@RequestParam long candidateId){
        return candidateServices.getCandidate(token,candidateId);
    }

    /**
     *  Purpose:getting candidate by status
     * @param token
     * @param candidateStatus
     * @return
     */
    @GetMapping("/getCandidateByStatus")
    public List<CandidateModel> getCandidateByStatus(@RequestParam String token,@RequestParam String candidateStatus){

        return candidateServices.getCandidateByStatus(token,candidateStatus);
    }

    /**
     *  Purpose:changing candidate status
     * @param token
     * @param candidateStatus
     * @param candidateId
     * @return
     */
    @PutMapping("/changeCandidateStatus")
    public CandidateModel changeCandidateStatus(@RequestParam String token,@RequestParam String candidateStatus,@RequestParam long candidateId){
      return   candidateServices.changeCandidateStatus(token, candidateStatus,candidateId);
    }

    /**
     *  Purpose:counting candidate by status
     * @param token
     * @param candidateStatus
     * @return
     */
    @GetMapping("/getCandidateCount")
    public  String countCandidateByStatus (@RequestParam String token, @RequestParam String candidateStatus){
        return candidateServices.countCandidateByStatus(token,candidateStatus);
    }

    /**
     *  Purpose:updating candidate details
     * @param token
     * @param id
     * @param candidateDTO
     * @param techStackId
     * @return
     */

    @PutMapping("/updateCandidate")
    public CandidateModel updateCandidate(@RequestParam String token ,@RequestParam long id,@Valid @RequestBody CandidateDTO candidateDTO,@RequestParam List<Long> techStackId){
        return candidateServices.updateCandidate(token,id, candidateDTO,techStackId);

    }

    /**
     *  Purpose:deleting candidate
     * @param token
     * @param candidateId
     * @return
     */
    @DeleteMapping("/deleteCandidate")
    public CandidateModel deleteCandidate(@RequestParam String token,@RequestParam long candidateId){
        return candidateServices.deleteCandidate(token,candidateId);
    }
}
