package com.mycompany.service.impl;

import com.mycompany.entity.EmploymentHistory;
import com.mycompany.impl.EmploymentHistoryRepositoryCustom;
import com.mycompany.service.inter.EmploymentHistoryServiceInter;
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
