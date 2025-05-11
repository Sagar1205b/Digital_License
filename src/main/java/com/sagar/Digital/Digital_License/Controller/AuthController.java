package com.sagar.Digital.Digital_License.Controller;

import com.sagar.Digital.Digital_License.Model.LicenseHolder;
import com.sagar.Digital.Digital_License.Service.LicenseHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/digital")
public class AuthController {


    private LicenseHolderService licenseHolderService;

    public AuthController(LicenseHolderService licenseHolderService) {
        this.licenseHolderService = licenseHolderService;
    }




    @GetMapping("/signup")
    public String getSignup(){
        return "register";
    }

    @PostMapping("/save")
    public  String saveLicenseHolder(@ModelAttribute("licenseholder")LicenseHolder thelicenseHolder){
//
        licenseHolderService.save(thelicenseHolder);
//        UsernamePasswordAuthenticationToken authRequest =
//                new UsernamePasswordAuthenticationToken(thelicenseHolder.getUsername(), thelicenseHolder.getPassword());

//        Authentication authentication = authenticationManager.authenticate(authRequest);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        use redirect to prevent duplicate submissions
        return  "redirect:/digital/home";
    }


//    @PostMapping("/save")
//    public  String saveLicenseHolder(@ModelAttribute("licenseholder")LicenseHolder thelicenseHolder){
//
//
////
//        licenseHolderService.save(thelicenseHolder);
////        UsernamePasswordAuthenticationToken authRequest =
////                new UsernamePasswordAuthenticationToken(thelicenseHolder.getUsername(), thelicenseHolder.getPassword());
//
////        Authentication authentication = authenticationManager.authenticate(authRequest);
////        SecurityContextHolder.getContext().setAuthentication(authentication);
////        use redirect to prevent duplicate submissions
//        return  "redirect:/digital/home";
//    }
}



