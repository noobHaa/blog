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
public class BlogArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String titile;

    private String content;

    /**
     * 作者id
     */
    private Integer userid;

    /**
     * 文章类别
     */
    private Integer categoryid;

    private LocalDateTime createtime;

    private LocalDateTime updatetime;

    private Integer deleted;


}
