package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.MentorDTO;
import com.bridgelabz.lmsproject.model.MentorModel;
import com.bridgelabz.lmsproject.service.IMentorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    IMentorServices mentorServices;

    @PostMapping("/addMentor")
    public MentorModel addMentor(@Valid @RequestBody MentorDTO mentorDTO){
        return mentorServices.addMentor(mentorDTO);
    }

    @GetMapping("/getMentor")
    public MentorModel getMentor(@RequestParam String token,@RequestParam long id){
       return mentorServices.getMentor(token,id);
    }

    @PutMapping("/updateMentor")
    public MentorModel updateMentor(@RequestParam String token, @RequestParam long id, @Valid @RequestBody MentorDTO mentorDTO){
        return mentorServices.updateMentor(token,id, mentorDTO);
    }

    @DeleteMapping("/deleteMentor")
    public MentorModel deleteMentor(@RequestParam String token, @RequestParam long mentorId){
        return mentorServices.deleteMentor(token,mentorId);
    }

    @GetMapping("/getMentorByRole")
    public String mentorByRole(@RequestParam String token, @RequestParam String mentorRole){
        return mentorServices.getMentorByRole(token,mentorRole);
    }

    @GetMapping("/getMentorByMentorId")
    public MentorModel byMentorId(@RequestParam String token,@RequestParam String mentorId){
        return mentorServices.getMentorByMentorId(token,mentorId);
    }

    @GetMapping("/getMentorCount")
    public String getTotalMentor(@RequestParam String token){
        return mentorServices.mentorsCount(token);
    }
}
