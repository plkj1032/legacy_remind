package com.codamate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemate.DAO.MemberDAO;
import com.codemate.DTO.MemberDTO;

@Service
public class MemberService {

	@Autowired
	MemberDAO dao;
	
	public boolean insertMember(MemberDTO dto)
	{
		return dao.insertMember(dto);
	}
	
	public MemberDTO selectLogin(String email, String password)
	{
		return dao.selectLogin(email, password);
	}

}
