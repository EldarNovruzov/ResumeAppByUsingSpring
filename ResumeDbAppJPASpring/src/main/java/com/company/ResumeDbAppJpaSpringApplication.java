package com.company;

import com.company.entity.User;
import com.company.impl.UserRepository;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


import java.util.List;

@SpringBootApplication
@EnableCaching
public class ResumeDbAppJpaSpringApplication {
//	@Autowired
//	private UserServiceInter userDao;

//	@Autowired
//	@Qualifier("obj")
//	private Object object;
//@Autowired
//private MyConfiguration mfc;
//
//	@Autowired
//	private MyConfiguration mfc2;
//
//	@Autowired
//	@Qualifier("alma")
//	private Object obj;

//	@Autowired
//	@Qualifier("alma")
//	private Object obj2;


//
//	@Autowired
//	@Qualifier("alma")
//	private Object obj2;

//	@Autowired
//	@Qualifier("alma")
//	private Object obj2;

//	@Autowired
//	private MyComponent mc;
//
//	@Autowired
//	private MyComponent mc2;

//@Autowired
//@Qualifier("userDao1")
//private  UserRepositoryCustom userDao;
//
//	public static void main(String[] args) {
//	SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
//	}
//
//	@Bean
//	public CommandLineRunner run(){
//		CommandLineRunner clr=new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
////				System.out.println("obj="+obj);
//				List<User> list= userDao.getAll(null,null,null);
//				System.out.println(list);
//			}
//		};
//		return clr;
//	}
//@Autowired
//private UserRepository userRepository;

//	@Autowired
//	private UserServiceInter userService;
//
//	public static void main(String[] args) {
//	SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
//	}
//
//	@Bean
//	public CommandLineRunner run(){
//		CommandLineRunner clr=new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				for (int i=0;i<10;i++) {
//					List<User> u = userService.getAll(null, null, null);
//				}
//			}
//		};
//		return clr;
//	}

}
