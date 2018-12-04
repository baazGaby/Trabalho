/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author gabym
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try{
            //drive manager gerenciamento das conexoes
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho", "root", "Mizgamizga123");
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
}
