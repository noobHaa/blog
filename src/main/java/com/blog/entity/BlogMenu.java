package com.blog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lilei
 * @since 2019-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    /**
     * 父级菜单id
     */
    private Integer parentid;

    /**
     * 菜单等级
     */
    private Integer level;

    /**
     * 序号
     */
    private Integer sort;

    private LocalDateTime createtime;

    private LocalDateTime updatetime;

    private Integer deleted;


}
