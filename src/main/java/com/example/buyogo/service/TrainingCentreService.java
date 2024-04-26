package com.example.buyogo.service;

import com.example.buyogo.dto.request.TrainingCentreRequestDto;
import com.example.buyogo.dto.response.TrainingCentrResponseDto;
import com.example.buyogo.model.TrainingCentre;
import com.example.buyogo.repository.TrainingCentreRepository;
import com.example.buyogo.transformers.AddressTransformer;
import com.example.buyogo.transformers.TrainingCentreTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingCentreService {

    TrainingCentreRepository trainingCentreRepository;

    @Autowired
    public TrainingCentreService(TrainingCentreRepository trainingCentreRepository){
        this.trainingCentreRepository=trainingCentreRepository;
    }
    public TrainingCentrResponseDto addTrainingCentre(TrainingCentreRequestDto trainingCentreRequestDto){
        //prepare training centre obj
        TrainingCentre trainingCentre= TrainingCentreTransformers.prepareTrainCentreObject(trainingCentreRequestDto);
        TrainingCentre  savedTraningCentre = trainingCentreRepository.save(trainingCentre);//save to db
        // prepare response obj for th client
        TrainingCentrResponseDto trainingCentrResponseDto = TrainingCentreTransformers.prepareTrainingCentreResObj(savedTraningCentre);
        trainingCentrResponseDto.setAddress(AddressTransformer.prepareAddressObj(trainingCentreRequestDto , null));
        return trainingCentrResponseDto;
    }

    public List<TrainingCentrResponseDto> getTrainingCentre(String city,
                                                            String centerName,
                                                            String centerCode,
                                                            String courseName,
                                                            Integer studentCapacity
                                                           )
    {
        //sorting specification. will add all the properties user choose to filter
        Specification<TrainingCentre> spec = Specification.where(null);
        spec = TrainingCentreTransformers.prepareSortingParams(city,centerName,centerCode,courseName,studentCapacity,spec);
        //get all/specific training centres
        List<TrainingCentre> trainingCentreList = trainingCentreRepository.findAll(spec);
        //prepare response obj for client
        return trainingCentreRepository.findAll(spec)
                .stream()
                .map(trainingCentre -> {
                    TrainingCentrResponseDto responseDto = TrainingCentreTransformers.prepareTrainingCentreResObj(trainingCentre);
                    responseDto.setAddress(trainingCentre.getAddress());
                    return responseDto;
                })
                .collect(Collectors.toList());
    }


}
