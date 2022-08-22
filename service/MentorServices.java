package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.MentorDTO;
import com.bridgelabz.lmsproject.exception.AdminNotFound;
import com.bridgelabz.lmsproject.exception.MentorNotFound;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.MentorModel;
import com.bridgelabz.lmsproject.repository.IAdminRepository;
import com.bridgelabz.lmsproject.repository.IMentorRepository;
import com.bridgelabz.lmsproject.util.Token;
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
    @Autowired
    Token tokenutil;
    @Autowired
    IAdminRepository adminRepository;

    @Override
    public MentorModel addMentor(MentorDTO mentorDTO) {
        MentorModel mentorModel=new MentorModel(mentorDTO);
        mentorModel.setCreatedTimeStamp(LocalDateTime.now());
        mentorRepository.save(mentorModel);
        return mentorModel;
    }

    @Override
    public MentorModel getMentor(String token, long mentorId) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            Optional<MentorModel> mentorModel = mentorRepository.findById(mentorId);
            if (mentorModel.isPresent()) {
                return mentorModel.get();
            }
            throw new MentorNotFound(200, "Mentor Not Found !");
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    @Override
    public MentorModel updateMentor(String token, long mentorId, MentorDTO mentorDTO) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            MentorModel mentorModel = this.getMentor(token, mentorId);
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
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    @Override
    public MentorModel deleteMentor(String token, long mentorId) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if ( adminModel.isPresent() ) {
            MentorModel mentorModel = this.getMentor(token, mentorId);
            mentorRepository.delete(mentorModel);
            return mentorModel;
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    @Override
    public String getMentorByRole(String token, String mentorRole) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            List<MentorModel> mentorModels = mentorRepository.findAll();
            List<MentorModel> newList = mentorModels.stream().filter(x -> x.getMentorRole().equals(mentorRole)).collect(Collectors.toList());
            Integer count = newList.size();
            return mentorRole + " - " + count;
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    @Override
    public MentorModel getMentorByMentorId(String token, String mentorId) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            Optional<MentorModel> mentorModel = mentorRepository.findByEmployeeId(mentorId);
            if (mentorModel.isPresent()) {
                return mentorModel.get();
            }
            throw new MentorNotFound(200, "Mentor Not Found !");
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    @Override
    public String mentorsCount(String token) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            List<MentorModel> mentorModel = mentorRepository.findAll();
            Integer count = mentorModel.size();
            return "Total Mentor is :" + count;
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }
}
