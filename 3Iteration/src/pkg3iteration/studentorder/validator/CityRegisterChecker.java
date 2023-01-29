
package pkg3iteration.studentorder.validator;

import exception.CityRegisterException;
import pkg3iteration.studentorder.domain.CityRegisterCheckerResponse;
import pkg3iteration.studentorder.domain.Person;


public interface CityRegisterChecker {
    CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException;
}
