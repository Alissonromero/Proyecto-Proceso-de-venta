import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente.model';
import { Reclamo } from 'src/app/models/reclamo.model';
import { TipoReclamo } from 'src/app/models/tipo-reclamo.model';
import { ClienteService } from 'src/app/services/cliente.service';
import { ReclamoService } from 'src/app/services/reclamo.service';
import { TipoReclamoService } from 'src/app/services/tipo-reclamo.service';

@Component({
  selector: 'app-add-reclamo',
  templateUrl: './add-reclamo.component.html',
  styleUrls: ['./add-reclamo.component.css']
})
export class AddReclamoComponent implements OnInit {

  lstClientes: Cliente[]=[];
  lstTipoReclamo:TipoReclamo[]=[];

  reclamo: Reclamo={
    cliente:{
      idCliente:0
    },
    tipoReclamo:{
      idTipoReclamo:0
    }
  };

  constructor(private clienteService:ClienteService,
              private tipoReclamoService:TipoReclamoService,
              private reclamoService:ReclamoService) { 

        clienteService.listarCliente().subscribe(
            clientes => this.lstClientes=clientes
        );
        tipoReclamoService.listarTipoReclamo().subscribe(
          tipoReclamo => this.lstTipoReclamo=tipoReclamo,
        );

  }

  registraReclamo(){
    console.log(this.reclamo);
    this.reclamoService.registrar(this.reclamo).subscribe(
        response => {
            console.log(response.mensaje);
            alert(response.mensaje);
          },
          error => {
            console.log(error);
          },
    );

  }

  ngOnInit(): void {
  }

}
