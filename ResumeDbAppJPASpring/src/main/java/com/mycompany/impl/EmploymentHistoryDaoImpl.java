/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.impl;

import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import com.mycompany.inter.AbstractDAO;
import com.mycompany.inter.EmploymentHistoryDaoInter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.mycompany.inter.AbstractDAO.connect;

/**
 *
 * @author Acer
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    private EmploymentHistory getUserSkill(ResultSet rs) throws Exception {
        int userId = rs.getInt("user_id");
        String header = rs.getString("header");
        Date begin_date = rs.getDate("begin_date");
        Date end_date = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");

        return new EmploymentHistory(null, header, begin_date, end_date, jobDescription, new User(userId));
    }

    @Override
    public List<EmploymentHistory> getallEmploymentHistorybyuserId(int userId) {
        List<EmploymentHistory> ad = new ArrayList<>();
        try (Connection r = connect()) {

            PreparedStatement stmt = r.prepareStatement("select * from employment_history where user_id=?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                EmploymentHistory u = getUserSkill(rs);
                ad.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ad;
    }

}
