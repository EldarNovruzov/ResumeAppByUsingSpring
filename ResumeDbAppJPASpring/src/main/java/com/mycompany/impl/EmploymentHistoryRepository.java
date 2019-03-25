package com.mycompany.impl;

import com.mycompany.entity.EmploymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistory,Integer>,EmploymentHistoryRepositoryCustom {
}
