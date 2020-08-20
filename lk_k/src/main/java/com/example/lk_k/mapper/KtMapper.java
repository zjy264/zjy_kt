package com.example.lk_k.mapper;

import com.example.lk_k.entity.Kt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author write by zjy
 * @since 2020-08-20
 */
public interface KtMapper extends BaseMapper<Kt> {
    @Update("truncate table m_kt")
    void delete();
}
