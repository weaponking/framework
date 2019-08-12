package com.framework.base.vo;

import lombok.Data;
import java.io.Serializable;

@Data
public class BaseCondation implements Serializable {

    private long id; //primary key
    private boolean delFlag; //1 deleted

}
