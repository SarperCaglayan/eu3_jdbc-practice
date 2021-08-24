package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listofmap_example {
    String dbUrl = "jdbc:oracle:thin:@18.233.147.177:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void MetaDataExample() throws SQLException {
        //create connection
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from regions");

        //get the resultset object metadata
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        //list for keeping all rows a map
        List<Map<String,Object>> queryData = new ArrayList<>();

        Map<String,Object> row1 = new HashMap<>();
        row1.put("first_name","Steven");
        row1.put("last_name","King");
        row1.put("salary",24000);
        row1.put("job_id","AD_PRES");

        System.out.println(row1.toString());

        Map<String,Object> row2 = new HashMap<>();
        row2.put("first_name","Neena");
        row2.put("last_name","Kochhar");
        row2.put("salary",17000);
        row2.put("job_id","AD_VP");
        System.out.println(row2.toString());

        System.out.println(row2.get("salary"));

        //adding rows to my list
        queryData.add(row1);
        queryData.add(row2);

        //get the steven last name directly from the list
        System.out.println(queryData.get(0).get("last_name"));
        System.out.println(queryData.get(1).get("last_name"));
        System.out.println(queryData.get(1).get("job_id"));
        System.out.println("queryData.get(0).get(\"salary\") = " + queryData.get(0).get("salary"));


        //close all connections
        resultSet.close();
        statement.close();
        connection.close();
    }


}