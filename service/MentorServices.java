package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.MentorDTO;
import com.bridgelabz.lmsproject.exception.MentorNotFound;
import com.bridgelabz.lmsproject.model.MentorModel;
import com.bridgelabz.lmsproject.repository.IMentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentorServices implements IMentorServices{

    @Autowired
    IMentorRepository mentorRepository;

    @Override
    public MentorModel addMentor(MentorDTO mentorDTO) {
        MentorModel mentorModel=new MentorModel(mentorDTO);
        mentorRepository.save(mentorModel);
        return mentorModel;
    }

    @Override
    public MentorModel getMentor(long id) {
        Optional<MentorModel> mentorModel=mentorRepository.findById(id);
        if (mentorModel.isPresent()){
            return mentorModel.get();
        }
        throw new MentorNotFound(200,"Mentor Not Found !");
    }

    @Override
    public MentorModel updateMentor(long id, MentorDTO mentorDTO) {
        MentorModel mentorModel=this.getMentor(id);
        mentorModel.setEmployeeId(mentorDTO.getEmployeeId());
        mentorModel.setFirstName(mentorDTO.getFirstName());
        mentorModel.setLastName(mentorDTO.getLastName());
        mentorModel.setEmail(mentorDTO.getEmail());
        mentorModel.setMentorRole(mentorDTO.getMentorRole());
        mentorModel.setMentorDescription(mentorDTO.getMentorDescription());
        mentorModel.setMentorType(mentorDTO.getMentorType());
        mentorModel.setStatus(mentorDTO.getStatus());
        mentorModel.setCreatorUser(mentorDTO.getCreatorUser());
        mentorModel.setExperienceYears(mentorDTO.getExperienceYears());
        mentorModel.setMobileNumber(mentorDTO.getMobileNumber());
        mentorModel.setPreferredTime(mentorDTO.getPreferredTime());
        mentorModel.setProfileImageUrl(mentorDTO.getProfileImageUrl());
        mentorModel.setStartDate(mentorDTO.getStartDate());
        mentorModel.setSupervisorId(mentorDTO.getSupervisorId());
        mentorModel.setUpdateTimeStamp(LocalDateTime.now());
        mentorRepository.save(mentorModel);
        return mentorModel;
    }

    @Override
    public MentorModel deleteMentor(long id) {
        MentorModel mentorModel=this.getMentor(id);
        mentorRepository.delete(mentorModel);
        return mentorModel;
    }

    @Override
    public String getMentorByRole(String mentorRole) {
        List<MentorModel> mentorModels=mentorRepository.findAll();
        List<MentorModel> newList= mentorModels.stream().filter(x->x.getMentorRole().equals(mentorRole)).collect(Collectors.toList());
        Integer count= newList.size();
        return mentorRole+" - "+count;
    }

    @Override
    public MentorModel getMentorByMentorId(String mentorId) {
        Optional<MentorModel> mentorModel=mentorRepository.findByEmployeeId(mentorId);
        if (mentorModel.isPresent()){
            return mentorModel.get();
        }
        throw new MentorNotFound(200,"Mentor Not Found !");
    }

    @Override
    public String mentorsCount() {
        List<MentorModel> mentorModel=mentorRepository.findAll();
        Integer count = mentorModel.size();
        return "Total Mentor is :"+count;
    }
}
