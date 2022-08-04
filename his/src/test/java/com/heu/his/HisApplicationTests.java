package com.heu.his;

import com.heu.his.mapper.SchedulingzgyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HisApplicationTests {

    @Autowired
    SchedulingzgyMapper schedulingzgyMapper;

    @Test
    void contextLoads() {
        schedulingzgyMapper.getSchedulingList("2019-04-02","2019-04-04");
    }

}
