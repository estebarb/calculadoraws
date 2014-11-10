/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicioweb;

import calculadora.Calculadora;
import java.io.Serializable;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.Stack;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author esteban
 */
@WebService(serviceName = "CalculadoraServicio")
@SessionScoped
public class CalculadoraServicio implements Serializable{

    public CalculadoraServicio() {
	calc = new Calculadora();
    }
    
    @SessionScoped
    protected Calculadora calc = new Calculadora();

    public Calculadora getCalc() {
	return calc;
    }

    public void setCalc(Calculadora calc) {
	this.calc = calc;
    }
    
    

    /**
     * Retorna el stack como un string.
     * @return 
     */
    @WebMethod(operationName = "StackToString")
    public String StackToString() {
	return calc.toString();
    }

    /**
     * Devuelve el stack actual.
     *
     * @return
     */
    @WebMethod(operationName = "getStack")
    public Stack<Double> Stack() {
	return calc.getStack();
    }

    /**
     * Devuelve la cantidad de elementos en el stack
     *
     * @return
     */
    @WebMethod(operationName = "getSize")
    public int getSize() {
	return calc.getStackSize();
    }

    /**
     * Agrega un número a la pilas
     *
     * @param num
     * @return 
     */
    @WebMethod(operationName = "PushNumber")
    public boolean PushNumber(@WebParam(name = "num") double num) {
	return calc.PushNumber(num);
    }

    /**
     * Suma dos números en la pila y coloca el resultado en el tope.
     * @return 
     */
    @WebMethod(operationName = "add")
    public boolean add() {
	return calc.OpSum();
    }

    /**
     * Resta dos números en la pila y coloca el resultado en el tope.
     * @return 
     */
    @WebMethod(operationName = "sub")
    public boolean sub() {
	return calc.OpSub();
    }

    /**
     * Multiplica dos números en la pila y coloca el resultado en el tope.
     * @return 
     */
    @WebMethod(operationName = "mul")
    public boolean Multiply() {
	return calc.OpMul();
    }

    /**
     * Divide dos números en la pila y coloca el resultado en el tope.
     * @return 
     */
    @WebMethod(operationName = "div")
    public boolean div() {
	return calc.OpDiv();
    }

    /**
     * Saca residuo de dos números en la pila y coloca el resultado en el tope.
     * @return 
     */
    @WebMethod(operationName = "remainder")
    public boolean rem() {
	return calc.OpRem();
    }

    /**
     * Calcula la raiz cuadrada de un número y la coloca en la pila.
     * @return 
     */
    @WebMethod(operationName = "sqrt")
    public boolean sqrt() {
	return calc.OpSqrt();
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "ping")
    public boolean ping() {
	return true;
    }
}
