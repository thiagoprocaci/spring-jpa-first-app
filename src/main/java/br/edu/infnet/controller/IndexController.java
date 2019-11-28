package br.edu.infnet.controller;

import br.edu.infnet.interceptor.UserSession;
import br.edu.infnet.model.User;
import br.edu.infnet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserSession userSession;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initialPage() {
        return "/index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupPage() {
        return "/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void saveUser(@RequestParam("name") String name,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password,
                       Map<String, Object> model) {
        if(StringUtils.hasText(name) && StringUtils.hasText(email) && StringUtils.hasText(password)) {
            if(userRepository.findByEmail(email) != null) {
                model.put("message", "Este e-mail já está em uso.");
            } else {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                userRepository.save(user);
                model.put("message", "Usuário cadastrado com sucesso.");
            }
        } else {
            model.put("message", "Por favor preencha todos os campos.");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam("email") String email,
                          @RequestParam("password") String password,
                          Map<String, Object> model) {
        if(StringUtils.hasText(email) && StringUtils.hasText(password)) {
            User user = userRepository.findByEmail(email);
            if(user != null && password.equals(user.getPassword())) {
                userSession.addLoggedUser(user);
                return "redirect:/secure";
            } else {
                model.put("message", "Login inválido.");
                return null;
            }
        } else {
            model.put("message", "Por favor preencha todos os campos.");
            return null;
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        userSession.removeLoggedUser();
        return "redirect:/login";
    }

    @RequestMapping(value = "/secure", method = RequestMethod.GET)
    public String securePage(Map<String, Object> model) {
        User user = userSession.getLoggedUser();
        model.put("user", user);
        return "/secure";
    }

}
