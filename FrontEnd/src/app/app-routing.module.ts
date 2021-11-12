import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AddClienteComponent } from './components/add-cliente/add-cliente.component';
import { AddMarcaComponent } from './components/add-marca/add-marca.component';
import { AddProductoComponent } from './components/add-producto/add-producto.component';
import { AddProveedorComponent } from './components/add-proveedor/add-proveedor.component';
import { AddReclamoComponent } from './components/add-reclamo/add-reclamo.component';
import { AddSedeComponent } from './components/add-sede/add-sede.component';
import { AddUsuarioComponent } from './components/add-usuario/add-usuario.component';
import { ConsultaProveedorComponent } from './componets/consulta-proveedor/consulta-proveedor.component';
import { ConsultaSedeComponent } from './components/consulta-sede/consulta-sede.component';
import { ConsultaClienteComponent } from './components/consulta-cliente/consulta-cliente.component';
import { SelectProductoComponent } from './components/select-producto/select-producto.component';
import { ConsultaReclamoComponent } from './components/consulta-reclamo/consulta-reclamo.component';

import { CrudClienteComponent } from './components/crud-cliente/crud-cliente.component';
import { CrudMarcaComponent } from './components/crud-marca/crud-marca.component';
import { CrudProductoComponent } from './components/crud-producto/crud-producto.component';
import { CrudProveedorComponent } from './components/crud-proveedor/crud-proveedor.component';
import { CrudReclamoComponent } from './components/crud-reclamo/crud-reclamo.component';
import { CrudSedeComponent } from './components/crud-sede/crud-sede.component';


const routes: Routes = [

  {path:"addCliente", component:AddClienteComponent },
  {path:"addMarca", component:AddMarcaComponent },
  {path:"consultaProveedor", component:ConsultaProveedorComponent},
  {path:"addProducto", component:AddProductoComponent },
  {path:"addProveedor", component:AddProveedorComponent },
  {path:"addReclamo", component:AddReclamoComponent },
  {path:"consultaReclamo", component:ConsultaReclamoComponent },
  {path:"addSede", component:AddSedeComponent },
  {path:"addUsuario", component:AddUsuarioComponent },
  {path:"consultaSede",component:ConsultaSedeComponent},
  {path:"consultaCliente", component:ConsultaClienteComponent},
  {path:"consultaProducto", component:SelectProductoComponent },
  {path:"consultaProveedor", component:ConsultaProveedorComponent },
  {path:"crudCliente", component:CrudClienteComponent },
  {path:"crudProducto", component:CrudProductoComponent },
  {path:"crudMarca", component:CrudMarcaComponent },
  {path:"crudProveedor", component:CrudProveedorComponent },
  {path:"crudReclamo", component:CrudReclamoComponent } ,
  {path:"crudSede", component:CrudSedeComponent  } 
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
