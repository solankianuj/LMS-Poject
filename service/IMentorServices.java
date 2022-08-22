package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.MentorDTO;
import com.bridgelabz.lmsproject.model.MentorModel;

public interface IMentorServices {
    MentorModel addMentor(MentorDTO mentorDTO);
    MentorModel getMentor(String token, long id);
    MentorModel updateMentor(String token, long id, MentorDTO mentorDTO);

    MentorModel deleteMentor(String token, long id);

   String getMentorByRole(String token, String metorRole);

    MentorModel getMentorByMentorId(String token, String mentorId);

    String mentorsCount(String token);
}
