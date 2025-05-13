package com.sagar.Digital.Digital_License.Controller;

import com.sagar.Digital.Digital_License.Model.Recgonition.FaceResponse;
import com.sagar.Digital.Digital_License.Service.FaceResponseService;
import com.sagar.Digital.Digital_License.Util.InstagramImageExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequestMapping("/digital")
public class FaceResponseController {

    @Autowired
    private FaceResponseService faceResponseService;

    @GetMapping("/recognitionPage")
    public String showRecognitonPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username",username);

        return "faceResponse";
    }


    @PostMapping("/recognition")
    public String TestPhoto_recognitionFace(
           Model model,
            @RequestParam("file") MultipartFile file)
    {

        try {
         FaceResponse faceResponse = faceResponseService.faceResponse(file);
            model.addAttribute("faceResponse", faceResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "faceResult";
    }
    @PostMapping("/recognitionUrl")
    public String recognizeFaceFromUrl(@RequestParam("imageUrl") String profileUrl, Model model) {
        try {
            String imageUrl = null;
            try {
                imageUrl = InstagramImageExtractor.getProfileImageUrl(profileUrl);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // Use the URL to get the image and process it for face recognition
            FaceResponse faceResponse1 = faceResponseService.faceResponseFromUrl(imageUrl);
            model.addAttribute("faceResponse", faceResponse1);

        } catch (IOException e) {
            model.addAttribute("error", "Image recognition failed: " + e.getMessage());
        }
        return "faceResult";
    }

}
