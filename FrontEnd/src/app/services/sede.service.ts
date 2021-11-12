import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sede } from '../models/sede.model';

const baseUrl="http://localhost:8090/rest/sede"

@Injectable({
  providedIn: 'root'
})
export class SedeService {

  constructor(private http:HttpClient) { }

registrarSede(data:Sede):Observable<any>{

  return this.http.post(baseUrl,data);
}



listarSede():Observable<any>{


  return this.http.get(baseUrl);


}

listarSedeNombre(nombre:string):Observable<any>{


  return this.http.get(baseUrl+'/porNombre/'+nombre);


}


eliminarSed(idSed:number):Observable<any>{

  return this.http.delete(baseUrl+'/eliminarPorIdSede/'+idSed);
}

actualizarSede(objSede :any){


  return this.http.put(baseUrl,objSede);

}


consultarSedeNombreDirecPais(nombre:string, direccion:string, idPais:number): Observable<any> {

  const params = new HttpParams()
    .set("nombre", nombre)
    .set("direccion", direccion)
    .set("idPais", idPais);

  return this.http.get(baseUrl + "/porNombreDireccionPais", {params});
 
}



}
