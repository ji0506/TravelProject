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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "member/login2";
	}
	
	// (회원)마이페이지 출력-예약내역
	@GetMapping("/myPage")
	@Transactional
	public String myPage(User user,HttpServletRequest request,HttpSession session,Model model) throws Exception{
		session = request.getSession();
		user = (User) session.getAttribute("user");
			
		List<Reservation> rev = reserService.getReserList(user);
//		List<Product> pList = productService.findProductList(rev);
			
			
		model.addAttribute("list", rev);
			
		
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
	
	// 관리자 페이지 이동
	@GetMapping("/adminPage")
	public String adminPage(Model model,HttpServletRequest request) throws Exception{
		String type = request.getParameter("type");
		System.out.println(type);
	/*	if(type != null) {
			if(type.equals("회원")) {
				String member_master = "N";
				List<Reservatio> rev = res.allRev();
				List<MemberVO> list = ms.typeMemberList(cri,member_master);
				PageMaker pm = ms.typePageMaker(cri,member_master);
				
				model.addAttribute("rev",rev);
				model.addAttribute("list",list);
				model.addAttribute("pm",pm);
				return "admin/index";
			}else {
				String member_master = "Y";
				List<User> list = ms.typeMemberList();
//				PageMaker pm = ms.typePageMaker(cri,member_master);
				
				model.addAttribute("list",list);
				model.addAttribute("pm",pm);
				return "admin/index";
			}
		}*/
		List<User> list = userService.memberList();
		List<Reservation> rev = userService.allRev();
		
//		PageMaker pm  = ms.pageMaker(cri);
		
		model.addAttribute("rev",rev);
		model.addAttribute("list",list);
//		model.addAttribute("pm",pm);
		return "admin/index";
	}
	
	@GetMapping("/reservDetail")
	@Transactional
	public String reservDetail(Product vo,HttpSession session,Model model)throws Exception{
		User loginMember = (User) session.getAttribute("user");
		Reservation reserv = reserService.getReservationOfMember(loginMember.getUserId(),vo.getProNo());
//		Detail tripInfo = ms.findtripInfo(vo.getProNo());
		
		Product product = productService.getProductById(vo.getProNo());
		
//		String embassy = url.findEmbassy(product.getProduct_country());
//		System.out.println(embassy);
		
//		model.addAttribute("embassy",embassy);
		model.addAttribute("product",product);
		model.addAttribute("reservation",reserv);
		model.addAttribute("tripInfo",product.getDetail());
		
		return "member/product";
	}
	
	
	@RequestMapping("/checkId.do")
	@ResponseBody
	public int idCheck(ModelMap model,HttpServletRequest request, @RequestParam("userId") String userID){
		int result = -1;
		if(userService.getUserById(userID) !=null) {
			result = 1;
		}else {
			result = 0;
		}
		
		return result;
	}
	
	// 아이디 찾기 페이지이동
	@GetMapping("id_find")
	public String id_find(Model model) {
		String id = "아이디찾기";
		model.addAttribute("id",id);
		return "member/find";
	}
	
	// 비밀번호 찾기 페이지이동
	@GetMapping("pw_find")
	public String pw_find() {
		return "member/find";
	}
	

	// 계정정보 찾기 시도
	@PostMapping("findInfo")
	@ResponseBody
	public User findId(User vo) {
		User findMember = userService.getUserById(vo.getUserId());
		
		return findMember;

	}
	

	//인증메일 전송
	@GetMapping("/checkEmail")
	@ResponseBody
	public String sendMail(@RequestParam("member_email") String email)throws Exception {
		System.out.println(email);
		String code = "";
		for(int i=0; i<5;i++) {
			code +=(int)(Math.random()*10);
		}
		/*
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");
		helper.setFrom("yukitozx7@gmail.com");
		helper.setTo(email);
		helper.setSubject("인증 메일입니다.");
		helper.setText("인증 코드 : <h3>["+code+"]</h3>",true);
		mailSender.send(message);
		System.out.println("발신 완료");*/
		return code;
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
