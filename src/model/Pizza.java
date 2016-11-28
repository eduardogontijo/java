/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardo.pereira
 */
public class Pizza extends Produto{
    private String tamanho;
    private String ingredientes;

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }
  
    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the ingredientes
     */
    public String getIngredientes() {
        return ingredientes;
    }

    /**
     * @param ingredientes the ingredientes to set
     */
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    @Override
      public void Create(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario","root","");
            String sql = "Insert into produto " + "(nome, preco, tamanho, ingredientes) " + "VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.getNome());
            stmt.setDouble(2, this.getPreco());
            stmt.setString(3, this.getTamanho());
            stmt.setString(4, this.getIngredientes());
     
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Incluido");
            }
        catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
    }
    
    @Override
    public void Update(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario","root","");
            String sql = "Update produto set nome = ?, preco = ?, tamanho = ?, ingredientes = ? WHERE id = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, this.getNome());
                stmt.setDouble(2, this.getPreco());
                stmt.setString(3, this.getTamanho());
                stmt.setString(4, this.getIngredientes());
                stmt.setInt(5, this.getId());
                stmt.execute();
            JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
//                     this.PreencherTabela();
            }
         catch(Exception ex){
                 JOptionPane.showMessageDialog(null,ex.getMessage());
            }
     }
}
