package com.sagar.Digital.Digital_License.Controller;

import com.sagar.Digital.Digital_License.Model.Recgonition.FaceResponse;
import com.sagar.Digital.Digital_License.Service.FaceResponseService;
import com.sagar.Digital.Digital_License.Service.VerificationService;
import com.sagar.Digital.Digital_License.Util.InstagramImageExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/digital")
public class VerificationController {

   @Autowired
   private VerificationService verificationService;

   @GetMapping("/getVerification")
   public String getVerification(Model model){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getName();
       model.addAttribute("username",username);
       return "verification2Images";
   }
    @PostMapping("/recognitionverify")
    public String TestPhoto_recognitionFace(
            Model model,
            @RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2)
    {

        try {
            FaceResponse faceResponse = verificationService.faceResponse(file1,file2);
            model.addAttribute("faceResponse", faceResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "home";
    }

    @PostMapping("/verification")
    public String recognizeFaceFromUrl(
            @RequestParam("imageUrl") String profileUrl, Model model) {
        try {
            String imageUrl = null;
            try {
                imageUrl = InstagramImageExtractor.getProfileImageUrl(profileUrl);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Use the URL to get the image and process it for face recognition
            FaceResponse faceResponse1 = verificationService.faceResponseFromUrl(imageUrl);
            model.addAttribute("faceResponse", faceResponse1);

        } catch (IOException e) {
            model.addAttribute("error", "Image recognition failed: " + e.getMessage());
        }
        return "faceResult";
    }
}


