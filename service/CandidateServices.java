package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.exception.CandidateNotFound;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.repository.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateServices implements ICandidateServices{

    @Autowired
    ICandidateRepository candidateRepository;

    @Override
    public CandidateModel addCandidate(CandidateDTO candidateDTO) {
        CandidateModel candidateModel=new CandidateModel(candidateDTO);
        candidateRepository.save(candidateModel);
        return candidateModel;
    }

    @Override
    public CandidateModel getCandidate(long id) {
        Optional<CandidateModel> candidateModel=candidateRepository.findById(id);
        if (candidateModel.isPresent()){
            return candidateModel.get();
        }
      throw new CandidateNotFound(200,"Candidate Not Found !");
    }

    @Override
    public CandidateModel updateCandidate(long id, CandidateDTO candidateDTO) {
        Optional<CandidateModel> candidateModel=candidateRepository.findById(id);
        if (candidateModel.isPresent()){
            candidateModel.get().setFullName(candidateDTO.getFullName());
            candidateModel.get().setCicId(candidateDTO.getCicId());
            candidateModel.get().setEmail(candidateDTO.getEmail());
            candidateModel.get().setMobileNo(candidateDTO.getMobileNo());
            candidateModel.get().setHireDate(candidateDTO.getHireDate());
            candidateModel.get().setDegree(candidateDTO.getDegree());
            candidateModel.get().setAggPer(candidateDTO.getAggPer());
            candidateModel.get().setCandidateStatus(candidateDTO.getCandidateStatus());
            candidateModel.get().setCity(candidateDTO.getCity());
            candidateModel.get().setState(candidateDTO.getState());
            candidateModel.get().setPreferredJobLocation(candidateDTO.getPreferredJobLocation());
            candidateModel.get().setStatus(candidateDTO.getStatus());
            candidateModel.get().setPassOutYear(candidateDTO.getPassOutYear());
            candidateRepository.save(candidateModel.get());
            return candidateModel.get();
        }
        throw new CandidateNotFound(200,"Candidate Not Found !");
    }

    @Override
    public CandidateModel deleteCandidate(long id) {
        Optional<CandidateModel> candidateModel=candidateRepository.findById(id);
            candidateRepository.delete(candidateModel.get());
        return candidateModel.get();
    }

    @Override
    public List<CandidateModel> getCandidateByStatus(String candidatestatus) {
        List<CandidateModel> candidateModel=candidateRepository.findAll() ;
           return candidateModel.stream().filter(x->x.getCandidateStatus().equals(candidatestatus)).collect(Collectors.toList());

    }

    @Override
    public CandidateModel changeCandidateStatus(long id, String candidatestatus) {
        CandidateModel candidateModel=this.getCandidate(id);
        candidateModel.setCandidateStatus(candidatestatus);
        candidateRepository.save(candidateModel);
        return candidateModel;
    }

    @Override
    public String countCandidateByStatus(String candidateStatus) {
        List<CandidateModel> candidateModel=this.getCandidateByStatus(candidateStatus);
        Long candidateCount=candidateModel.stream().count();
        return candidateStatus+"- "+ candidateCount;
    }

}
