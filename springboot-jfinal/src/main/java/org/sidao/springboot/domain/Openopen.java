package org.sidao.springboot.domain;

import javax.persistence.*;

public class Openopen {
    /**
     * ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 时间
     */
    @Column(name = "DATE")
    private String date;

    /**
     * URL地址
     */
    @Column(name = "URL")
    private String url;

    /**
     * 备注
     */
    @Column(name = "COMMENT")
    private String comment;

    /**
     * 已经解析
     */
    @Column(name = "HADPARSE")
    private Integer hadparse;

    /**
     * 数量
     */
    @Column(name = "COUNT")
    private Integer count;

    /**
     * 获取ID
     *
     * @return ID - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取时间
     *
     * @return DATE - 时间
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置时间
     *
     * @param date 时间
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 获取URL地址
     *
     * @return URL - URL地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置URL地址
     *
     * @param url URL地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取备注
     *
     * @return COMMENT - 备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置备注
     *
     * @param comment 备注
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取已经解析
     *
     * @return HADPARSE - 已经解析
     */
    public Integer getHadparse() {
        return hadparse;
    }

    /**
     * 设置已经解析
     *
     * @param hadparse 已经解析
     */
    public void setHadparse(Integer hadparse) {
        this.hadparse = hadparse;
    }

    /**
     * 获取数量
     *
     * @return COUNT - 数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置数量
     *
     * @param count 数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}