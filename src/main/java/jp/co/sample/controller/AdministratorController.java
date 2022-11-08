package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	private AdministratorService service;
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		InsertAdministratorForm insertAdministratorForm = new InsertAdministratorForm();
		return insertAdministratorForm;
	}
	
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		LoginForm loginForm = new LoginForm();
		return loginForm;
	}
	
	@RequestMapping("/toInsert")
	public String toInsert(Model model) {
		return "administrator/insert";
	}
	
	@RequestMapping("/insert")
	public String insert(@Validated InsertAdministratorForm form,BindingResult rs,Model model) {
		Administrator administrator;
		if(rs.hasErrors()) {
			return toInsert(model);
		}  else {
		administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		service.insert(administrator);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/")
//	public String toLogin(@Validated LoginForm form,BindingResult result,Model model) {
//		if(result.hasErrors()) {
//			return "toLogin(model)";
//		}
//		return "administrator/login";
//	}
	public String toLogin() {
		return "administrator/login";
	}
	
	@RequestMapping("/login")
	public String login(LoginForm form,Model model) {
		Administrator administrator = service.login(form.getMailAddress(), form.getPassword());
		if(form.getMailAddress() == "" && form.getPassword() == "") {
			model.addAttribute("message", "メールアドレスとパスワードを入力してください。");
			return "administrator/login";
		} else	if(administrator == null) {
			model.addAttribute("message","メールアドレスまたはパスワードが不正です。");
			return "administrator/login";
		} else {
			session.setAttribute("administratorName", administrator.getName());
			return "forward:/employee/showList";
		}
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

}
