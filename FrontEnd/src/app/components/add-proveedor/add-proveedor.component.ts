import { Component, OnInit } from '@angular/core';
import { Proveedor } from 'src/app/models/proveedor.model';
import { Ubigeo } from 'src/app/models/ubigeo.model';
import { ProveedorService } from 'src/app/services/proveedor.service';
import { UbigeoService } from 'src/app/services/ubigeo.service';

@Component({
  selector: 'app-add-proveedor',
  templateUrl: './add-proveedor.component.html',
  styleUrls: ['./add-proveedor.component.css']
})
export class AddProveedorComponent implements OnInit {

  departamentos : string[] = [];
  provincias : string[] = [];
  distritos : Ubigeo[] = [];

  proveedor: Proveedor = { 
    ubigeo:{
      idUbigeo:-1,
      departamento:"-1",
      provincia:"-1",
      distrito:"",
    }
  };


  constructor( private ubigeoService:UbigeoService,
    private proveedorService:ProveedorService) {

      this.ubigeoService.listarDepartamento().subscribe(
        (departamentos) => this.departamentos = departamentos


      );


    }
    inserta(){
      console.log(this.proveedor);
      this.proveedorService.create(this.proveedor).subscribe(
          response => {
              console.log(response.mensaje);
              alert(response.mensaje);
            },
            error => {
              console.log(error);
            },
      );
  }
  listaProvincia(){
    console.log("listaProvincia>>> " + this.proveedor.ubigeo?.departamento);
    this.ubigeoService.listaProvincias(this.proveedor.ubigeo?.departamento).subscribe(
        (provincias) => this.provincias = provincias
    );
}
listaDistrito(){
  console.log("listaDistrito>>> " + this.proveedor.ubigeo?.departamento);
  console.log("listaDistrito>>> " + this.proveedor.ubigeo?.provincia);
  this.ubigeoService.listaDistritos(this.proveedor.ubigeo?.departamento,this.proveedor.ubigeo?.provincia).subscribe(
      (distritos) => this.distritos = distritos
  );
}


ngOnInit(): void {
  }

}
