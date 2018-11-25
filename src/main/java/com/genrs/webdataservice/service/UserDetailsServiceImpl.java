package com.genrs.webdataservice.service;

import com.genrs.webdataservice.model.server.entity.PlayerCredentials;
import com.genrs.webdataservice.repository.server.PlayerCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PlayerCredentialsRepository playerCredentialsRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PlayerCredentials> credentials = playerCredentialsRepository.findPlayerByUsername(username);
        if (!credentials.isPresent()) {
            throw new UsernameNotFoundException(username);
        } else {
            User returned_user = new User(credentials.get().getUsername(), credentials.get().getPassword(), new ArrayList<>());
            System.out.println(returned_user);
            return returned_user;
        }
    }
}
