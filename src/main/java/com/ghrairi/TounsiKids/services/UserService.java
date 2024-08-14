package com.ghrairi.TounsiKids.services;

import com.ghrairi.TounsiKids.models.ChangePasswordRequest;
import com.ghrairi.TounsiKids.models.User;
import com.ghrairi.TounsiKids.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    public Optional<User> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }
    public void changePassword(ChangePasswordRequest request, Principal connectedUser){
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();


        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }

        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }


        user.setPassword(passwordEncoder.encode(request.getNewPassword()));


        repository.save(user);
    }
    public User getUserById(Long userId) {
        return repository.findById((long) userId).orElse(null);
    }

    public User saveUser(User user) {
        return repository.save(user);
    }
}
