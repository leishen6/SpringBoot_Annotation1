package com.lyl.demo2.entry;/**
 * Created with IDEA
 * Description：
 * Date: 2019-05-06 14:17
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *@ClassName:JavaBesn
 *@Description:TODO
 *@date: 2019-05-06 14:17
 **/
@Component
public class JavaBesn {
      @Value("${person.last-name}")
      private String lastName;
}
