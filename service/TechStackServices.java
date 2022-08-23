package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.TechStackDTO;
import com.bridgelabz.lmsproject.exception.AdminNotFound;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.TechStackModel;
import com.bridgelabz.lmsproject.repository.IAdminRepository;
import com.bridgelabz.lmsproject.repository.ITechStackRepository;
import com.bridgelabz.lmsproject.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 *  Purpose:creating different candidate technology services
 * @author Anuj Solanki
 */
@Service
public class TechStackServices implements ITechStackServices{

    @Autowired
    ITechStackRepository techStackRepository;
    @Autowired
    IAdminRepository adminRepository;
    @Autowired
    Token tokenUtil;

    /**
     *  Purpose:adding technology
     * @param token
     * @param techStackDTO
     * @return
     */
    @Override
    public TechStackModel addTechStack(String token,TechStackDTO techStackDTO) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()) {
            TechStackModel techStackModel = new TechStackModel(techStackDTO);
            techStackModel.setCreatorTime(LocalDateTime.now());
            techStackModel.setCreatorUser(adminModel.get());
            techStackRepository.save(techStackModel);
            return techStackModel;
        }
        throw new AdminNotFound(200,"Admin Not Found !");
    }

    /**
     *  Purpose:getting technology
     * @param token
     * @param techStackId
     * @return
     */
    @Override
    public TechStackModel getTechStack(String token, long techStackId) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()){
            Optional<TechStackModel> techStackModel=techStackRepository.findById(techStackId);
            if (techStackModel.isPresent()){
                return techStackModel.get();
            }
            throw new AdminNotFound(200,"TechStack Not Available");
        }

        throw new AdminNotFound(200,"Admin Not Found !");
    }

    /**
     *  Purpose:updating technology
     * @param token
     * @param techStackId
     * @param techStackDTO
     * @return
     */
    @Override
    public TechStackModel updateTechStack(String token, long techStackId, TechStackDTO techStackDTO) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()){
            TechStackModel techStackModel=this.getTechStack(token,techStackId);
            techStackModel.setTechName(techStackDTO.getTechName());
            techStackModel.setImagePath(techStackDTO.getImagePath());
            techStackModel.setStatus(techStackDTO.isStatus());
            techStackRepository.save(techStackModel);
            return techStackModel;
        }

        throw new AdminNotFound(200,"Admin Not Found !");
    }

    /**
     *  Purpose:deleting technology
     * @param token
     * @param techStackId
     * @return
     */
    @Override
    public TechStackModel deleteTechStack(String token, long techStackId) {
        Long id= tokenUtil.decodeToken(token);
        Optional<AdminModel> adminModel=adminRepository.findById(id);
        if (adminModel.isPresent()){
            TechStackModel techStackModel=this.getTechStack(token,techStackId);
            techStackRepository.delete(techStackModel);
            return techStackModel;
        }

        throw new AdminNotFound(200,"Admin Not Found !");
    }
}
