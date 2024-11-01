package org.jihad.hunters_leagues.service;

import org.jihad.hunters_leagues.dto.UserRegisterDTO;
import org.jihad.hunters_leagues.exception.EmailAlreadyExistsException;
import org.jihad.hunters_leagues.exception.UsernameAlreadyExistsException;
import org.jihad.hunters_leagues.model.User;
import org.jihad.hunters_leagues.model.enums.Role;
import org.jihad.hunters_leagues.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class UserService {

    private  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsException(
                    "Username '" + user.getUsername() + "' is already taken");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException(
                    "Email '" + user.getEmail() + "' is already registered");
        }


        return userRepository.save(user);
    }



}
