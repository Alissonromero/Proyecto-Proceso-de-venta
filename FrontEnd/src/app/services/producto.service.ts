import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto.model';

const baseUrl = 'http://localhost:8090/rest/producto';

@Injectable({
  providedIn: 'root'
})

export class ProductoService {

  constructor(private http: HttpClient) { }

  select(nombre:string, serie:string, marca:number): Observable<any> {
    const params = new HttpParams().set("nombre", nombre)
                                    .set("serie", serie)
                                    .set("idMarca", marca);
    
    return this.http.get(baseUrl+"/consulta3datos", {params});
  }

  create(data:Producto):Observable<any>{

      return this.http.post(baseUrl,data);

  }



}