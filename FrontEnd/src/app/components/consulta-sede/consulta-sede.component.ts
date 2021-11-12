import { Component, OnInit } from '@angular/core';
import { SedeService } from '../../services/sede.service';
import { PaisService } from '../../services/pais.service';
import { Sede } from '../../models/sede.model';
import { Pais } from 'src/app/models/pais.model';

@Component({
  selector: 'app-consulta-sede',
  templateUrl: './consulta-sede.component.html',
  styleUrls: ['./consulta-sede.component.css']
})
export class ConsultaSedeComponent implements OnInit {

  nombre:string="";
  direccion:string="";
  selPais:number=0;
  listaPaises:Pais[] =[];
  sede: Sede[] = [];

  constructor(
private sedeServicio:SedeService,
  private paisservicio:PaisService
  ) 
  {
    this.paisservicio.listaPais().subscribe(
      data=>{
          this.listaPaises = data;
          console.log(data);
    },error=>{
      console.log(error);
    })
   }
  ngOnInit(): void {
  }
  consultaSedeNomDirecPais(){
this.sedeServicio.consultarSedeNombreDirecPais(this.nombre,this.direccion,this.selPais).subscribe(data=>{
  this.sede=data.lista

},error=>{
})
  }
}
