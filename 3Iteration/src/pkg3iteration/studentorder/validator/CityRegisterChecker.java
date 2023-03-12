
package pkg3iteration.studentorder.validator;

import exception.CityRegisterException;
import pkg3iteration.studentorder.domain.CityRegisterResponse;
import pkg3iteration.studentorder.domain.Person;


public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person) throws CityRegisterException;
}
