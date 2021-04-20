package com.max.javaplus.convertData.beanUtils.demo01.father;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className UpData
 * @date 2021/4/19 11:56
 * @desc 父类
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class UpData extends TopData<UpInfo> {

    public UpData() {
    }

    public UpData(String key, List<UpInfo> infos) {
        super(key, infos);
    }

}
