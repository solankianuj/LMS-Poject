package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.HiringCandidateDTO;
import com.bridgelabz.lmsproject.exception.AdminNotFound;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.BankDetailsModel;
import com.bridgelabz.lmsproject.model.HiringCandidateModel;
import com.bridgelabz.lmsproject.repository.IAdminRepository;
import com.bridgelabz.lmsproject.repository.IBankDetailsRepository;
import com.bridgelabz.lmsproject.repository.IHiringCandidateRepository;
import com.bridgelabz.lmsproject.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *  Purpose:creating Hired Candidate different services
 * @author Anuj Solanki
 */
@Service
public class HiringCandidateServices implements IHiringCandidateServices{

    @Autowired
    IHiringCandidateRepository hiringCandidateRepository;
    @Autowired
    IAdminRepository adminRepository;
    @Autowired
    IBankDetailsRepository bankDetailsRepository;
    @Autowired
    Token tokenUtil;

    /**
     *  Purpose:adding hired candidate
     * @param accountId
     * @param hiringCandidateDTO
     * @return
     */
    @Override
    public HiringCandidateModel addHiredCandidate(long accountId,HiringCandidateDTO hiringCandidateDTO) {
        Optional<BankDetailsModel> bankDetailsModel=bankDetailsRepository.findById(accountId);
        HiringCandidateModel hiringCandidateModel=new HiringCandidateModel(hiringCandidateDTO);
        if (bankDetailsModel.isPresent()){
        hiringCandidateModel.setBankDetails(bankDetailsModel.get());
        }
        hiringCandidateModel.setCreationTimeStamp(LocalDateTime.now());
        hiringCandidateRepository.save(hiringCandidateModel);
        return hiringCandidateModel;
    }

    /**
     *  Purpose:getting hired candidate
     * @param token
     * @param candidateId
     * @return
     */
    @Override
    public HiringCandidateModel getHiredCandidate(String token, long candidateId) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()){
            Optional<HiringCandidateModel> hiringCandidateModel=hiringCandidateRepository.findById(candidateId);
            if (hiringCandidateModel.isPresent()){
                return hiringCandidateModel.get();
            }
            throw new AdminNotFound(200,"No Candidate Found !");
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }
    /**
     *  Purpose:updating hired candidate details
     * @param token
     * @param candidateId
     * @param hiringCandidateDTO
     * @return
     */
    @Override
    public HiringCandidateModel updateHireCandidate(String token, long candidateId, HiringCandidateDTO hiringCandidateDTO) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()){
            HiringCandidateModel hiringCandidateModel=this.getHiredCandidate(token,candidateId);
            hiringCandidateModel.setFullName(hiringCandidateDTO.getFullName());
            hiringCandidateModel.setCicId(hiringCandidateDTO.getCicId());
            hiringCandidateModel.setEmail(hiringCandidateDTO.getEmail());
            hiringCandidateModel.setMobileNo(hiringCandidateDTO.getMobileNo());
            hiringCandidateModel.setHireDate(hiringCandidateDTO.getHireDate());
            hiringCandidateModel.setDegree(hiringCandidateDTO.getDegree());
            hiringCandidateModel.setAggPer(hiringCandidateDTO.getAggPer());
            hiringCandidateModel.setCandidateStatus(hiringCandidateDTO.getCandidateStatus());
            hiringCandidateModel.setCity(hiringCandidateDTO.getCity());
            hiringCandidateModel.setState(hiringCandidateDTO.getState());
            hiringCandidateModel.setJobLocation(hiringCandidateDTO.getJobLocation());
            hiringCandidateModel.setStatus(hiringCandidateDTO.getStatus());
            hiringCandidateModel.setPassOutYear(hiringCandidateDTO.getPassOutYear());
            hiringCandidateRepository.save(hiringCandidateModel);
             return hiringCandidateModel;
        }

        throw new AdminNotFound(200,"Admin Not Found !");
    }

    /**
     *  Purpose:deleting hired candidate
     * @param token
     * @param candidateId
     * @return
     */

    @Override
    public HiringCandidateDTO deleteHireCandidate(String token, long candidateId) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()){
            HiringCandidateModel hiringCandidateModel=this.getHiredCandidate(token,candidateId);
            hiringCandidateRepository.delete(hiringCandidateModel);
        }
          throw new AdminNotFound(200,"Admin Not Found !");
    }
    /**
     *  Purpose:listing total hired candidates
     * @param token
     * @return
     */

    @Override
    public List<HiringCandidateModel> getCandidateList(String token) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            List<HiringCandidateModel> hiringCandidateModel = hiringCandidateRepository.findAll();
            return hiringCandidateModel;
        }
       throw new AdminNotFound(200,"Admin Not Found !");

    }
}
