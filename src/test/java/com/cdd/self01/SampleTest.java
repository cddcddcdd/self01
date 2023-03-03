package com.cdd.self01;

import com.cdd.self01.repository.mapper.UserMapper;
import com.cdd.self01.repository.po.UserPO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UserPO> userList = userMapper.selectList(null);
        Assert.assertEquals(2, userList.size());
        userList.forEach(System.out::println);
    }
}
