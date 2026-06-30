package com.codemate.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.codemate.DTO.CommentDTO;
import com.codemate.Util.DBConnection;

@Repository
public class CommentDAO {
	public boolean insertComment(CommentDTO cto)
	{
		String sql = "INSERT INTO comments(post_id,member_id,content) "
				+ "VALUES(?,?,?)";
		
		try {
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cto.getPost_id());
			ps.setInt(2, cto.getMember_id());
			ps.setString(3, cto.getContent());
			
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
	
	public List<CommentDTO> selectComments()
	{
		String sql = "SELECT * FROM comments";
		
		try {
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<CommentDTO> comments = new ArrayList<>();
			
			while(rs.next())
			{
				CommentDTO cto = new CommentDTO();
				
				cto.setId(rs.getInt("id"));
				cto.setContent(rs.getString("content"));
				
				comments.add(cto);
			}
			return comments;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
