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
public class BlogCommont implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer atricleid;

    /**
     * 回复内容
     */
    private String content;

    private LocalDateTime createtime;

    /**
     * 是否删除
     */
    private Integer deleted;


}
