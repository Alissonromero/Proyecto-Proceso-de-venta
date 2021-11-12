import { Component, OnInit } from '@angular/core';
import { Proveedor } from 'src/app/models/proveedor.model';
import { Ubigeo } from 'src/app/models/ubigeo.model';
import { ProveedorService } from 'src/app/services/proveedor.service';
import { UbigeoService } from 'src/app/services/ubigeo.service';

@Component({
  selector: 'app-consulta-proveedor',
  templateUrl: './consulta-proveedor.component.html',
  styleUrls: ['./consulta-proveedor.component.css']
})
export class ConsultaProveedorComponent implements OnInit {

  //ngModel


ruc : string ="";
direccion : string="";
selDepartamento : string="";
selProvincia : string="";
selDistrito : number = 0;

  listadepartamentos : string[] = [];
  listaprovincias : string[] = [];
  listadistritos : Ubigeo[] = [];



  listaProveedor: Proveedor[] =[];

  constructor(private ubigeService:UbigeoService,
    private proveedorservice:ProveedorService) { 

      this.ubigeService.listarDepartamento().subscribe(
        response => this.listadepartamentos = response);



    }

    listaProvincia(){

      this.ubigeService.listaProvincias(this.selDepartamento).subscribe(
  
        response => this.listaprovincias = response
  
      );
  
    }
  
  
  
    listaDistrito(){
  
      this.ubigeService.listaDistritos(this.selDepartamento, this.selProvincia).subscribe(
  
          response => this.listadistritos = response
  
      );
  
    }




    consultaproveedor(){

this.proveedorservice.consulta(this.ruc, this.direccion,this.selDistrito).subscribe(
   response => this.listaProveedor = response.lista
);

    }

  ngOnInit(): void {
  }

}
