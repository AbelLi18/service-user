package framework.mybatis.test;

import framework.BaseTest;
import framework.mybatis.TestPO;
import framework.mybatis.repository.TestRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisTest extends BaseTest {
    @Autowired
    private TestRepository testRepository;

    @Test
    public void add() {
        TestPO testPO = new TestPO();
        testRepository.add(testPO);
    }
}
