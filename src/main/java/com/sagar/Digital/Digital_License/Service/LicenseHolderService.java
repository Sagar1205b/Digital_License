package com.sagar.Digital.Digital_License.Service;

import com.sagar.Digital.Digital_License.Model.LicenseHolder;
import com.sagar.Digital.Digital_License.Repository.LicenseHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service

public class LicenseHolderService implements LicenseHolderServiceImpl{
    @Autowired
    private LicenseHolderRepository licenseHolderRepository;

    private  final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public LicenseHolderService(LicenseHolderRepository licenseHolderRepository) {
        this.licenseHolderRepository = licenseHolderRepository;
    }


    @Override
    public LicenseHolder save(LicenseHolder theLicenseHolder) {
        Optional<LicenseHolder> existingUser=licenseHolderRepository.findByUsername(theLicenseHolder.getUsername());
        if(existingUser.isPresent()){
            throw  new RuntimeException("username is already taken");
        }
        theLicenseHolder.setPassword(passwordEncoder.encode(theLicenseHolder.getPassword()));
        if (theLicenseHolder.getRole() == null || theLicenseHolder.getRole().isEmpty()) {
            theLicenseHolder.setRole("ROLE_USER");  // Default role
        }
        return licenseHolderRepository.save(theLicenseHolder);
    }
}
