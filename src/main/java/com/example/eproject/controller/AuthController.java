package com.example.eproject.controller;

import com.example.eproject.config.Jwt.JwtUtil;
import com.example.eproject.model.dto.UserDTO;
import com.example.eproject.model.req.AuthReq;
import com.example.eproject.model.req.UserReq;
import com.example.eproject.model.res.AuthRes;
import com.example.eproject.service.MailService;
import com.example.eproject.service.UserService;
import com.example.eproject.service.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MailService mailService;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody UserReq createUserReq) {
        UserDTO create = userService.createUser(createUserReq);
        if (create == null) return new ResponseEntity<>("User is not created, try again later", HttpStatus.BAD_REQUEST);
        // Gửi mail đến user khi tạo tài khoản thành công
        String subject = "Tài khoản của bạn đã được tạo";
        String body = "Chào " + createUserReq.getName() + ", tài khoản của bạn đã được tạo thành công.";
        mailService.sendMailUser(fromEmail, createUserReq.getEmail(), subject, body);
        //
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthReq authReq) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException, java.io.IOException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authReq.getEmail(),
                        authReq.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String jwt = jwtUtil.generateToken(authentication);

        return ResponseEntity.ok(new AuthRes(jwt));
    }
}
