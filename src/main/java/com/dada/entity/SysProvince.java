package com.dada.entity;

import java.util.Date;

public class SysProvince {
    /**
     * ID
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 国家ID
     */
    private String stateId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * ID
     * @return id ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 国家ID
     * @return state_id 国家ID
     */
    public String getStateId() {
        return stateId;
    }

    /**
     * 国家ID
     * @param stateId 国家ID
     */
    public void setStateId(String stateId) {
        this.stateId = stateId == null ? null : stateId.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}