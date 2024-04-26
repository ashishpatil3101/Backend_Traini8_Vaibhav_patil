package com.example.buyogo.controller;

import com.example.buyogo.dto.request.TrainingCentreRequestDto;
import com.example.buyogo.exception.TrainingCentreValidationException;
import com.example.buyogo.service.TrainingCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainingCentre")
public class TrainingCentreController {

    TrainingCentreService trainingCentreService;

    @Autowired
    public TrainingCentreController(TrainingCentreService trainingCentreService) {
        this.trainingCentreService = trainingCentreService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTrainingCentre(@Validated @RequestBody TrainingCentreRequestDto trainingCentreRequestDto, BindingResult result) throws Exception {
        // if the user input validation fails then error gets populated
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
           throw  new TrainingCentreValidationException("Validation error: " + errors);
        }
        // user input is correct ,call to service layer
        try {
            return new ResponseEntity<>(trainingCentreService.addTrainingCentre(trainingCentreRequestDto), HttpStatus.CREATED);
        } catch (Exception ex) {
            throw  new Exception("An error occurred while adding the training centre.");
        }
    }

    @GetMapping("/get")
    public ResponseEntity getTrainingCentre() throws Exception {
        try{
            return new ResponseEntity<>(trainingCentreService.getTrainingCentre(), HttpStatus.CREATED);
        }
        catch (Exception e ){
            throw  new Exception("An erro occured while fetching all training centre.");
        }
    }
}
