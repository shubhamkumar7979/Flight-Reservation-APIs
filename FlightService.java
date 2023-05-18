package com.FlightAPI.Service;

import com.FlightAPI.Payload.FlightDTO;
import com.FlightAPI.entity.FlightResponse;

import java.util.List;

public interface FlightService {
    public FlightDTO saveflight(FlightDTO flightDTO);

    FlightDTO getFlightById(long flightId);

   FlightResponse getAllFlight(int pageNo, int pageSize, String sortBy, String sortDir);

    FlightDTO updateById(FlightDTO flightDTO, long flightId);

    void deleteById(long flightId);

    List<FlightDTO> findFlights(String from, String to);
}
