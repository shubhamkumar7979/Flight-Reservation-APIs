package com.FlightAPI.entity;

import com.FlightAPI.Payload.FlightDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {

    private List<FlightDTO> content;
    private int pageNo;
    private int pageSize;
    private long totalElement;
    private int totalPage;
    private boolean last;

}
