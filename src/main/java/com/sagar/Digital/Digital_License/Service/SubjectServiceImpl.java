package com.sagar.Digital.Digital_License.Service;

import com.sagar.Digital.Digital_License.Model.LicenseHolder;
import com.sagar.Digital.Digital_License.Model.SubjectRequest;
import com.sagar.Digital.Digital_License.Model.SubjectUser;
import com.sagar.Digital.Digital_License.Repository.LicenseHolderRepository;
import com.sagar.Digital.Digital_License.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final RestTemplate restTemplate;
    private final SubjectRepository subjectRepository;
    private final LicenseHolderRepository licenseHolderRepository;

    @Autowired
    public SubjectServiceImpl(RestTemplate restTemplate, SubjectRepository subjectRepository, LicenseHolderRepository licenseHolderRepository) {
        this.restTemplate = restTemplate;
        this.subjectRepository = subjectRepository;
        this.licenseHolderRepository = licenseHolderRepository;
    }

    @Value("${recognition.api.url}")
    private String apiUrl;

    @Value("${recognition.api.key}")
    private String apiKey;

    @Override
    public ResponseEntity<String> createSubject(String subjectName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apiKey);

        SubjectRequest request = new SubjectRequest(subjectName);
        HttpEntity<SubjectRequest> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForEntity(apiUrl, entity, String.class);
    }

    @Override
    public SubjectUser save(SubjectUser subjectUser) {
        return subjectRepository.save(subjectUser);
    }

    @Override
    public SubjectUser createAndSaveSubject(String subject) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // assuming username is unique

        LicenseHolder licenseHolder = licenseHolderRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        SubjectUser user = new SubjectUser();
        user.setSubject(subject);
        user.setLicenseHolder(licenseHolder);

         return  subjectRepository.save(user);
    }

    @Override
    public List<String> getAllSubjects() {
        return subjectRepository.findAllDistinctSubjects();
    }


}
