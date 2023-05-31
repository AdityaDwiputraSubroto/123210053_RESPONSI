/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.table.DefaultTableModel;
import models.MovieModel;
import views.MovieView;
import java.sql.*;

/**
 *
 * @author Lab Informatika
 */
public class MovieController {
    private MovieView movieView;
    private MovieModel movieModel;
    
    public MovieController(MovieView movieView){
        this.movieView = movieView;
        movieModel = new MovieModel();
    }
    
    public void addData(String judul, String alur, String penokohan, String akting){
        try{
            //double nilai = (alur+penokohan+akting)/3;
            double nilai = 50;
            //movieModel = new MovieModel();
            movieModel.addData(judul, alur, penokohan, akting, nilai);
        }catch(SQLException e){
            System.out.println("sql exception error add Data"+e.getMessage());
            movieView.showMessage("Error addData"+e.getMessage());
        }catch(Exception e){
            System.out.println("sql exception error add Data"+e.getMessage());
        }
    }
    
    public void updateData(String judul, String alur, String penokohan, String akting){
        try{
            //double nilai = (alur+penokohan+akting)/3;
            double nilai = 50;
            //movieModel = new MovieModel();
            movieModel.updateData(judul, alur, penokohan, akting, nilai);
        }catch(SQLException e){
            System.out.println("sql exception error add Data"+e.getMessage());
            movieView.showMessage("Error addData"+e.getMessage());
        }catch(Exception e){
            System.out.println("sql exception error add Data"+e.getMessage());
        }
    }
    
    public void getTableModel(){
        try{
            //movieModel = new MovieModel();
          
            DefaultTableModel tableModel = movieModel.getTableModel();
            movieView.setTableModel(tableModel);
             System.out.println("Halo");
        }catch(SQLException e){
            System.out.println("Error get tabel "+e.getMessage());
              movieView.showMessage("Error show Table"+e.getMessage());
        }
    }
}
