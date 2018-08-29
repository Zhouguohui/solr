package com.zgh;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.zgh.springboot.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);
    @Autowired
    User user;

    @Autowired
    DataSource dataSource;

    @Test
    public void dataTest() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        ((Connection) conn).close();
    }

    @Test
    public void contextLoads() {
        logger.info("11111111");
        System.out.println(user.toString());
        logger.info("22222222");
    }

}
