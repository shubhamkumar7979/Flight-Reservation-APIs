package com.FlightAPI.Controller;

import com.FlightAPI.Payload.FlightDTO;
import com.FlightAPI.Service.FlightService;
import com.FlightAPI.entity.FlightResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    private FlightService flightService;

    //http://localhost:8080/api/saveflight
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/saveflight")
    public ResponseEntity<Object> saveFlight(@Valid @RequestBody FlightDTO flightDTO , BindingResult result){

        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        FlightDTO dto = flightService.saveflight(flightDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/1
    @GetMapping("/{flightId}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable("flightId") long flightId){
        FlightDTO dto = flightService.getFlightById(flightId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //http://localhost:8080/api/flights?pageNo=0&pageSize=5&sotyBy=flightId&sortDir=asc
    @GetMapping("/flights")
    public FlightResponse getAllFlight(@RequestParam(value = "pageNo",defaultValue = "0", required = false) int pageNo,
                                       @RequestParam(value = "pageSize", defaultValue = "10",required = false) int pageSize,
                                       @RequestParam(value = "sortBy",defaultValue = "flightId", required = false) String sortBy,
                                       @RequestParam(value = "sortDir", defaultValue = "ASC",required = false) String sortDir){
        return flightService.getAllFlight(pageNo,pageSize,sortBy,sortDir);

    }

    //http://localhost:8080/api/1
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{flightId}")
    public ResponseEntity<FlightDTO> updateFlightById(@RequestBody FlightDTO flightDTO, @PathVariable("flightId") long flightId ){
        FlightDTO dto = flightService.updateById(flightDTO, flightId);
        return  new ResponseEntity<>(dto,HttpStatus.OK);

    }

   //http://localhost:8080/api/1
   @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{flightId}")
    public ResponseEntity<String> deleteById(@PathVariable("flightId") long flightId){
        flightService.deleteById(flightId);

        return new ResponseEntity<>("flight deleted", HttpStatus.OK);
    }


    //http://localhost:8080/api/search?from=delhi&to=bihar
    @GetMapping("/search")
    public List<FlightDTO> findFlight(@RequestParam("from") String from,@RequestParam("to") String to){

        return flightService.findFlights(from, to);
    }

}
