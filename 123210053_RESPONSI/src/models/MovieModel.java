/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

//import com.sun.jdi.connect.spi.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author Lab Informatika
 */
public class MovieModel {

    private DefaultTableModel tableModel;
    private Connection connection;
    private Connector connector;
    private Object[] column = {"judul", "Alur", "Penokohan", "Akting", "Nilai"};

    public MovieModel() {

    }

    public DefaultTableModel getTableModel() throws SQLException {
        try {
            getTableDB();
            return tableModel;
        } catch (SQLException e) {
            System.out.println("Error get table model" + e.getMessage());
            throw new SQLException(e);
        }

    }

    public void updateData(String judul, String alur, String penokohan, String akting, Double nilai) throws SQLException{
        try {
            connector = new Connector();
            connection = connector.getConnection();

            String query = "UPDATE movie SET alur = ?, penokohan = ?, akting = ?, nilai = ? WHERE judul = ?";
            PreparedStatement statement = connection.prepareStatement(query);
           
            statement.setString(1, alur);
            statement.setString(2, penokohan);
            statement.setString(3, akting);
            statement.setDouble(4, nilai);
            statement.setString(5, judul);
            
            statement.execute();
          
            connection.close();
            statement.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Error Update DB " + e.getMessage());
            throw new SQLException("Update DB Error : " + e.getMessage());

        }

    }
    
    public void addData(String judul, String alur, String penokohan, String akting, Double nilai) throws SQLException {
        try {
            connector = new Connector();
            connection = connector.getConnection();

            String query = "INSERT INTO `movie` (`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES (?, ? , ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, judul);
            statement.setString(2, alur);
            statement.setString(3, penokohan);
            statement.setString(4, akting);
            statement.setDouble(5, nilai);
            
            statement.execute();
          
            connection.close();
            statement.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Error add tabel DB " + e.getMessage());
            throw new SQLException("Add table to DB Error : " + e.getMessage());

        }

    }

    public void getTableDB() throws SQLException {
        try {
            connector = new Connector();
            connection = connector.getConnection();

            String query = "SELECT judul, alur, penokohan, akting, nilai FROM movie;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (Object columnName : column) {
                tableModel.addColumn(columnName);
            }

            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            resultSet.close();
            connection.close();
            statement.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Error get tabel DB " + e.getMessage());
            throw new SQLException("Get table from DB Error : " + e.getMessage());

        }

    }

}
