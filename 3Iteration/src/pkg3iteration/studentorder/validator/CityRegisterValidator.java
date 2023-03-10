package pkg3iteration.studentorder.validator;

import exception.CityRegisterException;
import java.util.Iterator;
import pkg3iteration.studentorder.domain.AnswerRegister;
import pkg3iteration.studentorder.domain.Child;
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
            for (int i=0; i<so.getChildren().size(); i++){
               personChecker.checkPerson(so.getChildren().get(i)); 
            }
            // через итератор
            for(Iterator<Child> it = so.getChildren().iterator(); it.hasNext();){
                Child child = it.next();
                personChecker.checkPerson(child);
            }
            // foreach
            for(Child child : so.getChildren()){
                personChecker.checkPerson(child);
            }
            
        } catch(CityRegisterException ex) {
         ex.printStackTrace();
        }
        
               
        AnswerRegister ans = new AnswerRegister();
        return ans;  
    }
}
