package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.MentorDTO;
import com.bridgelabz.lmsproject.model.MentorModel;
import com.bridgelabz.lmsproject.service.IMentorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *  Purpose:Mentors Operation Controller
 * @author Anuj Solanki
 */

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    IMentorServices mentorServices;

    /**
     *  Purpose:adding mentors
     * @param mentorDTO
     * @return
     */
    @PostMapping("/addMentor")
    public MentorModel addMentor(@Valid @RequestBody MentorDTO mentorDTO){
        return mentorServices.addMentor(mentorDTO);
    }

    /**
     *  Purpose:getting mentor
     * @param token
     * @param mentorId
     * @return
     */
    @GetMapping("/getMentor")
    public MentorModel getMentor(@RequestParam String token,@RequestParam long mentorId){
       return mentorServices.getMentor(token,mentorId);
    }

    /**
     *  Purpose:updating mentors details
     * @param token
     * @param mentorId
     * @param mentorDTO
     * @return
     */
    @PutMapping("/updateMentor")
    public MentorModel updateMentor(@RequestParam String token, @RequestParam long mentorId, @Valid @RequestBody MentorDTO mentorDTO){
        return mentorServices.updateMentor(token,mentorId, mentorDTO);
    }

    /**
     *  Purpose:deleting mentor
     * @param token
     * @param mentorId
     * @return
     */

    @DeleteMapping("/deleteMentor")
    public MentorModel deleteMentor(@RequestParam String token, @RequestParam long mentorId){
        return mentorServices.deleteMentor(token,mentorId);
    }

    /**
     *  Purpose:getting mentor by role
     * @param token
     * @param mentorRole
     * @return
     */
    @GetMapping("/getMentorByRole")
    public String mentorByRole(@RequestParam String token, @RequestParam String mentorRole){
        return mentorServices.getMentorByRole(token,mentorRole);
    }

    /**
     *  Purpose:getting mentor by mentorId
     * @param token
     * @param mentorId
     * @return
     */
    @GetMapping("/getMentorByMentorId")
    public MentorModel byMentorId(@RequestParam String token,@RequestParam String mentorId){
        return mentorServices.getMentorByMentorId(token,mentorId);
    }

    /**
     *  Purpose:counting total mentors
     * @param token
     * @return
     */
    @GetMapping("/getMentorCount")
    public String getTotalMentor(@RequestParam String token){
        return mentorServices.mentorsCount(token);
    }
}
