package int222.project.Dora.Controllers;

import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login/")
    public String logIn(@RequestParam("username") String username,
                      @RequestParam("pwd") String pwd) {
        user findUser = userRepository.findByUserName(username);
        userRepository.findByPassword(findUser.getPassword());
        user logInUser = (pwd == findUser.getPassword() ? findUser : null);
        return logInUser.getRole();
    }
    @PostMapping("/register/")
    public void register(@RequestParam("username") String username,
                         @RequestParam("firstname") String firstname,
                         @RequestParam("lastname") String lastname,
                         @RequestParam("password") String pwd) {
        user newUser = new user();
        newUser.setUserName(username);
        newUser.setName(firstname);
        newUser.setLastName(lastname);
        newUser.setPassword(pwd);
        userRepository.save(newUser);
        System.out.println(newUser.getUserId());
    }
}
