package com.sagar.Digital.Digital_License.Controller;


import com.sagar.Digital.Digital_License.Model.AddImage;
import com.sagar.Digital.Digital_License.Service.AddImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class AddImageController {

    @Autowired
    private AddImageService addImageService;

    @PostMapping("/faces")
    public ResponseEntity<AddImage> recognizeFace(
            @RequestParam("subject") String subject,
            @RequestParam("det_prob_threshold") String threshold,
            @RequestParam("file") MultipartFile file){
        try {
            AddImage response=addImageService.addImage(subject,threshold,file);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
