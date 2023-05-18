package com.FlightAPI.Service.Impl;

import com.FlightAPI.Payload.FlightDTO;
import com.FlightAPI.Repository.FlightRepo;
import com.FlightAPI.Service.FlightService;
import com.FlightAPI.entity.Flight;
import com.FlightAPI.entity.FlightResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FlightDTO saveflight(FlightDTO flightDTO) {
        Flight flight = mapToEntity(flightDTO);
        Flight save = flightRepo.save(flight);

        return mapToDto(save);
    }

    @Override
    public FlightDTO getFlightById(long flightId) {
        Optional<Flight> byId = flightRepo.findById(flightId);
        Flight flight = byId.get();
        return mapToDto(flight);
    }

    @Override
    public FlightResponse getAllFlight(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort= sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);

        Page<Flight> flights = flightRepo.findAll(pageable);

        // get content for page object
        List<Flight> contents = flights.getContent();

        List<FlightDTO> flightDtos = contents.stream().map(flight -> mapToDto(flight)).collect(Collectors.toList());


        FlightResponse flightResponse= new FlightResponse();
        flightResponse.setContent(flightDtos);
        flightResponse.setPageSize(flights.getSize());
        flightResponse.setPageNo(flights.getNumber());
        flightResponse.setTotalElement(flights.getTotalElements());
        flightResponse.setTotalPage(flights.getTotalPages());
        flightResponse.setLast(flights.isLast());

        return flightResponse;
    }

    @Override
    public FlightDTO updateById(FlightDTO flightDTO, long flightId) {
        Flight flight = flightRepo.findById(flightId).orElseThrow(
                () -> new EntityNotFoundException("POST NOT FOUND WITH ID" + flightId)
        );
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setDateOfDeparture(flightDTO.getDateOfDeparture());
        flight.setEstimatedDepartureTime(flightDTO.getEstimatedDepartureTime());
        flight.setOperatingAirlines(flightDTO.getOperatingAirlines());
        flight.setArrivalCity(flightDTO.getArrivalCity());
        flight.setDepartureCity(flightDTO.getDepartureCity());

        Flight newFlight = flightRepo.save(flight);

        return mapToDto(newFlight);
    }

    @Override
    public void deleteById(long flightId) {
        Flight flight = flightRepo.findById(flightId).orElseThrow(
                () -> new EntityNotFoundException("FLight not found with id" + flightId)
        );

        flightRepo.delete(flight);
    }

    @Override
    public List<FlightDTO> findFlights(String from, String to) {
        List<Flight> flights = flightRepo.findFlights(from, to);
        return flights.stream().map(flight -> mapToDto(flight)).collect(Collectors.toList());
    }

    public FlightDTO mapToDto(Flight flight){
        FlightDTO flightDTO = modelMapper.map(flight, FlightDTO.class);
        return flightDTO;
    }

    public Flight mapToEntity(FlightDTO flightDTO){
        Flight flight = modelMapper.map(flightDTO, Flight.class);
        return flight;
    }
}
