import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TipoReclamo } from '../models/tipo-reclamo.model';


const baseUrl = 'http://localhost:8090//url/lista';

@Injectable({
  providedIn: 'root'
})
export class TipoReclamoService {

  constructor(private http:HttpClient) { }

  listarTipoReclamo(): Observable<TipoReclamo[]>{
    return this.http.get<TipoReclamo[]>(baseUrl+"/listaTipoReclamo");
  }



  
}
