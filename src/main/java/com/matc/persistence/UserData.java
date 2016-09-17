package com.matc.persistence;
import java.sql.DriverManager;
import com.matc.entity.User;
import org.apache.log4j.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.lang.Object;
import java.text.*;
import java.util.Date;


/**
 * Access users in the user table.
 *
 * @author pwaite
 */
@SuppressWarnings("ALL")
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());

   private Properties properties;

   // private constructor prevents instantiating this class anywhere else
   public UserData() {
       //loadProperties();
  }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            database.connect();
            connection = database.getConnection();

            if (connection != null) {
                logger.info("Connected");
            }
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.info("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.info("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }

   //TODO add a method or methods to return a single user based on search criteria



public List<User> searchUserByLastName(String lastName) {
    List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        Statement statement = null;
        ResultSet results = null;
        String queryString = "SELECT * FROM users WHERE last_name like '"
            + lastName + "%'"
            + ";";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            database.connect();
            connection = database.getConnection();

            if (connection != null) {
                logger.info("Connected");
            }
            Statement selectStatement = connection.createStatement();
             results = selectStatement.executeQuery(queryString);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();

        }  catch (SQLException sqlException) {
            logger.info("Error in connecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            logger.info("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (results != null) {
                    results.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                logger.info("Error in connecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                logger.info("General Error");
                exception.printStackTrace();
            }
        }
    return users;
}


    private User createUserFromResults(ResultSet results) throws SQLException {

        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));

        String dobString = results.getString("date_of_birth");

        String[] dobParts = dobString.split("-");
        int year = Integer.valueOf(dobParts[0]);
        int month = Integer.valueOf(dobParts[1]);
        int dateOfBirth = Integer.valueOf(dobParts[2]);

        LocalDate birthday = LocalDate.of(year, month, dateOfBirth);
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthday, today);

        user.setUserAge(String.valueOf(age.getYears()));

        // TODO map the remaining fields
        return user;
    }

}
