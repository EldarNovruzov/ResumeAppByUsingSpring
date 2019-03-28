package com.company.service.impl;

import com.company.entity.EmploymentHistory;
import com.company.impl.EmploymentHistoryRepositoryCustom;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {

    @Qualifier("employmentHistoryRepositoryCustomImpl")
    @Autowired
    private EmploymentHistoryRepositoryCustom ehr;

    @Override
    public List<EmploymentHistory> getallEmploymentHistorybyuserId(int userId) {
        return ehr.getallEmploymentHistorybyuserId(userId);
    }
}
