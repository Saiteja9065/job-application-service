package com.ttbytes.job_application_service.implementation;

import com.ttbytes.job_application_service.model.Users;
import com.ttbytes.job_application_service.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsPasswordService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        Users existingUser = (Users) user;
        existingUser.setPassword(newPassword);
        return usersRepository.save(existingUser);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return usersRepository.findUserByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
