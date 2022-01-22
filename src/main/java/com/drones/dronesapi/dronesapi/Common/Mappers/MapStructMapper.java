package com.drones.dronesapi.dronesapi.Common.Mappers;

import com.drones.dronesapi.dronesapi.Common.DTO.Request.Drone.*;
import com.drones.dronesapi.dronesapi.Common.DTO.Response.Drone.*;
import com.drones.dronesapi.dronesapi.Model.*;
import org.mapstruct.Mapper;


@Mapper(
	    componentModel = "spring"
	)
	
public interface MapStructMapper {
	
	
	Drone addDroneRequestDTOToDrone(AddDroneRequestDTO addDroneRequest);
	
	Drone deleteDroneRequestDTOToDrone(DeleteDroneRequestDTO deleteDroneRequest);
	
	Drone modifyDroneRequestDTOToDrone(ModifyDroneRequestDTO modifyDroneRequest);
	
	AddDroneResponseDTO droneToAddDroneResponseDTO(Drone drone);
	
	DeleteDroneResponseDTO droneToDeleteDroneResponseDTO(Drone drone);
	
	ModifyDroneResponseDTO droneToModifyDroneResponseDTO(Drone drone);
	
}
