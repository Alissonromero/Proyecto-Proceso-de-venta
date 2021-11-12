package com.cibertec.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Cliente;
import com.cibertec.entity.FiltroCliente;
import com.cibertec.service.ClienteService;
import com.cibertec.util.Constantes;


@RestController
@RequestMapping("/rest/cliente")
@CrossOrigin(origins = "http://localhost:4200")

public class ClienteController {

	
	
	@Autowired
	private ClienteService ClienteService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cliente>> listaCliente() {
		List<Cliente> lista = ClienteService.listaCliente();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaCliente(@RequestBody Cliente obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Cliente objSalida = ClienteService.insertaActualizaCliente(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	
	@GetMapping("/poridCliente/{paramidCliente}")
	@ResponseBody
	public ResponseEntity<List<Cliente>> listaClientePoridCliente(@PathVariable("paramidCliente")String idCliente) {
		List<Cliente> lista = ClienteService.listaClientePoridCliente(idCliente);
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/porApellidos/{paramApellidos}")
	@ResponseBody
	public ResponseEntity<List<Cliente>> listaClientePorApellidos(@PathVariable("paramApellidos")String Apellidos) {
		List<Cliente> lista = ClienteService.listaClientePorApellidos(Apellidos);
		return ResponseEntity.ok(lista);
	}
	
	
	
	
	
	
	
	@GetMapping("/poridClienteApellidos/{paramidCliente}/{paramApellidos}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaClientePoridClienteApellidosSimple(
										@PathVariable("paramidCliente")String idCliente,
										@PathVariable("paramApellidos")String Apellidos) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Cliente> lista = ClienteService .listaClientePoridClienteApellidos(idCliente, "%"+Apellidos+"%");
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
	
	
	@GetMapping("/poridClienteApellidosConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaPridClienteApellidosConParametros(
			@RequestParam(value = "Apellidos", required = false, defaultValue = "") String Apellidos,
			@RequestParam(value = "idCliente", required = false, defaultValue = "") String idCliente) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Cliente> lista = ClienteService .listaClientePoridClienteApellidos(idCliente, "%"+Apellidos+"%");
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
	
	@GetMapping("/poridClienteApellidosUbigeoConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaPridClienteApellidosUbigeoConParametros(
			@RequestParam(value = "Apellidos", required = false, defaultValue = "") String Apellidos,
			@RequestParam(value = "idCliente", required = false, defaultValue = "") String idCliente,
			@RequestParam(value = "idUbigeo", required = false, defaultValue = "0") int idUbigeo) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Cliente> lista = ClienteService.listaClientePoridClienteApellidosUbigeo(idCliente, "%"+Apellidos+"%", idUbigeo);
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
	
	@GetMapping("/poridClienteApellidosUbigeoConJson")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaPridClienteApellidosUbigeoConParametros(
							@RequestBody FiltroCliente filtro) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			filtro.setApellidos("%"+filtro.getApellidos()+"%");
			List<Cliente> lista = ClienteService.listaPorFiltro(filtro);
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
	
	
	@GetMapping("/porNombreApellidoUbigeoParametros")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaCliente(
			@RequestParam(name = "nombres", defaultValue = "", required = false) String nombres,
			@RequestParam(name = "apellidos", defaultValue = "", required = false) String apellidos,
			@RequestParam(name = "idUbigeo", defaultValue = "0", required = false) int idUbigeo){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Cliente> lstCliente = ClienteService.listaCliente("%"+nombres+"%", apellidos, idUbigeo);
			if (CollectionUtils.isEmpty(lstCliente)) {
				salida.put("mensaje", "No existe datos para la consulta");
			}else {
				salida.put("lista", lstCliente);
				salida.put("mensaje",  "Existe: " + lstCliente.size() + " clientes");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	
}
