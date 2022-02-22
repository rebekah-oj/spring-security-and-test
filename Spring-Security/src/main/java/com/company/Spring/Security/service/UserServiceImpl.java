package com.company.Spring.Security.service;

import com.company.Spring.Security.entity.Role;
import com.company.Spring.Security.entity.User;
import com.company.Spring.Security.repository.RoleRepository;
import com.company.Spring.Security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
       // log.info("New user saved");
        log.info("New user {} saved to database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
       // log.info("Saving new role to database");
        log.info("Saving new role {} to database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
      //  log.info("Adding  role {} to user {} new role to the database");
        log.info("Adding  role {} to user {} new role to the database", username, roleName);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);

        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
