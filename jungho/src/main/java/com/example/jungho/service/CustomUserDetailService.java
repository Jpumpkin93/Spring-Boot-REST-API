package com.example.jungho.service;

import com.example.jungho.advice.exception.CUserNotFoundException;
import com.example.jungho.repo.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserJpaRepo userJpaRepo;

    @Override
    public UserDetails loadUserByUsername(String userPk) {
        return userJpaRepo.findByUid(userPk).orElseThrow(CUserNotFoundException::new);
    }
}
