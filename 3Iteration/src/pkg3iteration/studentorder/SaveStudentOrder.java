package pkg3iteration.studentorder;

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
        Adult husband = new Adult("Vlad", "Ivanovich", "Pushka", null);
//        husband.setGivenName("Lev");
//        so.setHusband(husband);
        return so;
        
    }
}
