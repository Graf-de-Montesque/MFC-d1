package pkg3iteration.studentorder.domain;

import java.time.LocalDate;


public class Adult extends Person {
    private String passportSeria;
    private String passportNumber;
    private LocalDate issueDate;
    private PassportOffice issueDepartment;
    private LocalDate passportDate;
    private University university;

    public Adult() {
        
    }

    public LocalDate getPassportDate() {
        return passportDate;
    }

    public void setPassportDate(LocalDate passportDate) {
        this.passportDate = passportDate;
    }
    
    private String studentId;
    
    public Adult(String surName, String givenName, String patronymic, LocalDate dateOfBirth) {
        super(surName, givenName, patronymic, dateOfBirth);
    }
    
    
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University u) {
        this.university = u;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public PassportOffice getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(PassportOffice issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}

    
