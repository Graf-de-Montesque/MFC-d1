package dao;

import config.Config;
import exception.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;
import pkg3iteration.studentorder.domain.CountryArea;
import pkg3iteration.studentorder.domain.PassportOffice;
import pkg3iteration.studentorder.domain.RegisterOffice;
import pkg3iteration.studentorder.domain.Street;

public class DictionaryDaoImpl implements DictionaryDao
{
    private Connection getConnection() throws SQLException{
           Connection conn = DriverManager.getConnection(
                   Config.getProperty(Config.DB_URL),
                   Config.getProperty(Config.DB_LOGIN),
                   Config.getProperty(Config.DB_PASSWORD));
                   System.out.println("Соединение установлено");
           return conn;
    }       
           
    @Override
    public List<Street> findStreets(String pattern) throws DaoException {
      String sql = "SELECT street_code, street_name FROM jc_street WHERE UPPER (street_name) LIKE UPPER(?)";
        List<Street> result = new LinkedList<>();
        try (Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setString(1, "%" + pattern + "%");
        
        ResultSet rs = stmt.executeQuery();
          while(rs.next()){
           Street str = new Street(rs.getLong("street_code"),rs.getString("street_name")); 
           result.add(str);
          }
       
        } catch(SQLException ex){
        throw new DaoException(ex); 
        }
        System.out.println("данные получены\nсоединение закрыто\nрезультаты:");
        return result; 
        
    }

    @Override
    public List<PassportOffice> findPassportOffices(String areaId) throws DaoException {
    String sql = "SELECT * FROM jc_passport_office WHERE p_office_area_id = ?";
        List<PassportOffice> result = new LinkedList<>();
        try (Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setString(1, areaId);
        
        ResultSet rs = stmt.executeQuery();
          while(rs.next()){
           PassportOffice str = new PassportOffice(
                                    rs.getLong("p_office_id"),
                                    rs.getString("p_office_area_id"),
                                    rs.getString("p_office_name")); 
           result.add(str);
          }
       
        } catch(SQLException ex){
        throw new DaoException(ex); 
        }
        System.out.println("данные получены\n соединение закрыто\n результаты\n:");
        return result;
    }

    @Override
    public List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException {
    String sql1 = "SELECT * FROM jc_register_office WHERE r_office_area_id = ?";
        List<RegisterOffice> result = new LinkedList<>();
        try (Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql1)){
            stmt.setString(1, areaId);
        
        ResultSet rs = stmt.executeQuery();
          while(rs.next()){
           RegisterOffice str = new RegisterOffice(
                                    rs.getLong("r_office_id"),
                                    rs.getString("r_office_area_id"),
                                    rs.getString("r_office_name")); 
           result.add(str);
          }
       
        } catch(SQLException ex){
        throw new DaoException(ex); 
        }
        System.out.println("данные получены\n соединение закрыто\n результаты\n:");
        return result;
    }

    @Override
    public List<CountryArea> findAreas(String areaId) throws DaoException {
        String sql1 = "SELECT * FROM jc_country_struct WHERE area_id like ? and area_id <>?";
        List<CountryArea> result = new LinkedList<>();
        try (Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql1)){
            
            String param1 = buildParam(areaId);
            String param2 = areaId;
            
            stmt.setString(1, param1);
            stmt.setString(2, param2);
        
        ResultSet rs = stmt.executeQuery();
          while(rs.next()){
           CountryArea cA = new CountryArea(
                                    rs.getString("area_id"),
                                    rs.getString("area_name")); 
           result.add(cA);
          }
       
        } catch(SQLException ex){
        throw new DaoException(ex); 
        }
        //System.out.println("данные получены\n соединение закрыто\n результаты\n:");
        return result;
    }

    private String buildParam(String areaId) throws SQLException {
        if(areaId == null || areaId.trim().isEmpty()){
            return "__0000000000";
        } else if (areaId.endsWith("0000000000")){
           return areaId.substring(0, 2) + "___0000000";
        } else if (areaId.endsWith("0000000")){
           return areaId.substring(0,5) + "___0000";
        } else if (areaId.endsWith("0000")){
           return areaId.substring(0,8) + "____";
        } 
        throw new SQLException("Invalid parametr areaId : "+ areaId);
    }
}
