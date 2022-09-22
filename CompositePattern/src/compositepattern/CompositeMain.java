/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern;

import java.util.Random;

/**
 *
 * @author diego
 */
public class CompositeMain {

    private final Random random = new Random();
    private SimpleProduct ram4gb;
    private SimpleProduct ram8gb;
    private SimpleProduct disk500gb;
    private SimpleProduct disk1tb;
    private SimpleProduct cpuAMD;
    private SimpleProduct cpuIntel;
    private SimpleProduct smallCabinete;
    private SimpleProduct bigCabinete;
    private SimpleProduct monitor20inch;
    private SimpleProduct monitor30inch;
    private SimpleProduct simpleMouse;
    private SimpleProduct gammerMouse;
    private SimpleProduct descuento;
    
    private CompositeProduct gammerPC;
    private CompositeProduct homePC;
    private CompositeProduct pc2x1;


    private void buildProducts() {
        //Construcción de productos simples
        ram4gb = new SimpleProduct("Memoria RAM 4GB", 750, "KingStone",0.13,1);
        ram8gb = new SimpleProduct("Memoria RAM 8GB", 1000, "KingStone",0.13,1);
        disk500gb = new SimpleProduct("Disco Duro 500GB", 1500, "ACME",0.13,1);
        disk1tb = new SimpleProduct("Disco Duro 1TB", 2000, "ACME",0.08,1);  
        cpuAMD = new SimpleProduct("AMD phenon", 4000, "AMD",0.13,1);       
        cpuIntel = new SimpleProduct("Intel i7", 4500, "Intel",0.13,1);    
        smallCabinete = new SimpleProduct("Gabinete Pequeï¿½o", 2000, "ExCom",0.04,1); 
        bigCabinete = new SimpleProduct("Gabinete Grande", 2200, "ExCom",0.08,1); 
        monitor20inch = new SimpleProduct("Monitor 20'", 1500, "HP",0.04,1);
        monitor30inch = new SimpleProduct("Monitor 30'", 2000, "HP",0,1);
        simpleMouse = new SimpleProduct("Raton Simple", 150, "Genius",0.04,1);
        gammerMouse = new SimpleProduct("Raton Gammer", 750, "Alien",0.13,1);
        descuento = new SimpleProduct("Descuento", -100, "Descuento $100", 0, 1);

        //Computadora para Gammer que incluye 8gb de ram,disco de 1tb,procesador Intel i7          
        //Gabinete grande, monitor de 30' y un mouse gammer.
        gammerPC = new CompositeProduct("Gammer PC",0.08);   
        gammerPC.addProduct(ram8gb);   
        gammerPC.addProduct(ram4gb);   
        gammerPC.addProduct(monitor30inch);   
        gammerPC.addProduct(gammerMouse);   
        //gammerPC.addProduct(monitor30inch);   
        //gammerPC.addProduct(gammerMouse);
        
        //Computadora para Casa que incluye 4gb de ram,disco de 500gb, procesador AMD Phenon         
        //Gabinete chico, monitor de 20' y un mouse simple.           
        homePC = new CompositeProduct("Casa PC", 0.13);
        homePC.addProduct(ram4gb);
        homePC.addProduct(disk500gb);
        homePC.addProduct(cpuAMD);
        homePC.addProduct(smallCabinete);
        homePC.addProduct(monitor20inch);
        homePC.addProduct(simpleMouse);
        
        //Paque compuesto de dos paquetes: paquete Gammer PC y Home PC           
        pc2x1 = new CompositeProduct("Paquete PC Gammer + Casa", 0.08);
        pc2x1.addProduct(homePC);
    }

    private void orderSimpleProducts() {
        SaleOrder simpleProductOrder = new SaleOrder(random.nextInt(), "Rene Mora");
        simpleProductOrder.addProduct(ram4gb);
        simpleProductOrder.addProduct(disk1tb);
        simpleProductOrder.addProduct(simpleMouse);
        simpleProductOrder.printOrder();   
    }       
    
    private void orderGammerPC() {
        SaleOrder gammerOrder = new SaleOrder(1, "Juan Perez");
        gammerOrder.addProduct(gammerPC);
        gammerOrder.printOrder();
    }       
    
    private void orderHomePC() {
        SaleOrder homeOrder = new SaleOrder(2, "Marcos Guerra");
        homeOrder.addProduct(homePC);   homeOrder.printOrder(); 
    }       
    
    private void orderCombo() {
        SaleOrder comboOrder = new SaleOrder(3, "Paquete 2x1 en PC");
        comboOrder.addProduct(pc2x1);
        comboOrder.printOrder();   
    }
    
    private void orderBig() {
        SaleOrder customOrder = new SaleOrder(4, "Diego Mora"); 
        customOrder.addProduct(homePC);
        customOrder.addProduct(ram8gb);
        customOrder.addProduct(ram8gb);
        customOrder.addProduct(ram4gb);
        customOrder.addProduct(ram4gb);
        customOrder.addProduct(ram4gb);
        customOrder.addProduct(ram4gb);   
        customOrder.addProduct(monitor30inch);
        customOrder.addProduct(monitor30inch);
        customOrder.addProduct(gammerMouse);
        customOrder.addProduct(descuento);
        customOrder.printOrder();
    }
        
    public static void main(String[] args) {
        CompositeMain main = new CompositeMain();
        main.buildProducts();
        main.orderBig();
    }
    
}
