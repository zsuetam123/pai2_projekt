package com.wybory.pai.controllers;

import com.wybory.pai.models.Permission;
import com.wybory.pai.models.User;
import com.wybory.pai.repository.LoginRepo;
import com.wybory.pai.repository.PermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    LoginRepo repo;

    @Autowired
    PermissionRepo perm;

    boolean prawda = true;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("regis")
    ResponseEntity<String> regis(@RequestParam ("Imie") String Imie,
                                 @RequestParam ("Nazwisko") String Nazwisko,
                                 @RequestParam ("Pesel") Long Pesel,
                                 @RequestParam ("Miejscowosc") String Miejscowosc,
                                 @RequestParam ("Email") String Email,
                                 @RequestParam ("Login") String Login,
                                 @RequestParam ("Haslo") String Haslo)
    {
        User user1 = repo.findUserByAdressEmail(Email);
        User user2 = repo.findUserByPesel(Pesel);
        User user3 = repo.findUserByLogin(Login);

        if(user1 == null && user2 == null && user3 == null)
        {
        User user = new User();
        Permission permission = perm.findPermissionById(3);
        //user.setId((long) 2);
        user.setName(Imie);
        user.setSurname(Nazwisko);
        user.setPesel(Pesel);
        user.setLocality(Miejscowosc);
        user.setAdressEmail(Email);
        user.setLogin(Login);
        user.setPassword(Haslo);
        user.setPermission(permission);
        user.setfavCandidate(null);
        repo.save(user);
        return new ResponseEntity<>("Dodano uzytkownika", HttpStatus.OK);
        }
        else
            {
            return new ResponseEntity<>("Pesel, login lub email zajęty", HttpStatus.OK);
            }
    }
}
