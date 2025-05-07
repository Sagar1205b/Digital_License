package com.sagar.Digital.Digital_License.Service;

import com.sagar.Digital.Digital_License.Model.Recgonition.FaceResponse;
import com.sagar.Digital.Digital_License.Util.MultipartInputStreamFileResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service

public class VerificationService {

    @Value("${verification.api.url}")
    private String externalApiUrl;

    @Value("${verification.api.key}")
    private String apiKey;

    private  final RestTemplate restTemplate=new RestTemplate();

    public FaceResponse faceResponse(String threshold, MultipartFile file)throws IOException {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        httpHeaders.set("x-api-key",apiKey);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

        String url = externalApiUrl + "?det_prob_threshold=" + threshold;
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<FaceResponse> response =
                restTemplate.exchange(url, HttpMethod.POST, requestEntity, FaceResponse.class);

        return response.getBody();




    }
}
