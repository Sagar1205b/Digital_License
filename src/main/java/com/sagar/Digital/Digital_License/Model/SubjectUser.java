package com.sagar.Digital.Digital_License.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "user_subject")
public class SubjectUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String Subject;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private LicenseHolder licenseHolder;

    public SubjectUser() {
    }

    public SubjectUser(String subject, LicenseHolder licenseHolder) {
        Subject = subject;
        this.licenseHolder = licenseHolder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public LicenseHolder getLicenseHolder() {
        return licenseHolder;
    }

    public void setLicenseHolder(LicenseHolder licenseHolder) {
        this.licenseHolder = licenseHolder;
    }
}
