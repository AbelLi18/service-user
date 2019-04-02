package framework.mybatis.repository;

import framework.mybatis.TestPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestRepository {
    void add(TestPO testPO);
    void select(int id);
}
