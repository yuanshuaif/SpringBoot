package com.lsj.springboot.async;

import com.lsj.springboot.entity.UserAnnotation;
import org.springframework.aop.framework.AopContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 10326 on 2020/4/4.
 */
@Service
public class UserServiceImpl implements IUserService {

    // ((IUserService)AopContext.currentProxy()).senMsg(user);解决自定义调用失效
    // 异常：Cannot find current proxy: Set 'exposeProxy' property on Advised to 'true' to make it available.
    // 解决 @EnableAspectJAutoProxy(exposeProxy = true)
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(UserAnnotation user) {
        user.setAge(20);
        user.setName("ys");
        user.setPhone("17801000712");
        ((IUserService)AopContext.currentProxy()).senMsg(user);
        System.out.println("hello");
    }

   /* // 2.自定义失效 start
    @Override
    public void save(UserAnnotation user) {
        user.setAge(20);
        user.setName("ys");
        user.setPhone("17801000712");
        this.senMsg(user);
        System.out.println("hello");
    }
    // 自定义失效 end*/

  /*  // 1.循环依赖异常 start
    @Autowired
    private IUserService userService;
    @Override
    public void save(UserAnnotation user) {
        user.setAge(20);
        user.setName("ys");
        user.setPhone("17801000712");
        userService.senMsg(user);
    }
    // 循环依赖异常 end*/

    @Async
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Boolean senMsg(UserAnnotation user) {
        try {
            Thread.sleep(2000);
            System.out.println("发送短信中:.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "给用户" + user.getName() + "发送短信成功");
        return true;
    }
}
