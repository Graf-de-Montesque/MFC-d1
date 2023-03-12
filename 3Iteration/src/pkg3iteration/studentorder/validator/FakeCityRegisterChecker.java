package pkg3iteration.studentorder.validator;

import exception.CityRegisterException;
import pkg3iteration.studentorder.domain.Adult;
import pkg3iteration.studentorder.domain.CityRegisterResponse;
import pkg3iteration.studentorder.domain.Person;

public class FakeCityRegisterChecker implements CityRegisterChecker {
     @Override
     public CityRegisterResponse checkPerson(Person person)
             throws CityRegisterException{
         CityRegisterResponse res = new CityRegisterResponse();
        if (person instanceof Adult){
            System.out.println("check Person Run");
            Adult temp = (Adult)person;
            String tempPS = temp.getPassportNumber();
            
            if(tempPS.equals("100000") || tempPS.equals("200000")){
             res.setExisting(true);
             res.setTemporal(false);
            }
            if(tempPS.equals("100001") || tempPS.equals("200001")){
             res.setExisting(false);
            }
            if(tempPS.equals("100002") || tempPS.equals("200002")){
             CityRegisterException ex = new CityRegisterException("Fake ERROR");
            throw ex;
            }
        }
         System.out.println(res);
        return res;
    }
}
