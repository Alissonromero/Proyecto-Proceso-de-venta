import { Marca } from "./marca.model";
import { Pais } from "./pais.model";

export class Producto {
    idProducto?: number;
    nombre?:string;
    serie?:string;
    precio?:number;
    stock?:number;
    estado?:number;
    marca?:Marca;
    pais?:Pais;
}
