package pkg3iteration.studentorder;

import java.time.LocalDate;
import java.time.Month;
import pkg3iteration.studentorder.domain.Adult;
import pkg3iteration.studentorder.domain.Child;
import pkg3iteration.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    
    public static void main(String[] args) {
       StudentOrder so = new StudentOrder(); 
        
       long ans = saveStudentOrder(so);
    }
    //нестандартный функционал по возврату идентификатора записи
    static long saveStudentOrder(StudentOrder studentOrder){
        long answer;
        answer = 199;
        
        System.out.println("saveStudentOrder");
        return answer;
    }
    public static StudentOrder buildStudentOrder(long id){
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        
        Adult husband = new Adult("Vlad", "Ivanovich", "Pushka", LocalDate.of(1997,8,24));
        husband.setPassportSeria("" +(1000 + id));
        husband.setPassportNumber("" + (100000+id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment("Отдел полиции № " +id);
        husband.setStudentId("" + (100000 + id));
        
        Adult wife = new Adult("Marina", "Pavlovna", "Pushka", LocalDate.of(1997,8,24));
        wife.setPassportSeria("" +(2000 + id));
        wife.setPassportNumber("" + (200000+id));
        wife.setIssueDate(LocalDate.of(2015, 5, 10));
        wife.setIssueDepartment("Отдел полиции № " +id);
        wife.setStudentId("" + (200000 + id));
        
        
        Child child1 = new Child("MSveta", "Ruslanovna", "Kukushka", LocalDate.of(1999,4,21));
        child1.setCertificateNumber(""+(300000 + id));
        child1.setIssueDate(LocalDate.of(2018, 7, 19));
        child1.setIssueDepartment("Отдел ЗАГС №" + id);
        
        Child child2 = new Child("Pipka", "Ruslanovna", "Smackthet", LocalDate.of(1999,4,21));
        child2.setCertificateNumber(""+(400000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        child2.setIssueDepartment("Отдел ЗАГС №" + id);
        
        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
        /*удалить */
        System.out.println("Заявка создана");
        
        
        return so;
        
    }
}
