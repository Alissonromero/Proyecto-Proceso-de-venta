import { Component, OnInit } from '@angular/core';
import { Marca } from 'src/app/models/marca.model';
import { Pais } from 'src/app/models/pais.model';
import { Producto } from 'src/app/models/producto.model';
import { MarcaService } from 'src/app/services/marca.service';
import { PaisService } from 'src/app/services/pais.service';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-add-producto',
  templateUrl: './add-producto.component.html',
  styleUrls: ['./add-producto.component.css']
})
export class AddProductoComponent implements OnInit {
  paises: Pais[] = [];
  marcas: Marca[] = [];

  producto: Producto = {
    pais:{
      idPais:-1,
    },
    marca:{
      idMarca:-1,
    }
  };
  constructor(private marcaService:MarcaService,private paisService:PaisService, private productoService:ProductoService) { 

    this.marcaService.listaMarca().subscribe(

       (marcas) => this.marcas = marcas

    );
    this.paisService.listaPais().subscribe(

      (paises) => this.paises = paises

   );

}
registraProducto(){
  console.log(this.producto);

  this.productoService.create(this.producto).subscribe(

    response =>{

      console.log(response.mensaje);
      this.producto.nombre="";
      this.producto.serie="";
      this.producto.precio=0;
      this.producto.stock=0;
      alert(response.mensaje)

    },

    error =>{

      console.log(error);

    },

  );

}

  ngOnInit(): void {
  }

}
