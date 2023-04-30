package pkg3iteration.studentorder.validator;

import exception.CityRegisterException;
<<<<<<< HEAD
import pkg3iteration.studentorder.domain.Adult;
import pkg3iteration.studentorder.domain.CityRegisterCheckerResponse;
=======
import exception.TransportException;
import pkg3iteration.studentorder.domain.Adult;
import pkg3iteration.studentorder.domain.CityRegisterResponse;
>>>>>>> cc3facac232c6c92710c709d3187f3ce9875f5a1
import pkg3iteration.studentorder.domain.Person;

public class FakeCityRegisterChecker implements CityRegisterChecker {
     @Override
<<<<<<< HEAD
     public CityRegisterCheckerResponse checkPerson(Person person)
             throws CityRegisterException{
         CityRegisterCheckerResponse res = new CityRegisterCheckerResponse();
=======
     public CityRegisterResponse checkPerson(Person person)
             throws CityRegisterException, TransportException {
         CityRegisterResponse res = new CityRegisterResponse();
>>>>>>> cc3facac232c6c92710c709d3187f3ce9875f5a1
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
<<<<<<< HEAD
             CityRegisterException ex = new CityRegisterException("Fake ERROR");
=======
             CityRegisterException ex = new CityRegisterException("1212121");
            throw ex;
            }
            if(tempPS.equals("100003") || tempPS.equals("200003")){
             TransportException ex = new TransportException("TransportError"+ tempPS);
>>>>>>> cc3facac232c6c92710c709d3187f3ce9875f5a1
            throw ex;
            }
        }
         System.out.println(res);
        return res;
    }
}
