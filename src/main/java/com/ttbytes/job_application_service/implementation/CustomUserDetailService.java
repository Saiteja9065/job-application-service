package com.ttbytes.job_application_service.implementation;

import com.ttbytes.job_application_service.model.Users;
import com.ttbytes.job_application_service.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UsersRepository usersRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return usersRepository.findUserByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
