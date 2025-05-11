package com.sagar.Digital.Digital_License.Service;

import com.sagar.Digital.Digital_License.Model.SubjectUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectService {
    ResponseEntity<String> createSubject(String subjectName);
    SubjectUser save(SubjectUser subjectUser);
    SubjectUser createAndSaveSubject(String subject);
    List<String> getAllSubjects();
}
