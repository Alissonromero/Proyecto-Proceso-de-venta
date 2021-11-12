package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Producto;
import com.cibertec.service.ProductoService;
import com.cibertec.util.Constantes;

@RestController
@RequestMapping("/rest/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
	
	@Autowired
	private ProductoService serviceProducto;
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaProducto(@RequestBody Producto obj){
		
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setEstado(1);
			Producto objSalida = serviceProducto.insertaProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/consulta3datos")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> listaProducto(
					@RequestParam(name="nombre", defaultValue="", required=false) String nombre,
					@RequestParam(name="serie", defaultValue="", required=false) String serie,
					@RequestParam(name="idMarca", defaultValue="0", required=false) int idMarca)
			{
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Producto> listaProducto = serviceProducto.listaProducto("%"+nombre+"%", "%"+serie+"%", idMarca);
			if (CollectionUtils.isEmpty(listaProducto)) {
				salida.put("mensaje", Constantes.MENSAJE_CON_NO_EXISTE);
			}else {
				salida.put("lista", listaProducto);
				salida.put("mensaje", "Existe(n) " + listaProducto.size() + " dato(s) en la consulta");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_CON_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}



