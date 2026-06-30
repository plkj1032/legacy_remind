package com.codamate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemate.DAO.PostDAO;
import com.codemate.DTO.PostDTO;

@Service
public class PostService {
	
	@Autowired
	PostDAO pao;
	
	public boolean insertPost(PostDTO pto)
	{
		return pao.insertPost(pto);
	}
	
	public List<PostDTO> selectPosts()
	{
		return pao.selectPosts();
	}
	
	public boolean deletePost(int post_id)
	{
		return pao.deletePost(post_id);
	}
	
	public PostDTO selectPostOne(int post_id)
	{
		return pao.selectPostOne(post_id);
	}
}
