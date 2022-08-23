package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * purpose:creating candidate technology dto and adding validation on candidate technology dto
 * @author Anuj Solanki
 */
@Data
public class TechStackDTO {
    @NotEmpty(message = "imagePath Can't be Null.")
    private String imagePath;
    private boolean status;
    @NotEmpty(message = "techName is required")
    private String techName;

}
