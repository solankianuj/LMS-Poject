package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.MentorDTO;
import com.bridgelabz.lmsproject.model.MentorModel;

import java.util.List;

public interface IMentorServices {
    MentorModel addMentor(MentorDTO mentorDTO);
    MentorModel getMentor(long id);
    MentorModel updateMentor(long id,MentorDTO mentorDTO);

    MentorModel deleteMentor(long id);

   String getMentorByRole(String metorRole);

    MentorModel getMentorByMentorId(String mentorId);

    String mentorsCount();
}
