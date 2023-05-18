package com.FlightAPI.Payload;

import lombok.Data;
import lombok.Getter;

@Data
public class PassengerDTO {

    private long passengerId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
}
