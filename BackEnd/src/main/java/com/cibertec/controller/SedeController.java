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

import com.cibertec.entity.Sede;
import com.cibertec.service.SedeService;


@RestController
@RequestMapping("/rest/sede")
@CrossOrigin(origins = "http://localhost:4200")
public class SedeController {
	
	
	@Autowired
	private SedeService sedeService;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Sede>> listaDocente() {
		List<Sede> lista = sedeService.listarSede();
		return ResponseEntity.ok(lista);
	}

	
	@GetMapping("/porNombre/{paramNombre}")
	@ResponseBody
	public ResponseEntity<List<Sede>> listaDocentePorNombre(@PathVariable("paramNombre")String nombre) {
		List<Sede> lista = sedeService.listarSedeNombre(nombre);
		return ResponseEntity.ok(lista);
	}
	

	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaModalidad(@RequestBody Sede obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Sede objSalida = sedeService.insertarActualizarSede(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error en el registro");
			} else {
				salida.put("mensaje", "Registro exitoso");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en el registro");
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizarSede(@RequestBody Sede obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Sede objSalida = sedeService.insertarActualizarSede(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error al actualizar");
			} else {
				salida.put("mensaje", "Se actualizó correctamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al actualizar");
		}
		return ResponseEntity.ok(salida);
	}
	
	 
	@DeleteMapping("/eliminarPorIdSede/{idSede}")
	@ResponseBody
	public Map<String, Object> eliminaProv(@PathVariable("idSede")int  idSede){
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Optional<Sede> opt = sedeService.obtienePorIdSede(idSede);
			if(opt.isPresent()) {
				sedeService.eliminarSede(idSede);
				salida.put("mensaje","Se eliminó correctamente");
			}else {
				salida.put("mensaje", "Error al eliminar");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error al eliminar");
			e.printStackTrace();
		}finally {
			List<Sede> lst = sedeService.listarSede();
			salida.put("lista", lst);
		}
		return salida;		
	}
	
	
	
	/*filtrado con 3 datos*/
	
	
	 
	
	@GetMapping("/porNombreDireccionPais")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaPorNombreDireccionPaisConParametros(
			@RequestParam(value = "nombre", required = false, defaultValue = "") String nombre,
			@RequestParam(value = "direccion", required = false, defaultValue = "") String direccion,
			@RequestParam(value = "idPais", required = false, defaultValue = "0") int idPais) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Sede> lista = sedeService.listaSedePorNombreDireccionPais(nombre,direccion ,idPais);
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
	
	 
	
	
	
	
	
	

}
