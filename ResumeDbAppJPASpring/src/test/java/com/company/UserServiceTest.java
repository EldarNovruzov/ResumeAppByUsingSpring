package com.company;

import com.company.entity.User;
import com.company.impl.UserRepositoryCustom;
import com.company.impl.UserRepositoryCustomImpl;
import com.company.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

//    @Spy
    @Mock
    UserRepositoryCustomImpl userDao;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeClass
    public static void setUp(){
        System.out.println("set up called");
    }

    @Before
    public void before(){
        System.out.println("before method called");

        MockitoAnnotations.initMocks(this);

        List<User> list=new ArrayList<>();

        User user=new User();
        user.setName("Eldar");
        user.setSurname("Novruzov");
        user.setEmail("eldarnovruzov99@gmail.com");

        list.add(user);

        Mockito.when(userDao.getAll(null,null,null)).thenReturn(list);

        Mockito.when(userDao.getAll("Eldar","Novruzov",null)).thenReturn(list);

        Mockito.when(userDao.findbyEmailandPassword(null,null)).thenReturn(null);
    }


//    @Test
//    public void test1(){
//        System.out.println(userDao.method());
//        System.out.println(userDao.method());
//        System.out.println(userDao.method());
//        System.out.println(userDao.method());
//    }

    @Test
    public void testGivenNullThenGetAll(){
        List<User> list= userService.getAll(null,null,null);

        Assert.assertEquals("user size must be 1",1,list.size());

        Mockito.verify(userDao,Mockito.atLeastOnce()).
                getAll(null,null,null);
    }

    @Test
    public void testGivenParamsThenGetAllbyFilter(){
        List<User> list= userService.getAll("Eldar","Novruzov",null);

        Assert.assertTrue("user size must be greater than 0",list.size()>0);

        User user= list.get(0);

        Assert.assertEquals("name wrong","Eldar",user.getName());
        Assert.assertEquals("surname wrong","Novruzov",user.getSurname());

        Mockito.verify(userDao,Mockito.atLeastOnce()).
                getAll("Eldar","Novruzov",null);
    }

    @Test
    public void testFindbyEmailandPassword(){

        User user= userService.findbyEmailandPassword(null,null);

        Assert.assertNull("user must be null", user);

        Mockito.verify(userDao,Mockito.atLeastOnce()).findbyEmailandPassword(null,null);
    }


}
