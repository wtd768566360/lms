package com.dada.entity;

import java.util.Date;

public class SysTown {
    /**
     * ID
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 县/区ID
     */
    private String countyId;

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
     * 县/区ID
     * @return county_id 县/区ID
     */
    public String getCountyId() {
        return countyId;
    }

    /**
     * 县/区ID
     * @param countyId 县/区ID
     */
    public void setCountyId(String countyId) {
        this.countyId = countyId == null ? null : countyId.trim();
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