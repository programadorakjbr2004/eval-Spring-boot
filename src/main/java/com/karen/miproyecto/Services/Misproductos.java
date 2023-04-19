package com.karen.miproyecto.Services;

import com.karen.miproyecto.Entitys.Productos;

import java.util.ArrayList;

public class Misproductos {

    private ArrayList<Productos> milista=new ArrayList<>();

    public Misproductos(){
        milista.add(new Productos(12,"Manzana","fruta",2000,5));
        milista.add(new Productos(8,"Frijol","Legumbre",6000,9));
        milista.add(new Productos(7,"Zanahoria","Vegetal",1500,14));
        milista.add(new Productos(15,"sanduchera","electrodomestico",70000,10));
        milista.add(new Productos(12,"Mango","fruta",1800,20));
        milista.add(new Productos(12,"Garbanzo","legumbre",5000,13));
        milista.add(new Productos(12,"pepino","Vegetal",2500,22));


    }

    public ArrayList<Productos> listartodos(){
    return milista;

    }

    public String insetarProducto(Productos p){
        milista.add(p);
        return "Se ha ingresado un nuevo producto";
    }

    public Productos buscarnombre(String nombre){
        Productos pro=null;

        for(Productos p:milista){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                pro=p;
                break;
            }
        }
        return pro;
    }

    public String total(String nombre) {
        ArrayList<Productos> ok=new ArrayList<>();
        String retorno="";
        String retorno1="";
        double totalo = 0;
        for (Productos p : milista) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                double multi = p.getPrecio() * p.getCantidad();
                double des = multi * 0.15;
                totalo = multi - des;
                retorno=p.toString();
                retorno1=retorno+"Precio total: " + totalo;
                p.setTotal((int) totalo);
                p.setDescuento((int) des);
            }

        }
        return retorno1;
    }


}
