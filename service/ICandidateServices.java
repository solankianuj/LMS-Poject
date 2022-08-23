package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;

import java.util.List;

public interface ICandidateServices {
    CandidateModel addCandidate(CandidateDTO candidateDTO,List<Long> techStackId);
    CandidateModel getCandidate(String token,long candidateId);
    CandidateModel updateCandidate(String token,long id,CandidateDTO candidateDTO,List<Long> techStackId);
    CandidateModel deleteCandidate(String token,long candidateId);
    List<CandidateModel> getCandidateByStatus(String token, String candidateStatus);
    CandidateModel changeCandidateStatus(String token, String candidateStatus,long candidateId);
    String countCandidateByStatus(String token, String candidateStatus);
}
