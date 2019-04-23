package com.dada.entity;

import java.util.Date;

public class SysLine {
    /**
     * 线路ID
     */
    private String id;

    /**
     * 线路名称
     */
    private String lineName;

    /**
     * 始发站
     */
    private String lineStart;

    /**
     * 终点站
     */
    private String lineEnd;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除：1-已删除；0-未删除
     */
    private Boolean isDeleted;

    /**
     * 创建者ID
     */
    private String creatorId;

    /**
     * 修改者ID
     */
    private String modifierId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 线路ID
     * @return id 线路ID
     */
    public String getId() {
        return id;
    }

    /**
     * 线路ID
     * @param id 线路ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 线路名称
     * @return line_name 线路名称
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * 线路名称
     * @param lineName 线路名称
     */
    public void setLineName(String lineName) {
        this.lineName = lineName == null ? null : lineName.trim();
    }

    /**
     * 始发站
     * @return line_start 始发站
     */
    public String getLineStart() {
        return lineStart;
    }

    /**
     * 始发站
     * @param lineStart 始发站
     */
    public void setLineStart(String lineStart) {
        this.lineStart = lineStart == null ? null : lineStart.trim();
    }

    /**
     * 终点站
     * @return line_end 终点站
     */
    public String getLineEnd() {
        return lineEnd;
    }

    /**
     * 终点站
     * @param lineEnd 终点站
     */
    public void setLineEnd(String lineEnd) {
        this.lineEnd = lineEnd == null ? null : lineEnd.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 是否删除：1-已删除；0-未删除
     * @return is_deleted 是否删除：1-已删除；0-未删除
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除：1-已删除；0-未删除
     * @param isDeleted 是否删除：1-已删除；0-未删除
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 创建者ID
     * @return creator_id 创建者ID
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 创建者ID
     * @param creatorId 创建者ID
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * 修改者ID
     * @return modifier_id 修改者ID
     */
    public String getModifierId() {
        return modifierId;
    }

    /**
     * 修改者ID
     * @param modifierId 修改者ID
     */
    public void setModifierId(String modifierId) {
        this.modifierId = modifierId == null ? null : modifierId.trim();
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

    /**
     * 修改时间
     * @return modify_time 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}