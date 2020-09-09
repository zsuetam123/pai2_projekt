package com.wybory.pai.repository;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.DatesOfVoting;
import com.wybory.pai.models.User;
import com.wybory.pai.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepo extends JpaRepository<Vote, Integer> {
    Vote findVoteByVoter(User user);
    Vote findVoteByDatesOfVoting(DatesOfVoting datesOfVoting);
    Vote findVoteByVoterAndDatesOfVoting(User user, DatesOfVoting datesOfVoting);
    List<Vote> findAllByCandidatesAndDatesOfVoting(Candidates candidate, DatesOfVoting datesOfVoting);
}
