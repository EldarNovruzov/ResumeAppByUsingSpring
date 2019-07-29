package com.company;

import com.company.ResumeDbAppJpaSpringApplication;
import com.company.entity.User;
import com.company.impl.UserRepositoryCustomImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class UserRepositoryCustomImplTestIT {

    @Autowired
    @Qualifier("userDao1")
    UserRepositoryCustomImpl repositoryCustom;

    @Before
    public void before(){

    }

    @Test
    public void test(){
        List<User> list=repositoryCustom.getAll(null,null,null);
        Assert.assertEquals("user size must be 3",3,list.size());
        System.out.println("list"+list);
    }
}
