package com.anstech.speechtotext.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.anstech.speechtotext.entity.User;
import com.anstech.speechtotext.helper.ResponseUtil;
import com.anstech.speechtotext.repo.UserRepository;

@Service
public class UserServiceImpl   {

	@Autowired
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

//	@Override
//	public ResponseUtil createUser(User user) {
//		this.passwordEncoder = new BCryptPasswordEncoder();
//		ResponseUtil responseUtil = new ResponseUtil();
//		UserServiceImpl serviceImpl = new UserServiceImpl();
//		if (serviceImpl.isEmpty(user, responseUtil)) {
//			return responseUtil;
//		}
//		if (userRepository.existsByUserEmail(user.getUserEmail())) {
//			responseUtil.setMesg("email already exist");
//			return responseUtil;
//		}
//		if (!user.getPassword().equals(user.getConfPassword())) {
//			responseUtil.setMesg("password does not match");
//			return responseUtil;
//		}
//		if (user.getPassword().equals(user.getConfPassword())) {
//			String passowrd = this.passwordEncoder.encode(user.getPassword());
//			String congPassword = this.passwordEncoder.encode(user.getConfPassword());
//			user.setPassword(passowrd);
//			user.setConfPassword(congPassword);
//			userRepository.save(user);
//			responseUtil.setObject(user);
//			responseUtil.setMesg("created successfully");
//			return responseUtil;
//		}
//
//		return responseUtil;
//
//	}
//
//	public boolean isEmpty(User user, ResponseUtil responseUtil) {
//		boolean f = false;
//		if (user.getUserFirstName().trim() == "" || user.getUserFirstName() == null) {
//			responseUtil.setMesg("first name is required");
//			return f = true;
//		}
//		if (user.getUserLastName() == null || user.getUserLastName().trim() == "") {
//			responseUtil.setMesg("last name is required");
//			return f = true;
//		}
//		if (user.getPassword() == null || user.getPassword().trim() == "") {
//			responseUtil.setMesg("password is required");
//			return f = true;
//		}
//		if (user.getConfPassword() == null || user.getConfPassword().trim() == "") {
//			responseUtil.setMesg("password is required");
//			return f = true;
//		}
//		if (user.getUserEmail() == null || user.getUserEmail().trim() == "") {
//			responseUtil.setMesg("email is required");
//			return f = true;
//		}
//		return f;
//	}
//
//	@Override
//	public void removeUser() {
//		
//	}
}
