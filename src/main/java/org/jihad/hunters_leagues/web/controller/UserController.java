package org.jihad.hunters_leagues.web.controller;

import jakarta.validation.Valid;
import org.jihad.hunters_leagues.model.User;
import org.jihad.hunters_leagues.service.UserService;
import org.jihad.hunters_leagues.web.vm.RegisterVm;
import org.jihad.hunters_leagues.web.vm.mapper.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    private RegisterMapper registerMapper;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, RegisterMapper registerMapper, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.registerMapper = registerMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterVm> register(@Valid @RequestBody RegisterVm registerRequest) {
        User user = registerMapper.toEntity(registerRequest);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(registerMapper.toDto(savedUser));
    }


}
