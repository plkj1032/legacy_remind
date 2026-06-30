package com.codemate.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.codemate.DTO.MemberDTO;
import com.codemate.Util.DBConnection;

@Repository
public class MemberDAO {
	
	public boolean insertMember(MemberDTO dto)
	{
		String sql = "INSERT INTO members(name,age,email,password) "
				+ "VALUES(?,?,?,?)";

		try(
			Connection conn = DBConnection.getConnection();
				
			PreparedStatement ps = conn.prepareStatement(sql);
				){
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getAge());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getPassword());
			
			int result = ps.executeUpdate();
			
			if(result > 0)
			{
				return true;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public MemberDTO selectLogin(String email, String password)
	{
		String sql = "SELECT * FROM members WHERE email = ? AND password = ?";
		
		try(
			Connection conn = DBConnection.getConnection();
				
			PreparedStatement ps = conn.prepareStatement(sql);
				){
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				MemberDTO loginUser = new MemberDTO();
				
				loginUser.setName(rs.getString("name"));
				loginUser.setAge(rs.getInt("age"));
				loginUser.setEmail(rs.getString("email"));
				
				return loginUser;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
