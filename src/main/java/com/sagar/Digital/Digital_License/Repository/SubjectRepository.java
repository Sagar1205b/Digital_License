package com.sagar.Digital.Digital_License.Repository;

import com.sagar.Digital.Digital_License.Model.SubjectUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<SubjectUser,Integer> {

//    @Query("SELECT DISTINCT Subject FROM SubjectUser")
//    List<String> findAllDistinctSubjects();

    @Query("SELECT DISTINCT s.Subject FROM SubjectUser s WHERE s.licenseHolder.username = :username")
    List<String> findSubjectsByUsername(String username);

}
