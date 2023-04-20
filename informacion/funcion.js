
var $ = jQuery;
$(document).ready(function(){

    
    $('#listar').on('click', function(){
        let tabla=document.querySelector('#tablita')
        tabla.innerHTML=""
        alert("entraaa")
        $.ajax({
            url:"http://localhost:8080/verproductos",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta){
                console.log(respuesta)
                for(i=0;i<=respuesta.length; i++){
                    tabla.innerHTML+='<tr><td>'+ 
                    respuesta[i].codigo +'</td><td>'+
                    respuesta[i].nombre +'</td><td>'+
                    respuesta[i].categoria +'</td><td>'+
                    respuesta[i].precio +'</td><td>'+
                    respuesta[i].cantidad +'</td></tr>'
                   
                }
            }

        })  
    })

    $('#agrega').on('click', function(){
        let datos={
            codigo: parseInt($('#cod').val()),
            nombre: $('#nombre').val(),
            categoria: $('#categoria').val(),
            precio: parseInt($('#precio').val()),
            cantidad: parseInt($('#cantidad').val()),

        }

        let datosenvio=JSON.stringify(datos)

        console.log("no json",datos)
        console.log("json",datosenvio)

        $.ajax({

            url:"http://localhost:8080/insertarproductos",
            type:"POST",
            data: datosenvio,
            contentType: "application/JSON",
            datatype: JSON,

            success: function(respuesta){
                alert(respuesta)
            }

        })

    })

    $('#calculo').on('click', function(){
        let tabla=document.querySelector('#tabla')
        tabla.innerHTML=""
        alert("entraaa")
        $.ajax({
            url:"http://localhost:8080/mostrartotal/"+nom,
            type: "GET",
            dataType: "JSON",
            success: function(respuesta){
                console.log(respuesta)
                for(i=0;i<=respuesta.length; i++){
                    tabla.innerHTML+='<tr><td>'+ 
                    respuesta[i].codigo +'</td><td>'+
                    respuesta[i].nombre +'</td><td>'+
                    respuesta[i].categoria +'</td><td>'+
                    respuesta[i].precio +'</td><td>'+
                    respuesta[i].cantidad +'</td><td>'+
                    respuesta[i].total +'</td><td>'+
                    respuesta[i].total-iva +'</td><td>'+
                    respuesta[i].descuento +'</td></tr>'
                }
            }

        })  
    })




})