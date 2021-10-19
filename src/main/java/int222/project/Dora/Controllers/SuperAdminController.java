package int222.project.Dora.Controllers;

import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SuperAdminController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/showalluser")
    public List<user> showallUser(){
        List<user> alluser = userRepository.findAll();
        return alluser;
    }
    @PutMapping("/PromoteRole")
    public void changeRole(@RequestParam("idUser") long idUser,
                           @RequestParam("Role") int role){
        user Roleuser = userRepository.findById(idUser).orElse(null);
        switch (role){
            case 1:
                Roleuser.setRole("admin");
                break;
            case 0:
                Roleuser.setRole("customer");
                break;
        }
        userRepository.save(Roleuser);
    }
}
