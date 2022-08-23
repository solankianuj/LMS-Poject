package com.bridgelabz.lmsproject.repository;

import com.bridgelabz.lmsproject.model.HiringCandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * purpose:creating hired candidate repository
 */
@Repository
public interface IHiringCandidateRepository extends JpaRepository<HiringCandidateModel,Long> {
}
