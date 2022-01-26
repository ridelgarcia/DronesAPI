package com.drones.dronesapi.dronesapi.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.drones.dronesapi.dronesapi.Services.MedicationService;
import com.drones.dronesapi.dronesapi.Common.Mappers.MapStructMapper;

import com.drones.dronesapi.dronesapi.Model.Medication;
import com.drones.dronesapi.dronesapi.Common.DTO.Request.Medication.*;
import com.drones.dronesapi.dronesapi.Common.DTO.Response.Medication.*;
@RestController
@RequestMapping("/medication")
public class MedicationController {
	
	MedicationService medicationService;
	
	MapStructMapper mapper;
	
	
	@Autowired
	public MedicationController(MedicationService medicationService, MapStructMapper mapper) {
		super();
		this.medicationService = medicationService;
		this.mapper = mapper;
	}
	
	@RequestMapping(value = "/getAll",method = RequestMethod.GET)
	public ResponseEntity<List<Medication>> getAll() {
        List<Medication> medications = medicationService.getAll();
		return new ResponseEntity<List<Medication>>(medications,HttpStatus.OK);
	}
    
	@RequestMapping(value = "/addMedication",method = RequestMethod.PUT)
	public ResponseEntity<?> addMedication(@RequestBody AddMedicationRequestDTO request) {
        Medication medication = mapper.addMedicationRequestDTOToMedication(request);
        medicationService.save(medication);
        AddMedicationResponseDTO response = mapper.medicationToAddMedicationResponseDTO(medication);
		return new ResponseEntity<AddMedicationResponseDTO>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteMedication",method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMedication(@RequestBody DeleteMedicationRequestDTO request) {
        Medication medication = mapper.deleteMedicationRequestDTOToMedication(request);
        medicationService.delete(medication);
        DeleteMedicationResponseDTO response = mapper.medicationToDeleteMedicationResponseDTO(medication);
		return new ResponseEntity<DeleteMedicationResponseDTO>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modifyMedication",method = RequestMethod.POST)
	public ResponseEntity<?> modifyMedication(@RequestBody ModifyMedicationRequestDTO request) {
        Medication medication = mapper.modifyMedicationRequestDTOToMedication(request);
        medicationService.save(medication);
        ModifyMedicationResponseDTO response = mapper.medicationToModifyMedicationResponseDTO(medication);
		return new ResponseEntity<ModifyMedicationResponseDTO>(response,HttpStatus.OK);
	}
}
