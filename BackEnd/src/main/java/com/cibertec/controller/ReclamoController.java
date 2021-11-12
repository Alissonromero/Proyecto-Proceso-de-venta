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

import com.cibertec.entity.Reclamo;
import com.cibertec.service.ReclamoService;
import com.cibertec.util.Constantes;




@RestController
@RequestMapping("/rest/reclamo")
@CrossOrigin(origins = "http://localhost:4200")

public class ReclamoController {
	
	@Autowired
	private ReclamoService reclamoService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaReclamo(@RequestBody Reclamo obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Reclamo objSalida = reclamoService.insertaActualizaReclamo(obj);
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
	
	@GetMapping("/porEstadoClienteTipoReclamoConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> consulta
				(@RequestParam(name="estado",defaultValue = "0", required = true) int estado ,
				 @RequestParam(name="idCliente",defaultValue = "0", required = true) int idCliente ,
				 @RequestParam(name="idTipoReclamo",defaultValue = "0", required = true) int idTipoReclamo) {
		
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Reclamo> lstSalida = reclamoService.listaReclamo( estado,idCliente,idTipoReclamo);
			
			if (CollectionUtils.isEmpty(lstSalida)) {
				salida.put("mensaje", "No existen datos para esa consulta.");
			} else {
				salida.put("lista", lstSalida);
				salida.put("mensaje", "Existen "+ lstSalida.size() + " reclamos.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
