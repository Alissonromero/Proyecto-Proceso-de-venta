import { Component, OnInit } from '@angular/core';
import { Marca } from 'src/app/models/marca.model';
import { Producto } from 'src/app/models/producto.model';
import { MarcaService } from 'src/app/services/marca.service';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-select-producto',
  templateUrl: './select-producto.component.html',
  styleUrls: ['./select-producto.component.css']
})
export class SelectProductoComponent implements OnInit {

  //Ng model se relacionan con los componentes del formulario
  nombre:string="";
  serie:string=""; 
  selMarca:number = 0;

  //Marca carga de los combos
  marcas: Marca[]  = [];



  //Grila
  productos: Producto[] = [];

  constructor(private marcaService: MarcaService, 
              private productoService:ProductoService) { 

                marcaService.listaMarca().subscribe(
                  response => this.marcas = response
              );
}

consultaProducto(){
  this.productoService.select(this.nombre, this.serie, this.selMarca).subscribe(
      response => this.productos = response.lista
  );
}

cargaMarca(){
  this.marcaService.listaMarca().subscribe(
        response => this.productos = response      
  );
}
  ngOnInit(): void {
  }

}
