package com.company.impl;

import com.company.entity.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLoginRepository extends JpaRepository<AdminLogin,Integer>,AdminLoginRepositoryCustom {
}
