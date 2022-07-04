package com.learnings.user.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Department {

    private long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
