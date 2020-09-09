package com.wybory.pai.repository;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepo extends JpaRepository<User, Integer> {

    User findUserByAdressEmail(String email);
    User findUserByPesel(Long Pesel);
    User findUserByLogin(String login);
    User findUserByFavCandidate(Candidates candidate);
    User findUserByNameAndSurname(String name, String Surname);
    Long removeUserById(Long id);

    User findUserById(Long id);

    List<User> findUsersByPermissionName(String name);
    List<User> findUsersByPermissionNameOrderByIdAsc(String name);

}

