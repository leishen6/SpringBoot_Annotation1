package com.lyl.demo2.control;/**
 * Created with IDEA
 * Description：
 * Date: 2019-05-06 11:21
 */

import com.lyl.demo2.annotation.MyLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName:HelloWorld
 *@Description:TODO
 *@date: 2019-05-06 11:21
 **/
@RestController
@PropertySource(value = {"classpath:person.properties"})//加载指定的properties配置文件
@Slf4j
public class HelloWorld {
    @Value("${person.last-name}")//在配置文件中根据key获取值
    private String name;

    @MyLog
    @RequestMapping(value = "/helloworld/{id}",method = RequestMethod.GET)
    public String helloWorld(@PathVariable String id){
          log.info(name + "  parm："+id);
          return "hello world："+name;
    }

}
