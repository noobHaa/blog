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
public class BlogReply implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 回复评论的id
     */
    private Integer commontid;

    private String content;

    private LocalDateTime createtime;

    private Integer deleted;


}
