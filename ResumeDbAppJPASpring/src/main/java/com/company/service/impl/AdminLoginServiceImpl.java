package com.company.service.impl;

import com.company.entity.AdminLogin;
import com.company.impl.AdminLoginRepositoryCustom;
import com.company.service.inter.AdminLoginServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminLoginServiceImpl implements AdminLoginServiceInter {

    @Qualifier("adminLoginRepositoryCustomImpl")
    @Autowired
    private AdminLoginRepositoryCustom alrc;

    @Override
    public List<AdminLogin> getAll() {
        return alrc.getAll();
    }
}
