package com.codemate.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codamate.Service.CommentService;
import com.codamate.Service.PostService;
import com.codemate.DTO.CommentDTO;
import com.codemate.DTO.MemberDTO;
import com.codemate.DTO.PostDTO;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService service; 
	
	@Autowired
	CommentService c_service;
	
	@GetMapping("write")
	public String GetPostWrite(
			HttpSession session,
			RedirectAttributes rttr)
	{
		MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");
		
		if(loginUser == null)
		{
			rttr.addFlashAttribute("msg","로그인이 필요합니다!");
			return "redirect:/member/login";
		}
		
		return "post/postWrite";
	}
	
	@PostMapping("write")
	public String PostPostWrite(
			PostDTO pto,
			RedirectAttributes rttr)
	{
		boolean check = service.insertPost(pto);
		
		if(check)
		{
			rttr.addFlashAttribute("msg","게시글 등록 완료!");
			return "post/Postlist";
		}
		else
		{
			rttr.addFlashAttribute("msg","게시글 등록 실패!");
			return "post/postWrite";
		}
	}
	
	@GetMapping("list")
	public String GetPostList(
			Model model)
	{
		List<PostDTO> posts = service.selectPosts();
		
		model.addAttribute("posts", posts);
		
		return "post/postList";
	}
	
	@GetMapping("detail")
	public String GetPostDetail(
			@RequestAttribute("id") int post_id,
			Model model
			)
	{
		PostDTO post = service.selectPostOne(post_id);
		List<CommentDTO> comments = c_service.selectComment();
		
		model.addAttribute("post",post);
		model.addAttribute("comments",comments);
		
		return "post/postDetail";
	}
	
	@GetMapping("update")
	public String GetPostUpdate(
			@RequestAttribute("id") int post_id,
			RedirectAttributes rttr,
			Model model,
			HttpSession session)
	{
		MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");
		
		if(loginUser == null)
		{
			rttr.addFlashAttribute("msg","로그인이 필요합니다!");
			return "redirect:/member/login";
		}
		
		PostDTO post = service.selectPostOne(post_id);
		
		model.addAttribute("post", post);
		
		return "post/postUpdate";
	}
	
	@PostMapping("update")
	public String PostMapping(
			PostDTO pto,
			RedirectAttributes rttr)
	{
		boolean check = service.updatePost(pto);
		
		if(check)
		{
			rttr.addFlashAttribute("msg","수정 완료!");
		}
		else
		{
			rttr.addFlashAttribute("msg","수정 실패!");
		}
		
		return "redirect:/post/detail?id=" + pto.getId();
	}
	
	@GetMapping("delete")
	public String GetPostDelete(
			@RequestParam("id") int id,
			RedirectAttributes rttr)
	{
		boolean check = service.deletePost(id);
		
		if(check)
		{
			rttr.addFlashAttribute("msg","삭제 완료!");
		}
		else
		{
			rttr.addFlashAttribute("msg","삭제 실패!");
		}
		
		return "redirect:/post/postDetail?id=" + id;
	}
}
