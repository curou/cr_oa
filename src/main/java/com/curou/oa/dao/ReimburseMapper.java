package com.curou.oa.dao;

import com.curou.oa.models.Reimburse;
import com.curou.oa.models.ReimburseExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ReimburseMapper {
    @SelectProvider(type=ReimburseSqlProvider.class, method="countByExample")
    long countByExample(ReimburseExample example);

    @DeleteProvider(type=ReimburseSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReimburseExample example);

    @Delete({
        "delete from reimburse",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into reimburse (id, content, ",
        "amount, user_id, ",
        "status, create_time_utc, ",
        "modify_time_utc, create_employee_id, ",
        "modify_employee_id, task_id, ",
        "remark, user_name)",
        "values (#{id,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{amount,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{createTimeUtc,jdbcType=TIMESTAMP}, ",
        "#{modifyTimeUtc,jdbcType=TIMESTAMP}, #{createEmployeeId,jdbcType=VARCHAR}, ",
        "#{modifyEmployeeId,jdbcType=VARCHAR}, #{taskId,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR})"
    })
    int insert(Reimburse record);

    @InsertProvider(type=ReimburseSqlProvider.class, method="insertSelective")
    int insertSelective(Reimburse record);

    @SelectProvider(type=ReimburseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
    })
    List<Reimburse> selectByExample(ReimburseExample example);

    @Select({
        "select",
        "id, content, amount, user_id, status, create_time_utc, modify_time_utc, create_employee_id, ",
        "modify_employee_id, task_id, remark, user_name",
        "from reimburse",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
    })
    Reimburse selectByPrimaryKey(String id);

    @UpdateProvider(type=ReimburseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Reimburse record, @Param("example") ReimburseExample example);

    @UpdateProvider(type=ReimburseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Reimburse record, @Param("example") ReimburseExample example);

    @UpdateProvider(type=ReimburseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Reimburse record);

    @Update({
        "update reimburse",
        "set content = #{content,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP},",
          "create_employee_id = #{createEmployeeId,jdbcType=VARCHAR},",
          "modify_employee_id = #{modifyEmployeeId,jdbcType=VARCHAR},",
          "task_id = #{taskId,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Reimburse record);
}