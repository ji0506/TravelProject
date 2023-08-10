package com.spr.travel.Member;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.Session;
import com.spr.travel.domain.Product;
import com.spr.travel.domain.Reservation;
import com.spr.travel.domain.User;
import com.spr.travel.service.ProductService;
import com.spr.travel.service.ReserService;

@Controller
@RequestMapping("/member/*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ReserService reserService;

	@Autowired
	private ProductService productService;

	
	
	@RequestMapping("/main.do")
	public String list() {	
		return "member/login";
	}
	

	

	// (회원)마이페이지 출력-예약내역
	@GetMapping("/myPage")
	@Transactional
	public String myPage(User user,HttpServletRequest request,HttpSession session,Model model) throws Exception{
		session = request.getSession();
		user = (User) session.getAttribute("user");
			
		List<Reservation> rev = reserService.getReserList(user);
//		List<Product> pList = productService.findProductList(rev);
			
			
		model.addAttribute("c", rev);
			
		
		return "member/info";
	}
	
	@RequestMapping("/logout.do")
	public String logout(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        
		HttpSession session = request.getSession();

        
		session.removeAttribute("user");

		return "redirect:/main/main.do";
	}

	@RequestMapping("/join.do")
	public String join(ModelMap model,HttpServletRequest request, HttpServletResponse response) {


		return "/member/join";
	}

	@RequestMapping("/save.do")
	public String save(User user) {

		user.setUserPwd(sha256Hash(user.getUserPwd()));
		userService.createUser(user);

		return "redirect:/member/main.do";
	}



	public String sha256Hash(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

			// 해시 값을 16진수 문자열로 변환
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// (회원) 정보수정 페이지이동
	@GetMapping("/edit_check")
	public String changeInfo() {
		return "member/editcheck";
	}


}
