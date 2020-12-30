package com.jingruan.weighsystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sfweight
 * @since 2020-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TNote implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("F_ID")
    private Integer fId;

    @TableField("F_OpMan")
    private String fOpman;

    @TableField("F_Type")
    private String fType;

    @TableField("F_Text")
    private String fText;

    @TableField("F_DateTime")
    private String fDatetime;

    @TableField("F_Depart")
    private String fDepart;

    @TableField("F_EText")
    private String fEtext;

    @TableField("F_ETime")
    private String fEtime;


}
