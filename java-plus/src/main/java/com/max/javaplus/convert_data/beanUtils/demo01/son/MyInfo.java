package com.max.javaplus.convert_data.beanUtils.demo01.son;

import com.max.javaplus.convert_data.beanUtils.demo01.father.UpInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MyInfo
 * @date 2021/4/19 12:03
 * @desc
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class MyInfo extends UpInfo {
    public MyInfo() {
    }

    public MyInfo(String str, Integer num) {
        super(str, num);
    }
}
