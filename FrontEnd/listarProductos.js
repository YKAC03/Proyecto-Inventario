window.onload=function(){
    productos();
}

let productos =async()=>{
    const peticion=await fetch("http://localhost:8080/api/vertodos",
        {
            method:"GET",
            headers:{
                "Accept":"application/json",
                "Content-Type":"application/json"
            }
        }
    );

    const products = await peticion.json();
    
    let contenidoTabla="";
    for(let producto of products){
        let contenidoFila= `<tr>
        <td>${producto.id_producto}</td>
        <td>${producto.nombre_producto}</td>
        <td>${producto.precio_producto}</td>
        <td>${producto.lote_producto}</td>
        <td>${producto.descripcion_producto}</td>
        <td>${producto.cantidad_producto}</td>
        </tr>`

        contenidoTabla+=contenidoFila;

        
    }
    document.querySelector("#tabla tbody").outerHTML=contenidoTabla;
}