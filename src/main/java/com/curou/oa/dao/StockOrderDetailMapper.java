package com.curou.oa.dao;

import com.curou.oa.models.StockOrderDetail;
import com.curou.oa.models.StockOrderDetailExample;
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

public interface StockOrderDetailMapper {
    @SelectProvider(type=StockOrderDetailSqlProvider.class, method="countByExample")
    long countByExample(StockOrderDetailExample example);

    @DeleteProvider(type=StockOrderDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(StockOrderDetailExample example);

    @Delete({
        "delete from stock_order_detail",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into stock_order_detail (id, product_id, ",
        "spec_detail, order_id, ",
        "count, unit)",
        "values (#{id,jdbcType=VARCHAR}, #{productId,jdbcType=VARCHAR}, ",
        "#{specDetail,jdbcType=VARCHAR}, #{orderId,jdbcType=VARCHAR}, ",
        "#{count,jdbcType=BIGINT}, #{unit,jdbcType=VARCHAR})"
    })
    int insert(StockOrderDetail record);

    @InsertProvider(type=StockOrderDetailSqlProvider.class, method="insertSelective")
    int insertSelective(StockOrderDetail record);

    @SelectProvider(type=StockOrderDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_detail", property="specDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="count", property="count", jdbcType=JdbcType.BIGINT),
        @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR)
    })
    List<StockOrderDetail> selectByExample(StockOrderDetailExample example);

    @Select({
        "select",
        "id, product_id, spec_detail, order_id, count, unit",
        "from stock_order_detail",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_detail", property="specDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="count", property="count", jdbcType=JdbcType.BIGINT),
        @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR)
    })
    StockOrderDetail selectByPrimaryKey(String id);

    @UpdateProvider(type=StockOrderDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StockOrderDetail record, @Param("example") StockOrderDetailExample example);

    @UpdateProvider(type=StockOrderDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StockOrderDetail record, @Param("example") StockOrderDetailExample example);

    @UpdateProvider(type=StockOrderDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StockOrderDetail record);

    @Update({
        "update stock_order_detail",
        "set product_id = #{productId,jdbcType=VARCHAR},",
          "spec_detail = #{specDetail,jdbcType=VARCHAR},",
          "order_id = #{orderId,jdbcType=VARCHAR},",
          "count = #{count,jdbcType=BIGINT},",
          "unit = #{unit,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(StockOrderDetail record);
}