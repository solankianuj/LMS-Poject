package com.bridgelabz.lmsproject.repository;

import com.bridgelabz.lmsproject.model.TechStackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * purpose:creating candidate technology repository
 */
@Repository
public interface ITechStackRepository extends JpaRepository<TechStackModel,Long> {
}
