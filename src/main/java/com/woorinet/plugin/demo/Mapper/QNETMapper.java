package com.woorinet.plugin.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QNETMapper {
    void initDatabase() throws Exception;
}
