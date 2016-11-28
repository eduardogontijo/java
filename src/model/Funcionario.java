/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author eduardo.pereira
 */
public class Funcionario extends Pessoa {
    private double salarioFixo;
   
    /**
     * @return the salarioFixo
     */
    public double getSalarioFixo() {
        return salarioFixo;
    }

    /**
     * @param salarioFixo the salarioFixo to set
     */
    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

}
