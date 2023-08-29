package dao;

import exception.DaoException;
import java.util.List;
import pkg3iteration.studentorder.domain.CountryArea;
import pkg3iteration.studentorder.domain.PassportOffice;
import pkg3iteration.studentorder.domain.RegisterOffice;
import pkg3iteration.studentorder.domain.Street;

public interface DictionaryDao {
     List<Street> findStreets(String pattern) throws DaoException;
     List<PassportOffice> findPassportOffices(String areaId) throws DaoException;
     List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException;
     List<CountryArea> findAreas(String areaId) throws DaoException;
     
}
