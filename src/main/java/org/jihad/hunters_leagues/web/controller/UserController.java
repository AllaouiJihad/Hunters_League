package org.jihad.hunters_leagues.web.controller;

import jakarta.validation.Valid;
import org.jihad.hunters_leagues.model.User;
import org.jihad.hunters_leagues.service.UserService;
import org.jihad.hunters_leagues.web.vm.LoginVm;
import org.jihad.hunters_leagues.web.vm.RegisterVm;
import org.jihad.hunters_leagues.web.vm.mapper.LoginMapper;
import org.jihad.hunters_leagues.web.vm.mapper.RegisterMapper;
import org.jihad.hunters_leagues.web.vm.mapper.UserMapper;
import org.jihad.hunters_leagues.web.vm.request.UserSearchRequestVm;
import org.jihad.hunters_leagues.web.vm.response.UserSearchResponseVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private LoginMapper loginMapper;






    @PostMapping("/register")
    public ResponseEntity<RegisterVm> register(@Valid @RequestBody RegisterVm registerRequest) {
        User user = registerMapper.toEntity(registerRequest);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(registerMapper.toDto(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginVm> login(@Valid @RequestBody LoginVm loginRequest){
        Optional<User> user = userService.findByUsername(loginRequest.getUsername());

        if (user.isEmpty() || !passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        LoginVm userDto = loginMapper.toDto(user.get());

        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @GetMapping("/users")
    public Page<User> findAll(@RequestParam(name = "page", required = false, defaultValue = "${pagination.defaultPage}") int page, @RequestParam(name = "size", required = false, defaultValue = "${pagination.defaultPageSize}") int size) {
        return userService.findAll(page, size);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<User>> searchUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<User> users = userService.search(username, email, page, size);
        return ResponseEntity.ok(users);
    }


}
