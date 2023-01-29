
package pkg3iteration.studentorder.validator;

import exception.CityRegisterException;
import pkg3iteration.studentorder.domain.CityRegisterCheckerResponse;
import pkg3iteration.studentorder.domain.Person;


public class RealCityRegisterChecker implements CityRegisterChecker{
    @Override
    public CityRegisterCheckerResponse checkPerson(Person person) 
            throws CityRegisterException{
                
        return null;
    }
}
