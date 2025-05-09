package com.sagar.Digital.Digital_License.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SubjectRequest {

    @NotBlank
    @Size(min = 1, max = 50)
    private String subject;


    public SubjectRequest() {
    }

    public SubjectRequest(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
