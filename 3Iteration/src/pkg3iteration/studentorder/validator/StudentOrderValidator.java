package pkg3iteration.studentorder.validator;

import java.util.LinkedList;
import java.util.List;
import pkg3iteration.studentorder.SaveStudentOrder;
import pkg3iteration.studentorder.domain.AnswerChildren;
import pkg3iteration.studentorder.domain.AnswerRegister;
import pkg3iteration.studentorder.domain.AnswerStudent;
import pkg3iteration.studentorder.domain.AnswerWedding;
import pkg3iteration.studentorder.mail.MailSender;
import pkg3iteration.studentorder.domain.StudentOrder;

public class StudentOrderValidator {
    
    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;
    
    // конструктор
    public StudentOrderValidator(){ 
        cityRegisterVal = new CityRegisterValidator();
//        weddingVal = new WeddingValidator();
//        studentVal = new StudentValidator();
//        childrenVal = new ChildrenValidator();
//        mailSender = new MailSender();
    }
    // основная функция
    // запуск проверок
    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    } // обобщающая функция проверки
    public void checkAll(){
    List <StudentOrder> soList = readStudentOrders();
//    for(int c = 0; c < soArray.length; c++){
//        checkOneOrder(soArray[c]);
//    }
    for(StudentOrder so:soList){
        checkOneOrder(so);
        }
    }
    //запускаем проверки
    public void checkOneOrder(StudentOrder so){
    AnswerRegister cityAnswer = checkCityRegister(so);
//    AnswerStudent studAns = checkStudent(so);
//    AnswerWedding wedAns = checkMarried(so);
//    AnswerChildren childAns = checkChildren(so);
//    sendMail(so);
    }

    // считывание заявки
    public List <StudentOrder> readStudentOrders(){ 
        //переменная для массива заявок
        List <StudentOrder> soList = new LinkedList<>();
        //создание 3 заявок
        for(int c = 0; c < 5; c++){
            StudentOrder so = SaveStudentOrder.buildStudentOrder(c);
            soList.add(so);
        }
        return soList;
    }    
    public AnswerRegister checkCityRegister(StudentOrder so){
        return cityRegisterVal.checkCityRegister(so);
    }   
     // проверка в ЗАГС
    public AnswerWedding checkMarried(StudentOrder so){
       return weddingVal.checkMarried(so);
    } 
    // проверка на наличие детей
    public AnswerChildren checkChildren(StudentOrder so){
        return childrenVal.checkChildren(so);
    } 
    // проверка на студентс
    public AnswerStudent checkStudent(StudentOrder so){
        return studentVal.checkStudent(so);
    } 
// отправка письма
    public void sendMail(StudentOrder so){
       mailSender.sendMail(so);
    }
}
