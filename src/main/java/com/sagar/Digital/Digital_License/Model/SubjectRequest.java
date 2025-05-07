package com.sagar.Digital.Digital_License.Model;

public class SubjectRequest {

    private String subject;

    public SubjectRequest() {
    }

    public SubjectRequest(String subjectName) {
        this.subject = subjectName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
