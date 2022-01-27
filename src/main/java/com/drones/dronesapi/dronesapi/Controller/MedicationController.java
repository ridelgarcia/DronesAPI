package com.drones.dronesapi.dronesapi.Controller;

import java.util.LinkedList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<MedicationResponseDTO>> getAll() {
        List<Medication> medications = medicationService.getAll();
        List<MedicationResponseDTO> medicationsResponse = new LinkedList<MedicationResponseDTO>();
        for(int i = 0 ; i < medications.size() ;++i) {
        	medicationsResponse.add(mapper.medicationToMedicationResponseDTO(medications.get(i)));
        }
		return new ResponseEntity<List<MedicationResponseDTO>>(medicationsResponse,HttpStatus.OK);
	}
	@RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
	public ResponseEntity<MedicationResponseDTO> getById(@PathVariable("id") long id) {
		ResponseEntity<MedicationResponseDTO> response;
		try {
			Medication medication = medicationService.getById(id);
			response = new ResponseEntity<MedicationResponseDTO>(mapper.medicationToMedicationResponseDTO(medication),HttpStatus.OK);
		}
		catch (Exception e) {
			response = new ResponseEntity<MedicationResponseDTO>(HttpStatus.NOT_FOUND);
		}
        
		return response;
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
