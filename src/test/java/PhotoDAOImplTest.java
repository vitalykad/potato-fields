import org.funkntrash.potato.domain.PhotoDAO;
import org.funkntrash.potato.domain.PhotoDAOImpl;
import org.funkntrash.potato.models.PhotosEntity;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

import static org.testng.Assert.assertEquals;

/**
 * Created by funkntrash on 21.04.16.
 */
public class PhotoDAOImplTest {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/potato_fields";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123456";

    public PhotoDAO photoDAO = new PhotoDAOImpl();

    public int getMaxSol(){

        Connection conn = null;
        Statement stmt = null;

        int max_sol = 0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT sol FROM photos where sol in (select max(sol) from photos)";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            rs.next();

            max_sol = rs.getInt("sol");

            rs.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return max_sol;

    }

    @BeforeTest
    public void Before(){

        System.out.println("Блок инициализации данных");

        // JDBC driver name and database URL

        Connection conn = null;
        Statement stmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO photos (sol,url)" +
                    "VALUES (7777, 'testng1.jpg')";

            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{

                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    @Test
    public void test1getMaxSolPhoto() {

        int max_sol = photoDAO.getMaxSolPhoto().getSol();

        assertEquals(max_sol, 7777);

    }

    @Test
    public void test2AddPhoto() {


        PhotosEntity photo = new PhotosEntity();

        photo.setSol(7778);
        photo.setUrl("testng2.jpg");

        photoDAO.addPhoto(photo);

        assertEquals(this.getMaxSol(),7778);


    }


    @AfterTest
    public void After(){

        System.out.println("Блок очистки данных");

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "DELETE FROM photos " +
                    "WHERE url like '%testng%'";
            stmt.executeUpdate(sql);


        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try


    }
}