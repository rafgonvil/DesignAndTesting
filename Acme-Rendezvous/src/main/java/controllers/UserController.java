
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.UserService;
import forms.UserForm;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

	@Autowired
	private UserService	userService;


	//Constructor
	public UserController() {
		super();
	}

	//List ---------------------------
	//TODO: Hay que hacer este metodo
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;

		result = new ModelAndView("user/list");

		return result;
	}

	//Create-------------------------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res = new ModelAndView("user/create");
		UserForm userForm = new UserForm();

		res.addObject("userForm", userForm);
		res.addObject("action", "user/create.do");

		return res;
	}
}
