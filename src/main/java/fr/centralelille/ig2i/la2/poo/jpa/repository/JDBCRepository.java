package fr.centralelille.ig2i.la2.poo.jpa.repository;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCRepository {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306/fdourlens";

    //  Database credentials
    static final String USER = "fdourlens";
    static final String PASS = "fdourlens";

    public List<String> getSubordonnedMedecinIdsJDBC(String idMedecin) {
        Connection conn = null;
        Statement stmt = null;
        List<String> medecinsIds = new ArrayList<>();
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mariadb.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "select m.* from service s " +
                    "inner join medecin m on s.id = m.id_service " +
                    "where s.chef_id = " + idMedecin + " " +
                    "and m.id != " + idMedecin;
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                medecinsIds.add(rs.getString("id"));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
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
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return medecinsIds;
    }
}
