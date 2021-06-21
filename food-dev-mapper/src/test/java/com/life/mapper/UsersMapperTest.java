package com.life.mapper;

import com.life.pojo.Users;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UsersMapperTest extends TestCase {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void test() {
        List<Users> users = usersMapper.selectByExample(null);
        users.forEach(item -> {
            System.out.println(item);
        });
    }
}