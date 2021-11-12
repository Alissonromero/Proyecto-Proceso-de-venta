import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reclamo } from '../models/reclamo.model';

const baseUrl = 'http://localhost:8090/rest/reclamo';

@Injectable({
  providedIn: 'root'
})
export class ReclamoService {

  constructor(private http:HttpClient) { }

  registrar(data:Reclamo): Observable<any>{
    return this.http.post(baseUrl, data);
  }

  consultaReclamo(est:number, cli:number, tip_rec:number): Observable<any>{ 

    const params = new HttpParams()
        .set("estado", est)
        .set("idCliente", cli)
        .set("idTipoReclamo", tip_rec)

        return this.http.get(baseUrl + "/porEstadoClienteTipoReclamoConParametros", {params} );
  }
}


