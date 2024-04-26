package com.example.buyogo.service;

import com.example.buyogo.dto.request.TrainingCentreRequestDto;
import com.example.buyogo.dto.response.TrainingCentrResponseDto;
import com.example.buyogo.model.TrainingCentre;
import com.example.buyogo.repository.TrainingCentreRepository;
import com.example.buyogo.transformers.AddressTransformer;
import com.example.buyogo.transformers.TrainingCentreTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<TrainingCentrResponseDto> getTrainingCentre(){
        //get all training centre
        List<TrainingCentre> trainingCentreList = trainingCentreRepository.findAll();
        //prepare response obj for client
        List<TrainingCentrResponseDto> response= new ArrayList<>();
        for(TrainingCentre trainingCentre: trainingCentreList) {
            TrainingCentrResponseDto trainingCentrResponseDto = TrainingCentreTransformers.prepareTrainingCentreResObj(trainingCentre);
            trainingCentrResponseDto.setAddress(trainingCentre.getAddress());
            response.add(trainingCentrResponseDto);
        }
        return response;
    }
}
