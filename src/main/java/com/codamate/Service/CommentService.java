package com.codamate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemate.DAO.CommentDAO;
import com.codemate.DTO.CommentDTO;

@Service
public class CommentService {
	
	@Autowired
	private CommentDAO cao;
	
	public boolean insertComment(CommentDTO cto)
	{
		return cao.insertComment(cto);
	}
	
	public List<CommentDTO> selectComment()
	{
		return cao.selectComments();
	}
}
