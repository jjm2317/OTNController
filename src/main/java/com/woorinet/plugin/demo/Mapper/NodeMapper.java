package com.woorinet.plugin.demo.Mapper;

import com.woorinet.plugin.demo.DTO.Node;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NodeMapper {
    public List<Node> selectNode() throws Exception;
    public void insertNode(Node node) throws Exception;
    public void initDatabase() throws Exception;
    public void initTable() throws Exception;
}