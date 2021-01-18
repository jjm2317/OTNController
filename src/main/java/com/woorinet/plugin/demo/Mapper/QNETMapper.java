package com.woorinet.plugin.demo.Mapper;

import com.woorinet.plugin.demo.DTO.QNET.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QNETMapper {

    void initDatabase() throws Exception;
    void initNodeTable() throws Exception;

    void insertNode(NODE node)  throws Exception;
}
