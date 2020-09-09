package com.wybory.pai.repository;

import com.wybory.pai.models.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepo extends JpaRepository<Candidates,Long> {
    List<Candidates> findAllByName(String name);

    Candidates findCandidatesByNameAndSurname(String name, String surname);

    Candidates findCandidatesById(Long id);
}
