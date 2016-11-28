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
public class Produto {
    private int id;
    private String nome;
    private double preco;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
       public void Create(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaria","root","");
            String sql = "Insert into produto " + "(nome, preco) " + "VALUES (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.getNome());
            stmt.setDouble(2, this.getPreco());
     
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Incluido");

            }
        catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
    }
    
    public void Update(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaria","root","");
            String sql = "Update produto set nome = ?, preco = ? WHERE id = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, this.getNome());
                stmt.setDouble(2, this.getPreco());
                stmt.setInt(3, this.getId());
                stmt.execute();
            JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
//                     this.PreencherTabela();
            }
         catch(Exception ex){
                 JOptionPane.showMessageDialog(null,ex.getMessage());
            }
     }
    
    public void Delete(){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaria","root","");
            String sql = "DELETE FROM produto WHERE id = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, this.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Excluido com sucesso!");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
    }

}
