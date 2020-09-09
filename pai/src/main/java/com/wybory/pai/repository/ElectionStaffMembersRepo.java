package com.wybory.pai.repository;

import com.wybory.pai.models.ElectionStaff;
import com.wybory.pai.models.ElectionStaffMembers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionStaffMembersRepo extends JpaRepository<ElectionStaffMembers,Long> {

    ElectionStaffMembers findElectionStaffMembersByElectionStaff(ElectionStaff electionStaff);
    ElectionStaffMembers findElectionStaffMembersByNameAndSurname(String name, String surname);
    ElectionStaffMembers findElectionStaffMembersById(Long id);
}
