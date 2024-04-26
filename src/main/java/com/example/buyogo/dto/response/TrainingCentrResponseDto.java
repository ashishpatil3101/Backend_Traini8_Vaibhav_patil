package com.example.buyogo.dto.response;

import com.example.buyogo.model.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrainingCentrResponseDto {
    private  Long id;
    private String centerName;
    private String centerCode;

    private Integer studentCapacity;
    private List<String> coursesOffered;

    private String contactEmail;
    private String contactPhone;

    private Address address;

    private Long createdOn;
}
