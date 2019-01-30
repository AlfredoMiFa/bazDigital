package com.baz.digital.controller;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baz.digital.exception.CitaNotFoundException;
import com.baz.digital.model.Cita;
import com.baz.digital.service.CitaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/citas")
public class HomeController {

	@Autowired
	private final CitaService citaService;
	
	private Cita cita;
	
	public HomeController(CitaService citaService) {
		this.citaService=citaService;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/agendar")
	@ApiOperation(value="Creamos una nueva cita", notes = "Creamos una nueva cita")
	public ResponseEntity<Cita> agendarCita(@Valid @RequestBody Cita cita) {
		return ResponseEntity.ok(citaService.saveCita(cita));
	}
	
	@RequestMapping(value="/consultar/{id}", method=RequestMethod.GET)
	@ApiOperation(value = "Cita encontrada", notes = "Regresa la cita por ID")
	public ResponseEntity<Cita> consultarCita(@PathVariable ObjectId id) {
		try {
			cita = citaService.findByCitaId(id);
		}catch(CitaNotFoundException ex) {
			cita = null;
		}
		return ResponseEntity.ok(cita);
	}
	
	@RequestMapping(value="/actualizar/{id}", method=RequestMethod.PUT)
	@ApiOperation(value = "Actualizamos cita", notes = "Actualizamos la cita")
	public ResponseEntity<Void> actualizarCita(@PathVariable("id") ObjectId id,@Valid @RequestBody Cita cita) {
		citaService.updateCita(cita);
		return ResponseEntity.noContent().build();
	}
	
}
