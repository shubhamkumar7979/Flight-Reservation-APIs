package com.FlightAPI.Payload;

import lombok.Data;

@Data
public class ReservationRequest {

    private long flightId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
}
