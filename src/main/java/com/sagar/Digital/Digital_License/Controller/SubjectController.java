package com.sagar.Digital.Digital_License.Controller;

import com.sagar.Digital.Digital_License.Model.LicenseHolder;
import com.sagar.Digital.Digital_License.Model.SubjectRequest;
import com.sagar.Digital.Digital_License.Service.SubjectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/digital")
public class SubjectController {
    private  final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/subject/create")
    @ResponseBody
    public ResponseEntity<String> createSubject(@RequestBody SubjectRequest request, HttpSession session) {
//        LicenseHolder loggedInUser = (LicenseHolder) session.getAttribute("user");

//        if (loggedInUser == null) {
//            return ResponseEntity.status(401).body("Unauthorized - Please log in");
//        }



      return subjectService.createSubject(request.getSubject());
    }



}
