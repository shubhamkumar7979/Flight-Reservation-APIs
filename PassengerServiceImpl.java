package com.FlightAPI.Service.Impl;

import com.FlightAPI.Payload.PassengerDTO;
import com.FlightAPI.Repository.FlightRepo;
import com.FlightAPI.Repository.PassengerRepo;
import com.FlightAPI.Service.PassengerService;
import com.FlightAPI.entity.Flight;
import com.FlightAPI.entity.Passenger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private PassengerRepo passengerRepo;

    @Autowired
    private FlightRepo flightRepo;
//    @Override
//    public PassengerDTO savePassenger(long flightId, PassengerDTO passengerDTO) {
//
//        Flight flight = flightRepo.findById(flightId).orElseThrow(
//                () -> new EntityNotFoundException("flight not found with flight id" + flightId)
//        );
//
//        Passenger passenger = mapToEntity(passengerDTO);
//
//        Passenger save = passengerRepo.save(passenger);
//        return mapToDto(save);
//    }
//
//    public PassengerDTO mapToDto(Passenger passenger){
//        PassengerDTO dto = modelMapper.map(passenger, PassengerDTO.class);
//        return dto;
//    }
//
//    public Passenger mapToEntity(PassengerDTO passengerDTO){
//        Passenger save = modelMapper.map(passengerDTO, Passenger.class);
//        return save;
//    }
}
