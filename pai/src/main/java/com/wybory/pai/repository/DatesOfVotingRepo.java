package com.wybory.pai.repository;

import com.wybory.pai.models.DatesOfVoting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DatesOfVotingRepo extends JpaRepository<DatesOfVoting,Integer> {
    DatesOfVoting findDatesOfVotingById(Integer id);
    DatesOfVoting findDatesOfVotingBydateOfVoting(Date day);
}