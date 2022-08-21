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
    public MentorModel getMentor(@RequestParam long id){
       return mentorServices.getMentor(id);
    }

    @PutMapping("/updateMentor")
    public MentorModel updateMentor( @RequestParam long id, @Valid @RequestBody MentorDTO mentorDTO){
        return mentorServices.updateMentor(id, mentorDTO);
    }

    @DeleteMapping("/deleteMentor")
    public MentorModel deleteMentor(@RequestParam long id){
        return mentorServices.deleteMentor(id);
    }

    @GetMapping("/getMentorByRole")
    public String mentorByRole(@RequestParam String mentorRole){
        return mentorServices.getMentorByRole(mentorRole);
    }

    @GetMapping("/getMentorByMentorId")
    public MentorModel byMentorId(@RequestParam String mentorId){
        return mentorServices.getMentorByMentorId(mentorId);
    }

    @GetMapping("/getMentorCount")
    public String getTotalMentor(){
        return mentorServices.mentorsCount();
    }
}
