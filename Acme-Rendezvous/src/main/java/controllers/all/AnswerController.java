
package controllers.all;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AnswerService;
import domain.Answer;

@Controller
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerService	answerService;


	public AnswerController() {
		super();
	}

	//List--------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Answer> answers = null;

		result = new ModelAndView("rendezvous/list");
		result.addObject("requestURI", "answer/list.do");
		result.addObject("answers", answers);

		return result;
	}
}
