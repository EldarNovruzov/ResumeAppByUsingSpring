package com.mycompany.impl;

import com.mycompany.entity.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLoginRepository extends JpaRepository<AdminLogin,Integer>,AdminLoginRepositoryCustom {
}
