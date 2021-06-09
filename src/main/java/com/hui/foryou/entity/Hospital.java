package com.hui.foryou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author xxx
 * @since 2021-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String code;

    private String name;

    @TableField("img_url")
    private String imgUrl;

    @TableField("region_code")
    private String regionCode;

    private String address;

    private String tel;

    @TableField("is_open")
    private String isOpen;

    private String latitude;

    private String longitude;

    @TableField("worktime_desc")
    private String worktimeDesc;

    private Double distance;

    @TableField("vaccine_code")
    private String vaccineCode;

    @TableField("vaccine_name")
    private String vaccineName;

    private String total;

    @TableField("is_seckill")
    private String isSeckill;

    private Integer price;

    @TableField("source_type")
    private String sourceType;

    @TableField("depa_vacc_id")
    private String depaVaccId;

    @TableField("is_noticed_user_allowed")
    private Integer isNoticedUserAllowed;


}
