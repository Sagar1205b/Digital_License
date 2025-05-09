package com.sagar.Digital.Digital_License.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/digital")
public class LoginController {



    @GetMapping("/LoginPage")
    public String  showMyLoginPage(){
        return "login";
    }

    @GetMapping("/logout")
    public String  LogOut(){
        return "index";
    }

    //     add request mapping for /access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}