package com.mycompany.service.impl;

import com.mycompany.entity.AdminLogin;
import com.mycompany.impl.AdminLoginRepositoryCustom;
import com.mycompany.service.inter.AdminLoginServiceInter;
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
