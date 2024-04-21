package com.kubernetis.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ResponseDto {

    private String status;

    private String statusMessage;

}
