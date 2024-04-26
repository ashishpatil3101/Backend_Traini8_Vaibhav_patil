package com.example.buyogo.transformers;

import com.example.buyogo.dto.request.TrainingCentreRequestDto;
import com.example.buyogo.model.Address;
import com.example.buyogo.model.TrainingCentre;

public class AddressTransformer {

    public static Address prepareAddressObj(TrainingCentreRequestDto trainingCentreRequestDto, TrainingCentre trainingCentre){

        return trainingCentreRequestDto != null ? Address.builder()
                .city(trainingCentreRequestDto.getCity())
                .detailedAddress(trainingCentreRequestDto.getDetailedAddress())
                .state(trainingCentreRequestDto.getState())
                .pincode(trainingCentreRequestDto.getPincode())
                .build(): Address.builder()
                .city(trainingCentre.getAddress().getCity())
                .detailedAddress(trainingCentre.getAddress().getDetailedAddress())
                .state(trainingCentre.getAddress().getState())
                .pincode(trainingCentre.getAddress().getPincode())
                .build();
    }
}
