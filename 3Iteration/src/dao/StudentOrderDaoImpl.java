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
import pkg3iteration.studentorder.domain.StudentOrderStatus;

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
        String sql = "INSERT INTO public.jc_student_order(" +
"	student_order_status, student_order_date, h_sur_name, h_given_name, h_patronymic, h_date_of_birth, h_passport_seria, h_passport_number, h_passport_date, h_passport_office_id, h_post_index, h_street_code, h_building, h_extension, h_apartment, w_sur_name, w_given_name, w_patronymic, w_date_of_birth, w_passport_seria, w_passport_number, w_passport_date, w_passport_office_id, w_post_index, w_street_code, w_building, w_extension, w_apartment, certificate_id, register_office_id, marriage_date)" +
"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            //header
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            //Husband
            Adult husband = so.getHusband();
            stmt.setString(3, husband.getSurName());
            stmt.setString(4, husband.getGivenName());
            stmt.setString(5, husband.getPatronymic());
            stmt.setDate(6, java.sql.Date.valueOf(husband.getDateOfBirth()));
            stmt.setString(7, husband.getPassportSeria());
            stmt.setString(8, husband.getPassportNumber());
            stmt.setDate(9, java.sql.Date.valueOf(husband.getPassportDate()));
            stmt.setLong(10, husband.getIssueDepartment().getOfficeId());
            Address h_address = husband.getAddress();
            stmt.setString(11, h_address.getPostCode());
            stmt.setLong(12, h_address.getStreet().getStreetCode());
            stmt.setString(13, h_address.getBuilding());
            stmt.setString(14, h_address.getExtension());
            stmt.setString(15, h_address.getApartment());
            
            //wife
            Adult wife = so.getWife();
            stmt.setString(16, wife.getSurName());
            stmt.setString(17, wife.getGivenName());
            stmt.setString(18, wife.getPatronymic());
            stmt.setDate(19, java.sql.Date.valueOf(wife.getDateOfBirth()));
            stmt.setString(20, wife.getPassportSeria());
            stmt.setString(21, wife.getPassportNumber());
            stmt.setDate(22, java.sql.Date.valueOf(wife.getPassportDate()));
            stmt.setLong(23, wife.getIssueDepartment().getOfficeId());
            Address w_address = wife.getAddress();
            stmt.setString(24, w_address.getPostCode());
            stmt.setLong(25, w_address.getStreet().getStreetCode());
            stmt.setString(26, w_address.getBuilding());
            stmt.setString(27, w_address.getExtension());
            stmt.setString(28, w_address.getApartment());
            
            //Marriage
            stmt.setString(29, so.getMarriageCertificateId());
            stmt.setLong(30, so.getMarriageOffice().getOfficeId());
            stmt.setDate(31, java.sql.Date.valueOf(so.getMarriageDate()));
            
            stmt.executeUpdate();
        } catch(SQLException ex){
        throw new DaoException(ex); 
        }
        System.out.println("данные получены\nсоединение закрыто\nрезультаты:");
        return 0L;
    }
}
