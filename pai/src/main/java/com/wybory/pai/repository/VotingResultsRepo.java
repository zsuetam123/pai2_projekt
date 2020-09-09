package com.wybory.pai.repository;

import com.wybory.pai.models.DatesOfVoting;
import com.wybory.pai.models.VotingResults;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotingResultsRepo extends JpaRepository<VotingResults, Integer> {

    //VotingResults findVotingResultsByDateOfVoting(DatesOfVoting dates);
    List<VotingResults> findVotingResultsByDateOfVoting(DatesOfVoting dates);
    List<VotingResults> findAllByDateOfVoting(DatesOfVoting dates);
}
