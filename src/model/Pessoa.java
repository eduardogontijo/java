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
public class Pessoa {

    public Pessoa(){
    
    }
    
    public Pessoa(int id, String nome, String cpf, String telefone, String endereco, String tipo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipo = tipo;
    }
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String tipo;

    public void Create(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaria","root","");
            String sql = "Insert into pessoa " + "(Nome, CPF, Telefone, Endereco, Tipo) " + "VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.nome);
            stmt.setString(2, this.cpf);
            stmt.setString(3, this.telefone);
            stmt.setString(4, this.endereco);
            stmt.setString(5, this.tipo);
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Incluido");
            //this.PreencherTabela();

            }
        catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
    }
    
    public void Update(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaria","root","");
                String sql = "Update pessoa set Nome = ?, CPF = ?, Telefone = ?, Endereco = ?, Tipo = ?  WHERE id = ? ";
                PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, this.nome);
                    stmt.setString(2, this.cpf);
                    stmt.setString(3, this.telefone);
                    stmt.setString(4, this.endereco);
                    stmt.setString(5, this.tipo);
                    stmt.setDouble(6, this.id);
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
            String sql = "DELETE FROM pessoa WHERE id = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, this.id);
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Excluido com sucesso!");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
    }

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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
