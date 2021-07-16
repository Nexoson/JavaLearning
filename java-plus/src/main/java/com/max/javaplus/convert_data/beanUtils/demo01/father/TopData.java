package com.max.javaplus.convert_data.beanUtils.demo01.father;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className TopData
 * @date 2021/4/20 20:09
 * @desc 爸爸的爸爸叫爷爷
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopData<T> implements Serializable {
    private String key;

    private List<T> infos;
}
