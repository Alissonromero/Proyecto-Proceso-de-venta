import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Pais } from 'src/app/models/pais.model';
 
import { Sede } from '../../models/sede.model';
import { PaisService } from '../../services/pais.service';
import { SedeService } from '../../services/sede.service';

@Component({
  selector: 'app-add-sede',
  templateUrl: './add-sede.component.html',
  styleUrls: ['./add-sede.component.css']
})
export class AddSedeComponent implements OnInit {

  estadoSpiner:boolean;
  registerForm:FormGroup;
  estadoModal:boolean;
listaPaises :Pais[]=[];
nombreFiltro:string;
estadoAlert:boolean;
estadoAlertAct:boolean;
estadoAlertDel:boolean;
listaSedes :any=[];

sede:Sede={
    
   
  pais:{
      idPais:-1,
      nombre:""
  }


}

 



  constructor(
    
  
    
    private paisService:PaisService,
    private sedeService:SedeService,
    private fb:FormBuilder,
    private router:Router,
    private atraparRouter:ActivatedRoute


  ) {
this.estadoAlertDel=false;
this.estadoAlert=false;
    this.estadoModal=true;
    this.nombreFiltro="";
this.estadoAlertAct=false;
    console.log(atraparRouter.snapshot.paramMap.get("nombre"));
    this.listSede();
      this.estadoSpiner=false;
      this.registerForm=this.fb.group({

        nombre:['',[Validators.required]],
        direccion:['',[Validators.required]],
        codigoPostal:['',[Validators.required,Validators.maxLength(5)]],
        pais:[Validators.required]

      })


      this.paisService.listaPais().subscribe(data=>{

        this.listaPaises=data;
        console.log(data);
      },error=>{
        console.log(error);
      })
  
    


   }

  ngOnInit(): void {
    this.listSede();

 

  }


  registraSede(){
  
  
    

  console.log(this.sede);

this.sedeService.registrarSede(this.sede).subscribe(response=>{
  console.log("Registro exitoso");
 this.listSede();
 this.estadoAlert=true;
 
 setTimeout(() => {
   this.estadoAlert=false;
 },2000);
 



},error=>{
console.log(error);
 


})

this.registerForm.reset();
 
console.log(this.registerForm);
console.log("ASDASDASD");
this.sede={
    
   
  pais:{
      idPais:-1,
      nombre:""
  }


}


let btnCerrarM=document.getElementById("btn_cerrarM");
 
btnCerrarM?.click();
 

  }



 listSede(){
   this.sedeService.listarSede().subscribe(data=>{

    this.listaSedes=data;
console.log(data);


   },error=>{
console.log(error);


   }
   
   )
 }


 listSedeNombre(nombre:string){
   

 
  this.sedeService.listarSedeNombre(nombre).subscribe(data=>{

    console.log(data);
   
 

    if(data.length===0){
      console.log("Data vacia");
    }else {
      this.listaSedes=data;
    }

  },error=>{
    console.log(error);
    console.log("Data vacia");
    this.listSede();
    
  })
  console.log("gaaaa");



}



eliminarSede(id:number){
  this.estadoAlertDel=true;

  this.sedeService.eliminarSed(id).subscribe(ok=>{


    setTimeout(() => {
      this.estadoAlertDel=false;
    }, 2000);
console.log("Eliminado correctamente");
this.listSede();

  },error=>{
    console.log(console.error());
  })

}


 

capturandoObj(objSed :any){


this.sede=objSed

 

}


actualizando(){
 
   
this.sedeService.actualizarSede(this.sede).subscribe(ok=>{

  console.log("Actualizado");

  this.estadoAlertAct=true;
 
  setTimeout(() => {
    this.estadoAlertAct=false;
  },2000);
  },error=>{
  
  console.log(error);
    });
    let btnCerrarMA=document.getElementById("btn_cerrarMA"); 
    btnCerrarMA?.click();
    this.listSede();
 

}

 

limpiarData(){

 
   
  this.sede={
    
   
    pais:{
        idPais:-1,
        nombre:""
    }
  
  
  }


  this.listSede();   
 
}


}