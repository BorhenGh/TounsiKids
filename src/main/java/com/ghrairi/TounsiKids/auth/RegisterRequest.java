package com.ghrairi.TounsiKids.auth;

import com.ghrairi.TounsiKids.models.Enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private String location;
    private String profileImage;
    private Role role;
}