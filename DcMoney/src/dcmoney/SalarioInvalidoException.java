/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcmoney;

/**
 *
 * @author Duarte
 */
public class SalarioInvalidoException extends Exception {
    public SalarioInvalidoException(String msg){
        super(msg);
    }
}
