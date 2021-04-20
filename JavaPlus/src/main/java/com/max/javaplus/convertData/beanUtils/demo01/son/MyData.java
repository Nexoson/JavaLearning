package com.max.javaplus.convertData.beanUtils.demo01.son;

import com.max.javaplus.convertData.beanUtils.demo01.father.TopData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MyData
 * @date 2021/4/19 12:03
 * @desc
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MyData extends TopData<MyInfo> {

    private String key;

    private List<MyInfo> infos;

    public MyData(String key, List<MyInfo> infos) {
        super(key, infos);
        this.key = key;
        this.infos = infos;
    }


}
