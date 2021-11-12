package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Proveedor;
import com.cibertec.service.proveedorService;
import com.cibertec.util.Constantes;

@RestController
@RequestMapping("/rest/proveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorController {

	
	@Autowired
		private proveedorService service;
	
	
	@GetMapping("/lista")
	@ResponseBody
	public ResponseEntity<List<Proveedor>> lista(){
		List<Proveedor> lista = service.listaproveedor();
		return ResponseEntity.ok(lista);
		
		
		}	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaproveedor( @RequestBody Proveedor obj){
		
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setEstado(1);
			Proveedor objSalida = service.insertaproveedor(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		
		return ResponseEntity.ok(salida);		
	}
	

	
	/////////////////////////////////
	
	
	/////////////////////////////////////////////////
	
	@GetMapping("/porRucDireccioinUbigeoConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> ListaProveedor(
			@RequestParam(value = "ruc", required = false, defaultValue = "") String ruc,
			@RequestParam(value = "direccion", required = false, defaultValue = "") String direccion,
			@RequestParam(value = "idUbigeo", required = false, defaultValue = "0") int idUbigeo) {
		System.out.print("termino de consultar");
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Proveedor> lista = service.listaProveedorconsureposi(ruc, "%"+direccion+"%", idUbigeo);
			if(CollectionUtils.isEmpty(lista)){
				salida.put("mensaje", "No existe elementos para la consulta");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Se tiene " + lista.size() + " elementos");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Proveedor> actualizaproveedor(@RequestBody Proveedor obj){
		
		if (obj==null) {
			return ResponseEntity.badRequest().build();
		}else {
			
			Optional<Proveedor> optProveedor = service.buscarPorId(obj.getIdProveedor());
			if (optProveedor.isPresent()) {
				Proveedor objSalida= service.insertaproveedor(obj);
				return ResponseEntity.ok(objSalida);
				
			}else {
				return ResponseEntity.badRequest().build();
						
			}
					
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	@DeleteMapping("/{paramId}")
	@ResponseBody
	
	public ResponseEntity<Proveedor> actualizaproveedor(@PathVariable("paramId") int  idProveedor){
		Optional<Proveedor> optProveedor = service.buscarPorId(idProveedor);
		if (optProveedor.isPresent()) {
			service.eliminaPorId(idProveedor);
			Optional<Proveedor> optSalida = service.buscarPorId(idProveedor);
			if (optSalida.isPresent()) {
				return ResponseEntity.badRequest().build();
				}else {
				return ResponseEntity.ok(optProveedor.get());
				}}else {
				return ResponseEntity.badRequest().build();
			}
		}
		
		
	}
	
	

