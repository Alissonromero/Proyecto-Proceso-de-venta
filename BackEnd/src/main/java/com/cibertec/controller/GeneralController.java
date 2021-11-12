package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Cliente;
import com.cibertec.entity.Marca;
import com.cibertec.entity.Pais;
import com.cibertec.entity.TipoReclamo;
import com.cibertec.entity.Ubigeo;
import com.cibertec.service.ClienteService;
import com.cibertec.service.MarcaService;
import com.cibertec.service.PaisService;
import com.cibertec.service.TipoReclamoService;
import com.cibertec.service.UbigeoService;

@RestController
@RequestMapping("/url/lista")
@CrossOrigin(origins = "http://localhost:4200")
public class GeneralController {

	@Autowired
	private UbigeoService ubigeoService;

	@Autowired
	private PaisService paisService;

	@Autowired
	private MarcaService marcaService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private TipoReclamoService tipoReclamoService;

	@GetMapping("/listaCliente")
	@ResponseBody
	public List<Cliente> listaCliente() {
		return clienteService.listaCliente();
	}

	@GetMapping("/listaTipoReclamo")
	@ResponseBody
	public List<TipoReclamo> listaTipoReclamo() {
		return tipoReclamoService.listaTipoReclamo();
	}

	@GetMapping("/listaPais")
	@ResponseBody
	public List<Pais> listaPais() {
		return paisService.listaPais();
	}

	@GetMapping("/listaMarca")
	@ResponseBody
	public List<Marca> listaMarca() {
		return marcaService.listaMarca();
	}

	@GetMapping("/listaDepartamentos")
	@ResponseBody
	public List<String> verDepartamentos() {
		return ubigeoService.listaDepartamentos();
	}

	@GetMapping("/listaProvincias/{paramDepar}")
	@ResponseBody
	public List<String> verProvincias(@PathVariable("paramDepar") String departamento) {
		return ubigeoService.listaProvincias(departamento);
	}

	@GetMapping("/listaDistritos/{paramDepar}/{paramProv}")
	@ResponseBody
	public List<Ubigeo> verDistritos(@PathVariable("paramDepar")String departamento, @PathVariable("paramProv")String provincia) {
		return ubigeoService.listaDistritos(departamento, provincia);
	}

}
