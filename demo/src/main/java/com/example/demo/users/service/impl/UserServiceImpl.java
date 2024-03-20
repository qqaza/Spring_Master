package com.example.demo.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.users.CustomUsers;
import com.example.demo.users.UsersVO;
import com.example.demo.users.mapper.UsersMapper;
import com.example.demo.users.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	@Autowired UsersMapper usersMapper;
	@Override
	public UsersVO getUsersInfo(String Userid) {
		return usersMapper.getUsersInfo(Userid);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersVO usersVO = usersMapper.getUsersInfo(username);
		if(usersVO == null) {
			throw new UsernameNotFoundException("id not found");
		}
		
		return new CustomUsers(usersVO);
	}

		
}
