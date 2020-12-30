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
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("F_ID")
    private Integer fId;

    @TableField("F_Name")
    private String fName;

    @TableField("F_Pass")
    private String fPass;

    @TableField("F_TrueName")
    private String fTruename;

    @TableField("F_Right")
    private String fRight;

    @TableField("F_Time")
    private String fTime;

    @TableField("F_Depart")
    private String fDepart;

    @TableField("F_Memo")
    private String fMemo;


}
