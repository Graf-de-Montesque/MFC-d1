package pkg3iteration.studentorder.validator;

import exception.CityRegisterException;
import pkg3iteration.studentorder.domain.AnswerRegister;
import pkg3iteration.studentorder.domain.StudentOrder;

public class CityRegisterValidator {
    
    public String hostName;
    protected int port;
    private String login;
    
    private CityRegisterChecker personChecker;
    
    public CityRegisterValidator(){
        personChecker = new FakeCityRegisterChecker();
    }
    
    public AnswerRegister checkCityRegister(StudentOrder so){
        //класс для обращения в ГРН
        try{
            personChecker.checkPerson(so.getHusband());
            personChecker.checkPerson(so.getWife());
            personChecker.checkPerson(so.getChild());
        } catch(CityRegisterException ex) {
         ex.printStackTrace();
        }
        
               
        AnswerRegister ans = new AnswerRegister();
        return ans;  
    }
}
