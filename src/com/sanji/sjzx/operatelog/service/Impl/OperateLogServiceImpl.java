package com.sanji.sjzx.operatelog.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sanji.sjzx.annotation.SystemServiceLog;
import com.sanji.sjzx.model.OperateLog;
import com.sanji.sjzx.operatelog.dao.OperateLogMapper;
import com.sanji.sjzx.operatelog.service.OperateLogService;
/**
 * @ClassName: OperateLogService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author SongBaoZhen
 * @date 20136-2-15 下午5:27:28
 *
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {
	@Resource
	private OperateLogMapper operateLogMapper;

	
	public void addOperateLog(OperateLog operateLog) {
		operateLogMapper.insert(operateLog);
	}
	
}
