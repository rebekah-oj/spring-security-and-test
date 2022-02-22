package com.company.Spring.Security.service;

import com.company.Spring.Security.entity.Role;
import com.company.Spring.Security.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
