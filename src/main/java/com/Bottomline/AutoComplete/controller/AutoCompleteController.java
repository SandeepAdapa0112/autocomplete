package com.Bottomline.AutoComplete.controller;

import com.Bottomline.AutoComplete.service.AutoCompleteService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.apache.commons.text.CaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class AutoCompleteController {

    @Autowired
    private AutoCompleteService autoCompleteService;

    @GetMapping("/getAllEmployees")
    public List<String> getAllEmployeesList( @RequestParam @NotBlank(message = "Searched word should not be blank")@Pattern.List({
            @Pattern(regexp = "^[\\p{Alpha}]*$", message = "Name should contain only alphabets"),
            @Pattern(regexp = "^[^\\s].*$", message = "Name should not start with space")
    }) String searchName)
    {
        String employeeName = CaseUtils.toCamelCase(searchName,true);
        return autoCompleteService.findEmployees(employeeName);
    }
}
