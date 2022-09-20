/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern;

public class SimpleProduct extends AbstractProduct 
{       
    protected String brand;       
    
    public SimpleProduct(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;   
    }
/** GET and SET */ 

}

