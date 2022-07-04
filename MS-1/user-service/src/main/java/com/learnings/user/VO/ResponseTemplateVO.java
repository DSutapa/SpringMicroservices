package com.learnings.user.VO;

import com.learnings.user.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    @Autowired
    private Department department;
    @Autowired
    private Users users;
}
