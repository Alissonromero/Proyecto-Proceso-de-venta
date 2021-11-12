import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente.model';
import { Ubigeo } from 'src/app/models/ubigeo.model';
import { ClienteService } from 'src/app/services/cliente.service';
import { UbigeoService } from 'src/app/services/ubigeo.service';

@Component({
  selector: 'app-consulta-cliente',
  templateUrl: './consulta-cliente.component.html',
  styleUrls: ['./consulta-cliente.component.css']
})
export class ConsultaClienteComponent implements OnInit {

   //Ng model
   nombres:string="";
   apellidos:string="";
   selDepartamento:string = ""; 
   selProvincia:string = ""; 
   selDistrito:number = 0;
 
   //Ubigeo
   listaDepartamentos: string[]  = [];
   listaProvincias: string[]  = [];
   listaDistritos: Ubigeo[]  = [];
 
   //Grila
   listaCliente: Cliente[] = [];
 
   constructor(private ubigeoService: UbigeoService, 
               private clienteService:ClienteService) { 
 
     ubigeoService.listarDepartamento().subscribe(
         response => this.listaDepartamentos = response
     );
 
   }
 
   consultaCliente(){
         this.clienteService.consultaCliente(this.nombres, this.apellidos, this.selDistrito).subscribe(
             response => this.listaCliente = response.lista
         );
   }
 
   cargaProvincia(){
     this.ubigeoService.listaProvincias(this.selDepartamento).subscribe(
           response => this.listaProvincias = response      
     );
   }
   cargaDistrito(){
     this.ubigeoService.listaDistritos(this.selDepartamento, this.selProvincia).subscribe(
           response => this.listaDistritos = response      
     );
   }
 

  ngOnInit(): void {
  }

}
