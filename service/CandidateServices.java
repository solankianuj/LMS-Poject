package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.exception.AdminNotFound;
import com.bridgelabz.lmsproject.exception.CandidateNotFound;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.model.TechStackModel;
import com.bridgelabz.lmsproject.repository.IAdminRepository;
import com.bridgelabz.lmsproject.repository.ICandidateRepository;
import com.bridgelabz.lmsproject.repository.ITechStackRepository;
import com.bridgelabz.lmsproject.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *  Purpose:creating different candidate services
 * @author Anuj Solanki
 */
@Service
public class CandidateServices implements ICandidateServices{

    @Autowired
    ICandidateRepository candidateRepository;

    @Autowired
    IAdminRepository adminRepository;

    @Autowired
    ITechStackRepository techStackRepository;
    @Autowired
    Token tokenutil;

    /**
     *  Purpose:adding candidate
     * @param candidateDTO
     * @param techStackId
     * @return
     */
    @Override
    public CandidateModel addCandidate(CandidateDTO candidateDTO,List<Long> techStackId) {
       List<TechStackModel> techStackModelList=new ArrayList<>();
       techStackId.stream().forEach(techId->{
           Optional<TechStackModel> techStackModel=techStackRepository.findById(techId);
           if (techStackModel.isPresent()){
               techStackModelList.add(techStackModel.get());
           }
       });
        CandidateModel candidateModel=new CandidateModel(candidateDTO);
        if (techStackModelList.size()>0)
            candidateModel.setCreationTimeStamp(LocalDateTime.now());
        candidateModel.setTechStackModelList(techStackModelList);
        candidateRepository.save(candidateModel);
        return candidateModel;
    }

    /**
     *  Purpose:getting candidate details
     * @param token
     * @param candidateId
     * @return
     */
    @Override
    public CandidateModel getCandidate(String token,long candidateId) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            Optional<CandidateModel> candidateModel = candidateRepository.findById(candidateId);
            if (candidateModel.isPresent()) {
                return candidateModel.get();
            }
            throw new CandidateNotFound(200, "Candidate Not Found !");
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    /**
     *  Purpose:updating candidate details
     * @param token
     * @param candidateId
     * @param candidateDTO
     * @param techStackId
     * @return
     */
    @Override
    public CandidateModel updateCandidate(String token,long candidateId, CandidateDTO candidateDTO,List<Long> techStackId) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            Optional<CandidateModel> candidateModel = candidateRepository.findById(candidateId);
            if (candidateModel.isPresent()) {
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
                candidateModel.get().setUpdateTimeStamp(LocalDateTime.now());
                List<TechStackModel> techStackModelList=new ArrayList<>();
                techStackId.stream().forEach(techId->{
                    Optional<TechStackModel> techStackModel=techStackRepository.findById(techId);
                    if (techStackModel.isPresent()){
                        techStackModelList.add(techStackModel.get());
                    }
                });
                candidateModel.get().setTechStackModelList(techStackModelList);
                candidateRepository.save(candidateModel.get());
                return candidateModel.get();
            }
            throw new CandidateNotFound(200, "Candidate Not Found !");
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    /**
     *  Purpose:deleting candidate
     * @param token
     * @param candidateId
     * @return
     */
    @Override
    public CandidateModel deleteCandidate(String token,long candidateId) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            Optional<CandidateModel> candidateModel = candidateRepository.findById(candidateId);
            if (candidateModel.isPresent()){
            candidateRepository.delete(candidateModel.get());
            return candidateModel.get();}
            throw new CandidateNotFound(200,"Candidate Not Found !");
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }


    /**
     *  Purpose:getting candidate by status
     * @param token
     * @param candidateStatus
     * @return
     */
    @Override
    public List<CandidateModel> getCandidateByStatus(String token, String candidateStatus) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            List<CandidateModel> candidateModel = candidateRepository.findAll();
            return candidateModel.stream().filter(x -> x.getStatus().equals(candidateStatus)).collect(Collectors.toList());
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    /**
     *  Purpose:changing candidate status
     * @param token
     * @param candidateStatus
     * @param candidateId
     * @return
     */
    @Override
    public CandidateModel changeCandidateStatus(String token, String candidateStatus,long candidateId) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            CandidateModel candidateModel = this.getCandidate(token, candidateId);
            candidateModel.setCandidateStatus(candidateStatus);
            candidateRepository.save(candidateModel);
            return candidateModel;
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    /**
     *  Purpose:counting candidate by status
     * @param token
     * @param candidateStatus
     * @return
     */
    @Override
    public String countCandidateByStatus( String token, String candidateStatus) {
        Long id= tokenutil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            List<CandidateModel> candidateModel = this.getCandidateByStatus(token, candidateStatus);
            Long candidateCount = candidateModel.stream().count();
            return candidateStatus + "- " + candidateCount;
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }


}
