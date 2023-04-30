package pkg3iteration.studentorder.validator;

import exception.CityRegisterException;
import exception.TransportException;
import java.util.Iterator;
import java.util.List;
import pkg3iteration.studentorder.domain.AnswerRegister;
import pkg3iteration.studentorder.domain.Child;
import pkg3iteration.studentorder.domain.CityRegisterResponse;
import pkg3iteration.studentorder.domain.Person;
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
        AnswerRegister ans = new AnswerRegister();
       
            ans.addItem(checkPerson(so.getHusband()));
            ans.addItem(checkPerson(so.getWife()));
            
            for(Child child : so.getChildren()){
                ans.addItem(checkPerson(child));
            }
         return ans;  
    }
    private AnswerCityRegisterItem checkPerson(Person person){
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
        try{
           CityRegisterResponse tmp = personChecker.checkPerson(person);
           status = tmp.isExisting() ? 
                    AnswerCityRegisterItem.CityStatus.YES:
                    AnswerCityRegisterItem.CityStatus.NO;
        } catch(CityRegisterException ex) {
         ex.printStackTrace(System.out);
         status = AnswerCityRegisterItem.CityStatus.ERROR;
         error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        }
          catch(TransportException ex) {
         ex.printStackTrace(System.out);
         status = AnswerCityRegisterItem.CityStatus.ERROR;
         error = new AnswerCityRegisterItem.CityError("No_grn", ex.getMessage());
        }
       AnswerCityRegisterItem ans = new AnswerCityRegisterItem(status, person, error);
        return ans;
    }
}