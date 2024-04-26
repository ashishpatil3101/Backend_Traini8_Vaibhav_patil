package com.example.buyogo.transformers;

import com.example.buyogo.dto.request.TrainingCentreRequestDto;
import com.example.buyogo.dto.response.TrainingCentrResponseDto;
import com.example.buyogo.model.TrainingCentre;

import java.util.Date;

public class TrainingCentreTransformers {

    public static TrainingCentre prepareTrainCentreObject(TrainingCentreRequestDto trainingCentreRequestDto){

        return TrainingCentre.builder()
                .centerCode(trainingCentreRequestDto.getCenterCode())
                .centerName(trainingCentreRequestDto.getCenterName())
                .studentCapacity(trainingCentreRequestDto.getStudentCapacity())
                .coursesOffered(trainingCentreRequestDto.getCoursesOffered())
                .createdOn(System.currentTimeMillis())
                .contactEmail(trainingCentreRequestDto.getContactEmail())
                .contactPhone(trainingCentreRequestDto.getContactPhone())
                .address(AddressTransformer.prepareAddressObj(trainingCentreRequestDto ,null))
                .build();
    }

    public static TrainingCentrResponseDto prepareTrainingCentreResObj(TrainingCentre trainingCentre){

        return TrainingCentrResponseDto.builder()
                .id(trainingCentre.getId())
                .centerCode(trainingCentre.getCenterCode())
                .centerName(trainingCentre.getCenterName())
                .createdOn(trainingCentre.getCreatedOn())
                .studentCapacity(trainingCentre.getStudentCapacity())
                .coursesOffered(trainingCentre.getCoursesOffered())
                .contactEmail(trainingCentre.getContactEmail())
                .contactPhone(trainingCentre.getContactPhone())
                .build();
    }
}
