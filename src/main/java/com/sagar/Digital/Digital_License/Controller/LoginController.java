package com.sagar.Digital.Digital_License.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/digital")
public class LoginController {



    @GetMapping("/LoginPage")
    public String  showMyLoginPage(){
        return "login";
    }

    //     add request mapping for /access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}