package com.web.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.web.demo.mapper.UserMapper;
import com.web.demo.model.Role;
import com.web.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MainService implements UserDetailsService{

    @Autowired
    UserMapper mapper;


    @Transactional
    public void userMapper(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // mapper.enrollUser(user);
        mapper.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<User> userEntityWrapper = mapper.findById(id);
        User userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        // if (("admin@example.com").equals(userEmail)) {
        //     authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        // } else {
            authorities.add(new SimpleGrantedAuthority(Role.User.getValue()));
        // }

        return new org.springframework.security.core.userdetails.User(userEntity.getId(), userEntity.getPassword(), authorities);
    }
}