package dao;

import config.Config;
import exception.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import pkg3iteration.studentorder.domain.Address;
import pkg3iteration.studentorder.domain.Adult;
import pkg3iteration.studentorder.domain.Child;
import pkg3iteration.studentorder.domain.Person;
import pkg3iteration.studentorder.domain.Street;
import pkg3iteration.studentorder.domain.StudentOrder;

public class StudentOrderDaoImpl implements StudentOrderDao {
    private Connection getConnection() throws SQLException{
           Connection conn = DriverManager.getConnection(
                   Config.getProperty(Config.DB_URL),
                   Config.getProperty(Config.DB_LOGIN),
                   Config.getProperty(Config.DB_PASSWORD));
                   System.out.println("Соединение из метода StudentDao установлено");
           return conn;
    }
    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoException {
        Long result = -1L;
        String sqlInsertStudentOrder = "INSERT INTO public.jc_student_order(" +
"	student_order_status, student_order_date, h_sur_name, "
                + "h_given_name, h_patronymic, h_date_of_birth, "
                + "h_passport_seria, h_passport_number, h_passport_date, "
                + "h_passport_office_id, h_post_index, h_street_code, "
                + "h_building, h_extension, h_apartment, w_sur_name, "
                + "w_given_name, w_patronymic, w_date_of_birth, "
                + "w_passport_seria, w_passport_number, w_passport_date, "
                + "w_passport_office_id, w_post_index, w_street_code,"
                + " w_building, w_extension, w_apartment, certificate_id,"
                + " register_office_id, marriage_date)" +
"	VALUES (?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, "
                + "?, ?);";
        
        try (Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sqlInsertStudentOrder, new String[]{"student_order_id"})){
            
            con.setAutoCommit(false);
            try{
            
            //header
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            //Husband and wife
            setParamsForAdult(stmt, 3, so.getHusband());
            setParamsForAdult(stmt, 16, so.getWife());
            
            //Marriage
            stmt.setString(29, so.getMarriageCertificateId());
            stmt.setLong(30, so.getMarriageOffice().getOfficeId());
            stmt.setDate(31, java.sql.Date.valueOf(so.getMarriageDate()));
            
            stmt.executeUpdate();
            
            ResultSet gkRs = stmt.getGeneratedKeys();
            if (gkRs.next()){
                result = gkRs.getLong(1);
            }
            gkRs.close();
            
            saveChildren(con, so, result);
            
            con.commit();
            } catch(SQLException ex){
                con.rollback();
                throw ex;
            }
        } catch(SQLException ex){
        throw new DaoException(ex); 
        }
        System.out.println("данные получены\nсоединение закрыто\nрезультаты:");
        return result;
    }
    private void saveChildren(Connection con, StudentOrder so, Long soId) {
       String sqlInsertChild = "INSERT INTO public.jc_student_child("
                + "student_child_id, student_order_id, c_sur_name, "
                + "c_given_name, c_patronymic, c_date_of_birth, "
                + "c_certificate_id, c_certificate_date, "
                + "c_register_office_id, c_post_index, "
                + "c_street_code, c_building, c_extension, "
                + "c_apartment)"
                + "VALUES (?, ?, ?, "
                + "?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, "
                + "?, ?);";
        try (PreparedStatement stmt = con.prepareStatement(sqlInsertChild)){
            //пакетное исполнение
            int counter = 0;
            for (Child child: so.getChildren()){
               stmt.setLong(1, soId);
               setParamsForChild(stmt, child);
               stmt.addBatch();
               counter++;
               if (counter > 10000){
                   stmt.executeBatch();
               }
           }
           if (counter > 0) {
           stmt.executeBatch();
           }
        }catch(SQLException ex){
         
           
       }
    }

    private void setParamsForAdult(final PreparedStatement stmt, int start, Adult adult) throws SQLException {
        setParamsForPerson(stmt, start, adult);
        stmt.setString(start + 4, adult.getPassportSeria());
        stmt.setString(start + 5, adult.getPassportNumber());
        stmt.setDate(start + 6, java.sql.Date.valueOf(adult.getPassportDate()));
        stmt.setLong(start + 7, adult.getIssueDepartment().getOfficeId());
        setParamsForAddress(adult, stmt, start + 8);
    }

    private void setParamsForPerson(final PreparedStatement stmt, int start, Person person) throws SQLException {
        stmt.setString(start, person.getSurName());
        stmt.setString(start + 1, person.getGivenName());
        stmt.setString(start + 2, person.getPatronymic());
        stmt.setDate(start + 3, java.sql.Date.valueOf(person.getDateOfBirth()));
    }

    private void setParamsForAddress(Person person, final PreparedStatement stmt, int start) throws SQLException {
        Address adult = person.getAddress();
        stmt.setString(start, adult.getPostCode());
        stmt.setLong(start + 1, adult.getStreet().getStreetCode());
        stmt.setString(start + 2, adult.getBuilding());
        stmt.setString(start + 3, adult.getExtension());
        stmt.setString(start + 4, adult.getApartment());
    }

    private void setParamsForChild(PreparedStatement stmt, Child child) throws SQLException {
        setParamsForPerson(stmt, 2, child);
        stmt.setString(6, child.getCertificateNumber());
        stmt.setDate(7, java.sql.Date.valueOf(child.getIssueDate()));
        stmt.setLong(8, child.getIssueDepartment().getOfficeId());
        setParamsForAddress(child, stmt, 9);
    }

    
       
}

