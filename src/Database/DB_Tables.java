package Database;


import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by roije on 12/06/2016.
 */
public class DB_Tables
{
    public static void create()
    {
        String sqlString;
        Statement stmt;

        Connection conn = DB_Connector.getConnection();
        try
        {
            stmt = conn.createStatement();

            sqlString = "CREATE TABLE IF NOT EXISTS Users " +
                    "(userId TINYINT(4) NOT NULL AUTO_INCREMENT, " +
                    "firstName VARCHAR(50) NOT NULL," +
                    "lastName VARCHAR(50) NOT NULL, " +
                    "username VARCHAR(30) NOT NULL, " +
                    "passwordHash VARCHAR(60) NOT NULL, " +
                    "loginCount INTEGER NOT NULL DEFAULT 1, " +
                    "PRIMARY KEY (userId))";

            stmt.executeUpdate(sqlString);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }


        try
        {
            stmt = conn.createStatement();

            sqlString = "CREATE TABLE IF NOT EXISTS Jobs " +
                    "(jobId TINYINT(4) NOT NULL AUTO_INCREMENT, " +
                    "jobName VARCHAR(30) NOT NULL, " +
                    "regularPay DOUBLE NOT NULL, " +
                    "firstOverPay DOUBLE NOT NULL, " +
                    "secondOverPay DOUBLE NOT NULL, " +
                    "saturdayPay DOUBLE NOT NULL, " +
                    "sundayPay DOUBLE NOT NULL, " +
                    "totalPay DOUBLE NOT NULL DEFAULT 0, " +
                    "totalDays INTEGER NOT NULL DEFAULT 0, " +
                    "totalHours INTEGER NOT NULL DEFAULT 0, " +
                    "userId TINYINT NOT NULL," +
                    "FOREIGN KEY (userId) REFERENCES Users(userId), " +
                    "PRIMARY KEY (jobId))";

            stmt.executeUpdate(sqlString);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        try
        {
            stmt = conn.createStatement();

            sqlString = "CREATE TABLE IF NOT EXISTS Days " +
                    "(dayId TINYINT(4) NOT NULL AUTO_INCREMENT, " +
                    "dayName VARCHAR(13) NOT NULL, " +
                    "dayDate VARCHAR(14) NOT NULL, " +
                    "totalHours INTEGER NOT NULL, " +
                    "hoursReg INTEGER NOT NULL, " +
                    "firstOver INTEGER NOT NULL, " +
                    "secondOver INTEGER NOT NULL, " +
                    "saturday INTEGER NOT NULL, " +
                    "sunday INTEGER NOT NULL, " +
                    "totalPay DOUBLE NOT NULL, " +
                    "jobId TINYINT(4) NOT NULL, " +
                    "FOREIGN KEY (jobId) REFERENCES Jobs(jobId), " +
                    "PRIMARY KEY (dayId, dayDate))";

            stmt.executeUpdate(sqlString);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
