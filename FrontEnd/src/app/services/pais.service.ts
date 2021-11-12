import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pais } from '../models/pais.model';



const baseUrl="http://localhost:8090/url/lista/listaPais";

@Injectable({
  providedIn: 'root'
})
export class PaisService {

  constructor(private http:HttpClient) { }


  listaPais():Observable<Pais[]>{
    
    return this.http.get<Pais[]>(baseUrl);


  }
}
