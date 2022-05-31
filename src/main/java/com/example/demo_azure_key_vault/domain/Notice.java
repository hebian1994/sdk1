package com.example.demo_azure_key_vault.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 公告表
 * Created by wmm on 2019/4/17.
 */
@Entity
@Table(name = "notice")
@Data
public class Notice {

    @Id
    private String id;

    private String title;

    private String information;

    /**
     * 状态：1保存；2发布
     */
    private int status;

    private String goodsId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createUser;

    private Boolean delFlag;

    private Boolean factoryView = false;
}
