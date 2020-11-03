package com.cxy.service.Impl;

import com.cxy.dao.UserMapper;
import com.cxy.domin.User;
import com.cxy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/27 21:09
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUser(Integer id) {
        return userMapper.selectId(id);
    }

    /**
     * 编程式事务管理
     * @param user
     * @return
     */
    @Override
    public int insert(User user) {
        //如果不想在这里强制转换为boolean ，则可以将下面46行，48行代码的Object更改为Boolean
        boolean ok = (boolean) transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    Integer result = userMapper.insert(user);
                    /**
                     * 测试下：事务的回滚机制，上面的语句可以执行成功，下面的语句执行失败
                     */
                    String aaa = null;
                    System.out.println(aaa.toString());
                }catch (DuplicateKeyException e){
                    logger.info("重复请求");
                }catch (Exception e){
                    transactionStatus.setRollbackOnly();
                    logger.error("新增结算明细失败",e);
                    return false;
                }
                return true;
            }
        });
        Assert.isTrue(ok,"插入信息失败");
        return user.getId();
    }
}