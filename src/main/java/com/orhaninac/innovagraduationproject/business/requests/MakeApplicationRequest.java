package com.orhaninac.innovagraduationproject.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MakeApplicationRequest {
    String identityNumber;
    int creditScore;
}
