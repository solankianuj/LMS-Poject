package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;

import java.util.List;

public interface ICandidateServices {
    CandidateModel addCandidate(CandidateDTO candidateDTO);
    CandidateModel getCandidate(long id);
    CandidateModel updateCandidate(long id,CandidateDTO candidateDTO);
    CandidateModel deleteCandidate(long id);
    List<CandidateModel> getCandidateByStatus(String candidatestatus);
    CandidateModel changeCandidateStatus(long id, CandidateDTO candidateDTO);
    String countCandidateByStatus(String candidateStatus);
}
