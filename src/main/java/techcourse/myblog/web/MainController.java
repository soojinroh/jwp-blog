package techcourse.myblog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import techcourse.myblog.domain.ArticleRepository;
import techcourse.myblog.domain.UserRequestDto;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    private final ArticleRepository articleRepository;

    @Autowired
    public MainController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "index";
    }

    @GetMapping("/writing")
    public String moveWritePage() {
        return "article-edit";
    }

    @GetMapping("/login")
    public String moveLoginPage(HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String index(UserRequestDto userRequestDto) {
        return "signup";
    }

    @GetMapping("/mypage")
    public String moveMyPage() {
        return "mypage";
    }
}
