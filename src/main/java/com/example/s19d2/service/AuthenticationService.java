package com.example.s19d2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.s19d2.entity.Authority;
import com.example.s19d2.entity.Member;
import com.example.s19d2.entity.Role;
import com.example.s19d2.repository.MemberRepository;
import com.example.s19d2.repository.RoleRepository;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class AuthenticationService {
    private MemberRepository memberRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

  

    public Member register(String fullName, String email, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority(Authority.USER).get();

        List<Role> rolesAuth = new ArrayList<>();
        rolesAuth.add(userRole);

        Member member = new Member();
        member.setEmail(email);       
        member.setPassword(encodedPassword);
        member.setRoles(rolesAuth);

        return memberRepository.save(member);
    }
}
