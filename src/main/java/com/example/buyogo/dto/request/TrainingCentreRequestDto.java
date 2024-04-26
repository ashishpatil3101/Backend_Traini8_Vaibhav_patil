package com.example.buyogo.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TrainingCentreRequestDto {

    @NotBlank(message = "CenterName is required")
    @Size(max = 40, message = "CenterName must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "CenterCode is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "CenterCode must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Positive(message = "Student capacity should be positive value")
    private Integer studentCapacity;
    private List<String> coursesOffered;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "ContactPhone is required")
    @Pattern(regexp = "\\d{10}", message = "Invalid phone number format")
    private String contactPhone;

    @NotBlank(message = "Detailed address is required")
    private String detailedAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Pincode is required")
    private String pincode;
}
