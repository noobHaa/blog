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
public class BlogThumbsup implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 点赞用户
     */
    private Integer userid;

    /**
     * 评论id
     */
    private Integer commontid;

    /**
     * 踩0 赞1  
     */
    private Integer flag;

    private LocalDateTime createtime;

    private LocalDateTime updatetime;

    private Integer deleted;


}
