import { Component, OnInit } from '@angular/core';
//import { time } from 'console';
import { Cliente } from 'src/app/models/cliente.model';
import { Reclamo } from 'src/app/models/reclamo.model';
import { TipoReclamo } from 'src/app/models/tipo-reclamo.model';
import { ClienteService } from 'src/app/services/cliente.service';
import { ReclamoService } from 'src/app/services/reclamo.service';
import { TipoReclamoService } from 'src/app/services/tipo-reclamo.service';

@Component({
  selector: 'app-consulta-reclamo',
  templateUrl: './consulta-reclamo.component.html',
  styleUrls: ['./consulta-reclamo.component.css']
})
export class ConsultaReclamoComponent implements OnInit {

  //descripcion:string = "";
  //fechaRegistro:Date = Date.now;
  estado:number = 0;
  selCliente:number = 0;
  selTipoReclamo:number = 0;

  listCliente:Cliente[]=[];
  listTipoReclamo:TipoReclamo[]=[];

  listReclamo: Reclamo[]=[];



  
  constructor(private clienteService:ClienteService,private tipoReclamoService:TipoReclamoService, private reclamoService:ReclamoService) { 

    this.clienteService.listarCliente().subscribe(
      response => this.listCliente = response
    );
    this.tipoReclamoService.listarTipoReclamo().subscribe(
      response => this.listTipoReclamo = response
    );
  }

  consultaReclamo(){

    this.reclamoService.consultaReclamo(this.estado, this.selCliente, this.selTipoReclamo).subscribe(
      
      response => {
        console.log(response.mensaje);
        alert(response.mensaje);
        this.listReclamo = response.lista},
        error => {
          console.log(error);
        }

    );
  }


  ngOnInit(): void {
  }

}
