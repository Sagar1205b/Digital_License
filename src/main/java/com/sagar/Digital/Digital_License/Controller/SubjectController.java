package com.sagar.Digital.Digital_License.Controller;

import com.sagar.Digital.Digital_License.Model.SubjectRequest;
import com.sagar.Digital.Digital_License.Repository.LicenseHolderRepository;
import com.sagar.Digital.Digital_License.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/digital")
public class SubjectController {



    private  final LicenseHolderRepository licenseHolderRepository;

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(LicenseHolderRepository licenseHolderRepository, SubjectService subjectService) {
        this.licenseHolderRepository = licenseHolderRepository;

        this.subjectService = subjectService;
    }

    // GET method to display the form
    @GetMapping("/subject/create")
    public String showCreateSubjectForm(Model model) {
        model.addAttribute("subjectcreation", new SubjectRequest()); // Initialize form backing object
        return "createSubject"; // Thymeleaf template
    }

    // POST method to handle form submission

    @PostMapping("/subject/create")
    public String submitSubjectForm(@ModelAttribute("subjectcreation") SubjectRequest subjectDTO) {

        subjectService.createSubject(subjectDTO.getSubject());
        subjectService.createAndSaveSubject(String.valueOf(subjectDTO.getSubject()));

        return "redirect:/digital/subject/create";
    }




   /* @PostMapping("/subject/create1")
    public String submitSubjectAndForm(@ModelAttribute("subjectcreation") SubjectRequest subjectDTO) {

    subjectService.createSubject(String.valueOf(subjectDTO.getSubject()));
    SubjectUser user=new SubjectUser();
    user.setSubject(subjectDTO.getSubject());
    user.getId();

    subjectService.save(user);

        return "redirect:/digital/subject/create";
    }*/


}
