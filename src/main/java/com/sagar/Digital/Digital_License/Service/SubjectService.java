package com.sagar.Digital.Digital_License.Service;

import com.sagar.Digital.Digital_License.Model.LicenseHolder;
import com.sagar.Digital.Digital_License.Model.SubjectRequest;
//import com.sagar.Digital.Digital_License.Repository.SubjectRepo;
import com.sagar.Digital.Digital_License.Model.SubjectUser;
import com.sagar.Digital.Digital_License.Repository.LicenseHolderRepository;
import com.sagar.Digital.Digital_License.Repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class SubjectService implements SubjectServiceImpl {

    private final RestTemplate restTemplate;

    private final SubjectRepository subjectRepository;

    private final LicenseHolderRepository licenseHolderRepository;





    public SubjectService(RestTemplate restTemplate, SubjectRepository subjectRepository, LicenseHolderRepository licenseHolderRepository) {
        this.restTemplate = restTemplate;
        this.subjectRepository = subjectRepository;
        this.licenseHolderRepository = licenseHolderRepository;
    }
    @Value("${recognition.api.url}")
    private String apiUrl;

    @Value("${recognition.api.key}")
    private String apiKey;




    public ResponseEntity<String> createSubject(String subjectName){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("x-api-key",apiKey);
//        pojo class
        SubjectRequest request=new SubjectRequest(subjectName);
        HttpEntity<SubjectRequest>entity=new HttpEntity<>(request,httpHeaders);

        return  restTemplate.postForEntity(apiUrl,entity,String.class);
    }


    @Override
    public SubjectUser save(SubjectUser subjectUser) {
        return subjectRepository.save(subjectUser);
    }
}
