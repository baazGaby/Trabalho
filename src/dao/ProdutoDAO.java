/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Produto;

/**
 *
 * @author gabym
 */
public class ProdutoDAO {
    
    private Connection connection;
    
    public ProdutoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Produto produto){
        String consulta = "INSERT INTO usuario(nome,cor,tipo,material) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement (consulta);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCor());
            stmt.setString(3, produto.getTipo());
            stmt.setString(4, produto.getMaterial());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
     public List<Produto> recuperar()
    { 
        List<Produto> produtos = new ArrayList<>();
        String consulta ="SELECT * FROM USUARIO" ;
        //ResultSet é uma classe que é utilizada para  armazenar o retorno das consultas
        ResultSet  rs= null; // Armazena o retorno da cosulta
        
        try{
         PreparedStatement stmt = connection.prepareStatement(consulta);
         rs = stmt.executeQuery();// Armazena o retorno da cosulta
         while(rs.next()) //retorna todos os registros do banco
         {
             Produto produto = new Produto();
             produto.setId(rs.getLong("id"));
             produto.setNome(rs.getString("nome"));
             produto.setCor(rs.getString("cor"));
             produto.setMaterial(rs.getString("material"));
             produto.setTipo(rs.getString("categoria"));
             produtos.add(produto);
         }   
         }catch (SQLException u) { 
            JOptionPane.showMessageDialog(null,"Erro ao recuperar dados " + u );
            throw new RuntimeException(u);
        }
         return produtos;
    
    }
}
