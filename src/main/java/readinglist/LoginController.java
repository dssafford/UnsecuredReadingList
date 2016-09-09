package readinglist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/login")
public class LoginController {

    private static final String reader = "doug";

    @RequestMapping(method=RequestMethod.GET)
    public String showLogin() {

        return "login";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String gotoLoginSubmit() {
        //book.setReader(reader);
        //readingListRepository.save(book);
        return "loginsubmit";
    }

}
