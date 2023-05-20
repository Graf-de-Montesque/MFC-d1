package dao;

import exception.DaoException;
import pkg3iteration.studentorder.domain.StudentOrder;

public interface StudentOrderDao {
    Long saveStudentOrder(StudentOrder so) throws DaoException;
}
