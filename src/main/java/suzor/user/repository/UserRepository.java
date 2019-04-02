package suzor.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import suzor.user.model.po.UserPO;

import javax.validation.constraints.NotNull;

@Repository
@Mapper
public interface UserRepository {
    void insertThenGetId(@NotNull UserPO userPO);

    UserPO findById(@NotNull @Param("id") Integer id);

    UserPO findByUserId(@NotNull @Param("userId") String id);
}
