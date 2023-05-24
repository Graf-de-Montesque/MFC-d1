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
        String sql = "INSERT INTO public.jc_student_order(" +
"	student_order_status, student_order_date, h_sur_name, h_given_name, h_patronymic, h_date_of_birth, h_passport_seria, h_passport_number, h_passport_date, h_passport_office_id, h_post_index, h_street_code, h_building, h_extension, h_apartment, w_sur_name, w_given_name, w_patronymic, w_date_of_birth, w_passport_seria, w_passport_number, w_passport_date, w_passport_office_id, w_post_index, w_street_code, w_building, w_extension, w_apartment, certificate_id, register_office_id, marriage_date)" +
"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql, new String[]{"student_order_id"})){
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
        } catch(SQLException ex){
        throw new DaoException(ex); 
        }
        System.out.println("данные получены\nсоединение закрыто\nрезультаты:");
        return result;
    }

    private void setParamsForAdult(final PreparedStatement stmt, int start, Adult adult) throws SQLException {
        stmt.setString(start, adult.getSurName());
        stmt.setString(start + 1, adult.getGivenName());
        stmt.setString(start + 2, adult.getPatronymic());
        stmt.setDate(start + 3, java.sql.Date.valueOf(adult.getDateOfBirth()));
        stmt.setString(start + 4, adult.getPassportSeria());
        stmt.setString(start + 5, adult.getPassportNumber());
        stmt.setDate(start + 6, java.sql.Date.valueOf(adult.getPassportDate()));
        stmt.setLong(start + 7, adult.getIssueDepartment().getOfficeId());
        Address h_address = adult.getAddress();
        stmt.setString(start + 8, h_address.getPostCode());
        stmt.setLong(start + 9, h_address.getStreet().getStreetCode());
        stmt.setString(start + 10, h_address.getBuilding());
        stmt.setString(start + 11, h_address.getExtension());
        stmt.setString(start + 12, h_address.getApartment());
    }
}

