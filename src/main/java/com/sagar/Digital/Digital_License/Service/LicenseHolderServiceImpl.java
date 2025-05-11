package com.sagar.Digital.Digital_License.Service;

import com.sagar.Digital.Digital_License.Model.LicenseHolder;
import jakarta.servlet.http.HttpSession;

public interface LicenseHolderServiceImpl {
    LicenseHolder save(LicenseHolder theLicenseHolder);
}
