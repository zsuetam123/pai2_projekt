package com.wybory.pai.repository;

import com.wybory.pai.models.Candidates;
import com.wybory.pai.models.ElectionProgram;
import com.wybory.pai.models.ElectionStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectionProgramRepo extends JpaRepository<ElectionProgram, Integer> {

    ElectionProgram findElectionProgramByElectionStaffId(Integer id);
    ElectionProgram findElectionProgramById(Integer id);
   // List<ElectionProgram> findElectionProgramById(int id);
   // ElectionProgram findElectionProgramByelectionStaff(ElectionStaff electionStaff);

}
