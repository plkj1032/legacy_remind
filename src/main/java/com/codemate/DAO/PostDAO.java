package com.codemate.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.codemate.DTO.PostDTO;
import com.codemate.Util.DBConnection;

@Repository
public class PostDAO {
	public boolean insertPost(PostDTO pto)
	{
		String sql = "INSERT INTO posts(member_id,title,content) "
				+ "VALUES(?,?,?,NOW())";
		
		try(
			Connection conn = DBConnection.getConnection();
				
			PreparedStatement ps = conn.prepareStatement(sql);
				){
			ps.setInt(1, pto.getMember_id());
			ps.setString(2, pto.getTitle());
			ps.setString(3, pto.getContent());
			
			int result = 0;
			
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
	
	public List<PostDTO> selectPosts()
	{
		String sql = "SELECT * FROM posts";
		
		try(
			Connection conn = DBConnection.getConnection();
				
			PreparedStatement ps = conn.prepareStatement(sql);
				
			ResultSet rs = ps.executeQuery();
				){
			
			List<PostDTO> posts = new ArrayList<>();
			
			while(rs.next())
			{
				PostDTO pto = new PostDTO();
				
				pto.setMember_id(rs.getInt("member_id"));
				pto.setTitle(rs.getString("title"));
				pto.setContent(rs.getString("content"));
				pto.setCreated_at(rs.getString("created_at"));
				
				posts.add(pto);
			}
			
			return posts;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public PostDTO selectPostOne(int post_id)
	{
		String sql = "SELECT * FROM posts WHERE id = ?";
		
		try(
			Connection conn = DBConnection.getConnection();
				
			PreparedStatement ps = conn.prepareStatement(sql);
				){
			ps.setInt(1, post_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				PostDTO post = new PostDTO();
				
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setCreated_at(rs.getString("created_at"));
				
				return post;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public boolean deletePost(int post_id)
	{
		String sql = "DELETE FROM posts WHERE id = ?";
		
		try(
			Connection conn = DBConnection.getConnection();
				
			PreparedStatement ps = conn.prepareStatement(sql);
				){
			ps.setInt(1, post_id);
			
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
}
