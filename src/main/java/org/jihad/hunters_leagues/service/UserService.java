package org.jihad.hunters_leagues.service;

import org.jihad.hunters_leagues.dto.UserRegisterDTO;
import org.jihad.hunters_leagues.exception.EmailAlreadyExistsException;
import org.jihad.hunters_leagues.exception.UserNotFoundException;
import org.jihad.hunters_leagues.exception.UsernameAlreadyExistsException;
import org.jihad.hunters_leagues.model.User;
import org.jihad.hunters_leagues.model.enums.Role;
import org.jihad.hunters_leagues.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public void delete(UUID id) {
        findById(id);
        userRepository.deleteUser(id);
    }

    public Page<User> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("username"));
        return userRepository.findAll(pageable);
    }


    public Page<User> search(String username, String email, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.search(username, email, pageable);
    }

}
