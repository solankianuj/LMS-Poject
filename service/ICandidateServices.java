package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;

import java.util.List;

public interface ICandidateServices {
    CandidateModel addCandidate(CandidateDTO candidateDTO);
    CandidateModel getCandidate(String token);
    CandidateModel updateCandidate(long id,CandidateDTO candidateDTO);
    CandidateModel deleteCandidate(long id);
    List<CandidateModel> getCandidateByStatus(String candidatestatus);
    CandidateModel changeCandidateStatus(String token, String candidatestatus);
    String countCandidateByStatus(String candidateStatus);
}
