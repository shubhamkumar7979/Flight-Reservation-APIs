package com.FlightAPI.Service;

import com.FlightAPI.Payload.ReservationDto;
import com.FlightAPI.Payload.ReservationRequest;
import com.FlightAPI.entity.Reservation;

public interface ReservationService {
    ReservationDto saveReser(long flightId, long passengerId,long rid, ReservationDto reservationDto);

    Reservation bookFlight(long id,ReservationRequest request);
}
