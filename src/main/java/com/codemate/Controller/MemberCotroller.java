package com.codemate.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codamate.Service.MemberService;
import com.codemate.DTO.MemberDTO;

@Controller
@RequestMapping("/member")
public class MemberCotroller {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/signup")
	public String GetSignup()
	{
		return "member/signup";
	}
	
	@PostMapping("/signup")
	public String PostSignup(MemberDTO dto,
			RedirectAttributes rttr)
	{
		boolean check = service.insertMember(dto);
		
		if(check)
		{
			rttr.addFlashAttribute("msg","회원가입 성공!");
		}
		else
		{
			rttr.addFlashAttribute("msg","회원가입 실패!");
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String GetLogin()
	{
		return "member/login";
	}
	
	@PostMapping("/login")
	public String PostLogin(
			MemberDTO dto,
			HttpSession session,
			RedirectAttributes rttr)
	{
		MemberDTO loginUser = service.selectLogin(dto.getEmail(), dto.getPassword());
		
		if(loginUser == null)
		{
			rttr.addFlashAttribute("msg","이메일 또는 비밀번호가 일치하지 않습니다.");
			return "member/login";
		}
		else
		{
			session.setAttribute("loginUser", loginUser);
			return "redirect:/";
		}
	}
	
	@GetMapping("/logout")
	public String GetLogout(HttpSession session)
	{
		MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");
		
		if(loginUser != null)
		{
			session.invalidate();
		}
		
		return "redirect:/";
	}
}
