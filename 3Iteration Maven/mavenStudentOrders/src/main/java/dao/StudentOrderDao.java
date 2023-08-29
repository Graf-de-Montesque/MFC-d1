package dao;

import exception.DaoException;
import java.util.List;
import pkg3iteration.studentorder.domain.StudentOrder;

public interface StudentOrderDao {
    Long saveStudentOrder(StudentOrder so) throws DaoException;
    List<StudentOrder> getStudentOrders() throws DaoException;
}
