package com.wybory.pai.repository;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.ElectionStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionStaffRepo extends JpaRepository<ElectionStaff,Long> {

    ElectionStaff findElectionStaffById(Integer id);
    ElectionStaff findElectionStaffByCandidates(Candidates candidate);

}
