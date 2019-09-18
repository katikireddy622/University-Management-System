package com.jntuh.cse.dms.service;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jntuh.cse.dms.dao.UserDAO;
import com.jntuh.cse.dms.model.Users;

@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;
	@Override
	public UserDetails loadUserByUsername(String userName)
			        throws UsernameNotFoundException {
		Users activeUserInfo = userDAO.getActiveUser(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
		UserDetails userDetails = (UserDetails)new User(activeUserInfo.getUserName(),
				activeUserInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
} 