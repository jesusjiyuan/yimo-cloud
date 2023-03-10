package com.yimo.common.log.service;

import com.yimo.system.api.feign.RemoteLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.yimo.common.core.constant.SecurityConstants;
import com.yimo.system.api.domain.SysOperLog;

/**
 * 异步调用日志服务
 * 
 * @author yimo
 */
@Service
public class AsyncLogService
{
    @Autowired
    private RemoteLogService remoteLogService;

    /**
     * 保存系统日志记录
     */
    @Async
    public void saveSysLog(SysOperLog sysOperLog)
    {
        remoteLogService.saveLog(sysOperLog, SecurityConstants.INNER);
    }
}
