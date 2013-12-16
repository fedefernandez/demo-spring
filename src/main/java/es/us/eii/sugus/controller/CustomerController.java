package es.us.eii.sugus.controller;

import es.us.eii.sugus.xml.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private MessageService messageService;

    /**
     * This handler method is invoked when
     * http://localhost:8080/demospring is requested.
     * The method returns view name "index"
     * which will be resolved into /WEB-INF/index.jsp.
     *  See src/main/webapp/WEB-INF/applicationContext.xml
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        String message = messageService.getMessage();
        model.addAttribute("message", message);
        return "index";
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
