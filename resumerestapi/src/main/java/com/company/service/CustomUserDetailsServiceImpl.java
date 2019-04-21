package com.company.service;

import com.company.entity.User;
import com.company.impl.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userRepositoryCustom;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u=userRepositoryCustom.findByEmail(email);
        UserBuilder userBuilder=null;
        if (u!=null){
            userBuilder= org.springframework.security.core.userdetails.User.withUsername(email);

            userBuilder.disabled(false);
            userBuilder.password(u.getPassword());

            String[] authoritiesArr=new String[]{"USER","ADMIN"};
            userBuilder.authorities(authoritiesArr);

            return userBuilder.build();
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
