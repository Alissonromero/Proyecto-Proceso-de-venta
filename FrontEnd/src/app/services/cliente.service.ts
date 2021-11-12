
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente} from '../models/cliente.model';

const baseUrl = 'http://localhost:8090/rest/Cliente';


@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

    create(data:Cliente):Observable<any>{
      return this.http.post(baseUrl,data);

  }
    
  consultaCliente(nom:string, ape:string, ubi:number): Observable<any>{
    
    const params = new HttpParams()
    .set("nombres", nom)
    .set("apellidos", ape)
    .set("idUbigeo", ubi);

    return this.http.get(baseUrl+"/porNombreApellidoUbigeoParametros", {params});
  }

  listarCliente(): Observable<Cliente[]>{
    return this.http.get<Cliente[]>(baseUrl);
  }

}
