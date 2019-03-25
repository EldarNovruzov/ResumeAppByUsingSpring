/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.inter;

import com.mycompany.entity.EmploymentHistory;

import java.util.List;

/**
 *
 * @author Acer
 */
public interface EmploymentHistoryServiceInter {
    public List<EmploymentHistory> getallEmploymentHistorybyuserId(int userId);
}
