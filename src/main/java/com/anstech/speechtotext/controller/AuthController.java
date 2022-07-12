package com.anstech.speechtotext.controller;

import java.net.URI;
import java.util.Collections;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.anstech.speechtotext.entity.Role;
import com.anstech.speechtotext.entity.User;
import com.anstech.speechtotext.enums.RoleName;
import com.anstech.speechtotext.exceptions.AppException;
import com.anstech.speechtotext.payload.ApiResponse;
import com.anstech.speechtotext.payload.JwtAuthenticationResponse;
import com.anstech.speechtotext.payload.LoginRequest;
import com.anstech.speechtotext.payload.SignUpRequest;
import com.anstech.speechtotext.repo.RoleRepository;
import com.anstech.speechtotext.repo.UserRepository;
import com.anstech.speechtotext.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider tokenProvider;

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

		logger.info(" Request username {}, password {}, email {},  ", signUpRequest.getUsername(),
				signUpRequest.getPassword(), signUpRequest.getEmail());

		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByMobile(signUpRequest.getMobile())) {
			return new ResponseEntity(new ApiResponse(false, "Mobile number already in use!"), HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				signUpRequest.getPassword(), signUpRequest.getMobile(), signUpRequest.getActive(),
				signUpRequest.getAddress());

		user.setPassword(passwordEncoder.encode(user.getPassword()));

//		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
//				.orElseThrow(() -> new AppException("User Role not set."));

		//RoleName user_role = RoleName.valueOf(signUpRequest.getRole());
		//Role userRole = roleRepository.findByName(user_role).orElseThrow(() -> new AppException("User Role not set."));

		//user.setRoles(Collections.singleton(userRole));

		User result = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{username}")
				.buildAndExpand(result.getUsername()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		// logger.info("login request ::"+loginRequest);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, loginRequest.getUsernameOrEmail()));
	}
}
