package org.zzh.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：ZiHao Zhang
 * @date ：2022/3/21 11:20
 */

@Data
@Builder
public class User implements Serializable {
    private Integer id;
    private String userName;
    private Boolean sex;
}
