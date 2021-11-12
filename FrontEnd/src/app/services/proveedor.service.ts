import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Proveedor } from '../models/proveedor.model';

const baseUrl = 'http://localhost:8090/rest/proveedor';


@Injectable({
  providedIn: 'root'
})
export class ProveedorService {

  constructor(private http: HttpClient) { }

  consulta(ruc:string, direc:string, ubi:number ): Observable<any> {

    const params=new HttpParams()
    .set("ruc",ruc)
    .set("direccion",direc)
    .set("idUbigeo",ubi);

    return  this.http.get(baseUrl +"/porRucDireccioinUbigeoConParametros",{   params}); 


  }



  create(data:Proveedor):Observable<any>{
return this.http.post(baseUrl,data);








  }
}
