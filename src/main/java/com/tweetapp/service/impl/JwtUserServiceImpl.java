package com.tweetapp.service.impl;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tweetapp.bean.JwtRequestBean;
import com.tweetapp.bean.user.UserInfoBean;
import com.tweetapp.controller.UserController;
import com.tweetapp.dao.UserDao;
import com.tweetapp.exception.UserAlreadyExistsException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtUserServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userRepository;

	@Autowired
	private PasswordEncoder bycrypt;

	public UserInfoBean registerUser(UserInfoBean userInfo) throws UserAlreadyExistsException {
		 if (userRepository.findByEmailId(userInfo.getEmailId()).isPresent()) {
			log.error("email Id already exists");
			throw new UserAlreadyExistsException("email Id already exists");
		} else if (userRepository.findByContactNumber(userInfo.getContactNumber()).isPresent()) {
			log.error("contact number already exists");
			throw new UserAlreadyExistsException("contact number already exists");
		} else {
			System.out.println("userInfo"+userInfo.getEmailId());
			userInfo.setPassword(bycrypt.encode(userInfo.getPassword()));
			System.out.println("userInfo password"+userInfo.getFirstName());
			userRepository.saveUser(userInfo);
			log.info("User Successfully Registered",userInfo.getFirstName());
			return userInfo;
		}
	}

//	public String updateUser(JwtRequestBean userInfo) {
//		Optional<UserInfoBean> user = userRepository.findByLoginId(userInfo.getLoginId());
//		if(user.isPresent()) {
//			userInfo.setPassword(bycrypt.encode(userInfo.getPassword()));
//			userRepository.updatePassword(userInfo);
//			log.info("Password updated successfully",userInfo.getLoginId());
//			return "Password updated successfully";
//		}
//		throw new UsernameNotFoundException(userInfo.getLoginId() + " not found");
//	}

	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		UserInfoBean user = userRepository.findByLoginId(loginId);
		System.out.println("USER:"+user);
		if (user != null) {
			return new User(user.getLoginId(), user.getPassword(), new ArrayList<>());
		}
		throw new UsernameNotFoundException(loginId + " not found");
	}

}
