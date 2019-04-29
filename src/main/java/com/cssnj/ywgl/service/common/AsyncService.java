package com.cssnj.ywgl.service.common;

import com.cssnj.ywgl.domain.user.UserExtend;
import com.cssnj.ywgl.domain.user.UserExtendMapper;
import com.cssnj.ywgl.dto.user.LoginInfo;
import com.cssnj.ywgl.utils.ApplicationUtil;
import com.cssnj.ywgl.utils.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Auther: duq
 * @Date: 2018/12/3 10:07
 */
@Component
public class AsyncService {


    @Autowired
    private UserExtendMapper userExtendMapper;


    @Async
    public void refreshUserExtend() {
        LoginInfo loginInfo = (LoginInfo) SecurityUtils.getSubject().getPrincipal();
        UserExtend userExtend = new UserExtend();
        userExtend.setDlsj(DateUtil.parseStringToUtil(loginInfo.getDlsj()));
        if (!StringUtils.isEmpty(loginInfo.getScdlsj())) {
            userExtend.setScdlsj(DateUtil.parseStringToUtil(loginInfo.getScdlsj()));
        }
        userExtend.setDlcs(Integer.parseInt(loginInfo.getDlcs()));
        userExtend.setYhId(loginInfo.getYhId());
        if (StringUtils.isEmpty(loginInfo.getYhkzId())) {
            userExtend.setId(ApplicationUtil.createDBID());
            userExtend.setLrry(loginInfo.getYhId());
            userExtend.setLrsj(DateUtil.getNowSqlDate());
            userExtendMapper.insert(userExtend);
        } else {
            userExtend.setId(loginInfo.getYhkzId());
            userExtend.setXgry(loginInfo.getYhId());
            userExtend.setXgsj(DateUtil.getNowSqlDate());
            userExtendMapper.updateByPrimaryKeySelective(userExtend);
        }
    }

}
