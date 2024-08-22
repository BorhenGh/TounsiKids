package com.ghrairi.TounsiKids.controller;

import com.ghrairi.TounsiKids.models.User;
import com.ghrairi.TounsiKids.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

import static com.ghrairi.TounsiKids.utils.Constants.Api_Root;


@RestController
@RequestMapping(value = Api_Root+"/users")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) throws ChangeSetPersister.NotFoundException {
        return Optional.ofNullable(userService.getUserByEmail(email)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException()));
    }

    @GetMapping("/current-user")
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }

}