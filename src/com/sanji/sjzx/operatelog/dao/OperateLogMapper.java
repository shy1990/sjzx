package com.sanji.sjzx.operatelog.dao;

import com.sanji.sjzx.model.OperateLog;

public interface OperateLogMapper {
    int insert(OperateLog record);

    int insertSelective(OperateLog record);
}