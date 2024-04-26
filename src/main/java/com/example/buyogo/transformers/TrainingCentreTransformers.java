package com.example.buyogo.transformers;

import com.example.buyogo.dto.request.TrainingCentreRequestDto;
import com.example.buyogo.dto.response.TrainingCentrResponseDto;
import com.example.buyogo.model.TrainingCentre;
import org.springframework.data.jpa.domain.Specification;

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
    public static Specification prepareSortingParams(String city,
                                     String centerName,
                                     String centerCode,
                                     String courseName,
                                     Integer studentCapacity, Specification spec
                                     )
    {
        if (centerName != null && !centerName.isEmpty()) {
            spec = spec.and((root, query, builder) ->
                    builder.like(root.get("centerName"), "%" + centerName + "%")
            );
        }
        if (city != null && !city.isEmpty()) {
            spec = spec.and((root, query, builder) ->
                    builder.equal(root.get("address").get("city"), city)
            );
        }
        if (centerCode != null && !centerCode.isEmpty()) {
            spec = spec.and((root, query, builder) ->
                    builder.equal(root.get("centerCode"), centerCode)
            );
        }
        if (courseName != null && !courseName.isEmpty()) {
            spec = spec.and((root, query, builder) ->
                    builder.isMember(courseName, root.get("coursesOffered"))
            );
        }
        if (studentCapacity != null) {
            spec = spec.and((root, query, builder) ->
                    builder.lessThanOrEqualTo(root.get("studentCapacity"), studentCapacity)
            );
        }
        return spec;
    }
}
