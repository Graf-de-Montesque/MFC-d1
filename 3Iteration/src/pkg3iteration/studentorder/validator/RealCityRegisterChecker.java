
package pkg3iteration.studentorder.validator;

import exception.CityRegisterException;
import exception.TransportException;
import pkg3iteration.studentorder.domain.CityRegisterResponse;
import pkg3iteration.studentorder.domain.Person;


public class RealCityRegisterChecker implements CityRegisterChecker{
    @Override
    public CityRegisterResponse checkPerson(Person person) 
            throws CityRegisterException, TransportException {
                
        return null;
    }
}
