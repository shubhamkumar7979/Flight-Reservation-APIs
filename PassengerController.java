package com.FlightAPI.Controller;

import com.FlightAPI.Payload.PassengerDTO;
import com.FlightAPI.Service.PassengerService;
import com.FlightAPI.Utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PassengerController {

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private PassengerService passengerService;

    //http://localhost:8080/api/res/flightId/1/passenger

//    //http://localhost:8080/flights/api/1/savepassenger
//    @PostMapping("/{flightId}/savepassenger")
//    public ResponseEntity<PassengerDTO> savePassenger(@PathVariable("flightId") long flightId, @RequestBody PassengerDTO passengerDTO){
//        PassengerDTO dto = passengerService.savePassenger(flightId ,passengerDTO);
//
//        emailUtil.sendEmail(passengerDTO.getEmail(), "Please check your details", String.valueOf(passengerDTO));
//        return new ResponseEntity<>(dto, HttpStatus.CREATED);
//    }
}
