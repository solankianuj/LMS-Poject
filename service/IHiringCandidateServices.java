package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.HiringCandidateDTO;
import com.bridgelabz.lmsproject.model.HiringCandidateModel;

import java.util.List;

public interface IHiringCandidateServices {
    HiringCandidateModel addHiredCandidate(long accountId,HiringCandidateDTO hiringCandidateDTO);

    HiringCandidateModel getHiredCandidate(String token, long candidateId);

    HiringCandidateModel updateHireCandidate(String token,long candidateId, HiringCandidateDTO hiringCandidateDTO);

    HiringCandidateDTO deleteHireCandidate(String token, long candidateId);

    List<HiringCandidateModel> getCandidateList(String token);
}
