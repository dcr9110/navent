//Sentencia para verificar que el DOM cargo correctamente
$(document).ready(enviarFormulario());

//Funcion llamada al terminar de cargar el DOM
function enviarFormulario(){
    $("FormularioPedidos").submit(function(){
        //Guarda las variables del formulario
        var datoPedidos = $(this).serialize();
        //Envia los datos al servidor para ser tratados
        $.get("/pedidos/guardar", datoPedidos, envioCorrecto())
       
    });
}

//funcion para trabajar los datos devueltos por el servidor
function envioCorrecto(datosDevueltos){
    alert("Realizado");
}

