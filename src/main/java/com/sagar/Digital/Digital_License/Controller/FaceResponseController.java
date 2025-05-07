package com.sagar.Digital.Digital_License.Controller;

import com.sagar.Digital.Digital_License.Model.Recgonition.FaceResponse;
import com.sagar.Digital.Digital_License.Service.FaceResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class FaceResponseController {

    @Autowired
    private FaceResponseService faceResponseService;

    @PostMapping("/recgonition")
    public ResponseEntity<FaceResponse> recogiseFace(
            @RequestParam("det_prob_threshold") String threshold,
            @RequestParam("file") MultipartFile file)
    {
        try {
            FaceResponse response=faceResponseService.faceResponse(threshold,file);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
