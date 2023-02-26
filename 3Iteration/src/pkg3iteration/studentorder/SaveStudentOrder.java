package pkg3iteration.studentorder;

import java.time.LocalDate;
import java.time.Month;
import pkg3iteration.studentorder.domain.Adult;
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
        
        so.setHusband(husband);
        so.setWife(wife);
        
        /*удалить */
        System.out.println("Заявка создана");
        
        
        return so;
        
    }
}
