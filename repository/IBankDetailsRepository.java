package com.bridgelabz.lmsproject.repository;

import com.bridgelabz.lmsproject.model.BankDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankDetailsRepository extends JpaRepository<BankDetailsModel,Long> {
}
