package pkg3iteration.studentorder;

import dao.DictionaryDaoImpl;
import dao.StudentOrderDaoImpl;
import dao.StudentOrderDao;
import exception.DaoException;
import java.time.LocalDate;
import java.sql.*;
import java.time.Month;
import java.util.List;
import pkg3iteration.studentorder.domain.Address;
import pkg3iteration.studentorder.domain.Adult;
import pkg3iteration.studentorder.domain.Child;
import pkg3iteration.studentorder.domain.CountryArea;
import pkg3iteration.studentorder.domain.PassportOffice;
import pkg3iteration.studentorder.domain.RegisterOffice;
import pkg3iteration.studentorder.domain.Street;
import pkg3iteration.studentorder.domain.StudentOrder;
import pkg3iteration.studentorder.domain.University;

public class SaveStudentOrder {
    
    public static void main(String[] args) throws DaoException{
        
//    List<Street> d = new DictionaryDaoImpl().findStreets("Про");
//        for(Street s : d) {
//             System.out.println(s.getStreetName()+ "\n");
//        }
//    List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
//        for(PassportOffice p: po){
//            System.out.println(p.getOfficeName()+ "\n");
//        }
//    List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
//        for(RegisterOffice r: ro){
//            System.out.println(r.getOfficeName()+ "\n");
//        }
        
//    List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
//        for(CountryArea c: ca1){
//            System.out.println(c.getArea_id() + ":" + c.getArea_name() + "\n");
//        }
//    List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
//        for(CountryArea c: ca2){
//            System.out.println(c.getArea_id() + ":" + c.getArea_name() + "\n");
//        }
//    List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
//        for(CountryArea c: ca3){
//            System.out.println(c.getArea_id() + ":" + c.getArea_name() + "\n");
//        }
//    List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
//        for(CountryArea c: ca4){
//            System.out.println(c.getArea_id() + ":" + c.getArea_name() + "\n");
//        }
            StudentOrder s = buildStudentOrder(10);
            StudentOrderDao dao = new StudentOrderDaoImpl();
            Long id = dao.saveStudentOrder(s);
//            dao.saveStudentOrder(s);
            System.out.println(id);
            dao.getStudentOrders();
            
            List<StudentOrder> soList = dao.getStudentOrders();
            for(StudentOrder so : soList) {
                System.out.println(so.getStudentOrderId());
            }
//    long ans = saveStudentOrder(so);
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
        RegisterOffice ro = new RegisterOffice(1L,"","");
        so.setMarriageOffice(ro);
        Street street = new Street(1L, "first street");
        Address address = new Address("195000", street, "12", "", "142");
        so.setMarriageCertificateId("" + (123546 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        
        Adult husband = new Adult("Vlad", "Ivanovich", "Pushka", LocalDate.of(1997,8,24));
        husband.setPassportSeria("" +(1000 + id));
        husband.setPassportNumber("" + (100000+id));
        husband.setPassportDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1 = new PassportOffice(1L, "","");
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        University u1 = new University(15L, "Baumanka");
        husband.setUniversity(u1);
        
        
        Adult wife = new Adult("Marina", "Pavlovna", "Pushka", LocalDate.of(1997,8,24));
        wife.setPassportSeria("" +(2000 + id));
        wife.setPassportNumber("" + (200000+id));
        wife.setPassportDate(LocalDate.of(2015, 5, 10));
        PassportOffice po2 = new PassportOffice(2L, "","");
        wife.setIssueDepartment(po2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        University u2 = new University(15L, "Baumanka");
        wife.setUniversity(u2);

        Child child1 = new Child("Sveta", "Ruslanovna", "Kukushka", LocalDate.of(1999,4,21));
        child1.setCertificateNumber(""+(300000 + id));
        child1.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro2 = new RegisterOffice(2L,"","");
        child1.setIssueDepartment(ro2);
        child1.setAddress(address);
        
        
        Child child2 = new Child("Pipka", "Ruslanovna", "Smackthet", LocalDate.of(1999,4,21));
        child2.setCertificateNumber(""+(400000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro3 = new RegisterOffice(3L,"","");
        child2.setIssueDepartment(ro3);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
        /*удалить */
        System.out.println("Заявка создана");


        return so;

    }
}
