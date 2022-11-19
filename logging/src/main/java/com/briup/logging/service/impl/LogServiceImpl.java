package com.briup.logging.service.impl;

import com.briup.logging.service.ILogService;
import com.briup.user.bean.Log;
import com.briup.user.dao.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.logging.LogManager;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/18/2022-11-18-2:04 AM
 * @Description：com.briup.logging.aspect
 */
@Service
public class LogServiceImpl implements ILogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public void add(Log log) {
        logMapper.insert(log);
    }
}
