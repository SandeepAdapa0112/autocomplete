package com.Bottomline.AutoComplete.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class ErrorResponse {

    private int status;
    private Date timestamp;
    private String error;
    private String path;

}
