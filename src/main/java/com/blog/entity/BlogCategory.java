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
public class BlogCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String categoryname;

    /**
     * 父级类型
     */
    private Integer categoryparentid;

    private Integer level;

    private Integer sort;

    private LocalDateTime createtime;

    private LocalDateTime updatetime;

    private Integer deleted;


}
