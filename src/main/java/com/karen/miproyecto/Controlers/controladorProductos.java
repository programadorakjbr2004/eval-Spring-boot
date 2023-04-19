package com.karen.miproyecto.Controlers;
import com.karen.miproyecto.Entitys.Productos;
import com.karen.miproyecto.Services.Misproductos;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class controladorProductos {


   Misproductos productoP=new Misproductos();
   @GetMapping ("/verproductos")
   public ArrayList<Productos> verproductos(){
       return productoP.listartodos();
   }


   @PostMapping("/insertarproductos")
   public String agregar(@RequestBody Productos p){
       return productoP.insetarProducto(p);
   }

   @GetMapping("/mostrartotal/{nom}")
   public String total(@PathVariable("nom") String nombre){
       return productoP.total(nombre);
   }


}
