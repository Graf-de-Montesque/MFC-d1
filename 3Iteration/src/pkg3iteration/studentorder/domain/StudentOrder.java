package pkg3iteration.studentorder.domain;

import dao.StudentOrderStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentOrder {
   private LocalDateTime studentOrderDate; 
   private StudentOrderStatus studentOrderStatus;

    public LocalDateTime getStudentOrderDate() {
        return studentOrderDate;
    }

    public void setStudentOrderDate(LocalDateTime studentOrderDate) {
        this.studentOrderDate = studentOrderDate;
    }

    public StudentOrderStatus getStudentOrderStatus() {
        return studentOrderStatus;
    }

    public void setStudentOrderStatus(StudentOrderStatus studentOrderStatus) {
        this.studentOrderStatus = studentOrderStatus;
    }
   private long studentOrderId;
   private Adult Husband;
   private Adult wife;
   private List<Child> children;
   private String marriageCertificateId;
   private RegisterOffice marriageOffice;
   private LocalDate marriageDate;

    public LocalDate getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(LocalDate marriageDate) {
        this.marriageDate = marriageDate;
    }

    public String getMarriageCertificateId() {
        return marriageCertificateId;
    }

    public void setMarriageCertificateId(String marriageCertificateId) {
        this.marriageCertificateId = marriageCertificateId;
    }

    public RegisterOffice getMarriageOffice() {
        return marriageOffice;
    }

    public void setMarriageOffice(RegisterOffice marriageOffice) {
        this.marriageOffice = marriageOffice;
    }

    public long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Adult getHusband() {
        return Husband;
    }

    public void setHusband(Adult Husband) {
        this.Husband = Husband;
    }

    public Adult getWife() {
        return wife;
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }
    
    public void addChild(Child child){
        if(children == null){
            children = new ArrayList<>(5);
        }
        children.add(child);
    }

    public List<Child> getChildren() {
        return children;
    }

   
}
