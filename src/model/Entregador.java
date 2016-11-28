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
public class Entregador extends Funcionario {

    public Double CalcularComissao(int entregas){
     return entregas*0.5;
    }
}
