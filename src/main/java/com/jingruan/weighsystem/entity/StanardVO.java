package com.jingruan.weighsystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;

public class StanardVO {



    /**
     * 车号
     */
    private String fcarno;

    /**
     * 货物名称
     */
    private String fproname;

    /**
     * 货物规格
     */
    private String fpromodel;

    /**
     * 发货单位
     */
    private String funitfrom;

    /**
     * 收货单位
     */
    private String funitto;

    /**
     * 运输单位
     */
    private String ftransport;

    /**
     * 司机
     */
    private String fdriver;

    /**
     * 备注
     */
    private String fmemo;


    /**
     * 开始时间
     */
    private String fbegintime;

    /**
     * 结束时间
     */
    private String fendtime;

    /**
     * 是否作废
     */
    private Integer fiscancel;

    private Integer pageCount;


    private Integer pageNo;


    private Integer fiscomplete;

    public String getFcarno() {
        return fcarno;
    }

    public void setFcarno(String fcarno) {
        this.fcarno = fcarno;
    }

    public String getFproname() {
        return fproname;
    }

    public void setFproname(String fproname) {
        this.fproname = fproname;
    }

    public String getFpromodel() {
        return fpromodel;
    }

    public void setFpromodel(String fpromodel) {
        this.fpromodel = fpromodel;
    }

    public String getFunitfrom() {
        return funitfrom;
    }

    public void setFunitfrom(String funitfrom) {
        this.funitfrom = funitfrom;
    }

    public String getFunitto() {
        return funitto;
    }

    public void setFunitto(String funitto) {
        this.funitto = funitto;
    }

    public String getFtransport() {
        return ftransport;
    }

    public void setFtransport(String ftransport) {
        this.ftransport = ftransport;
    }

    public String getFdriver() {
        return fdriver;
    }

    public void setFdriver(String fdriver) {
        this.fdriver = fdriver;
    }

    public String getFmemo() {
        return fmemo;
    }

    public void setFmemo(String fmemo) {
        this.fmemo = fmemo;
    }

    public String getFbegintime() {
        return fbegintime;
    }

    public void setFbegintime(String fbegintime) {
        this.fbegintime = fbegintime;
    }

    public String getFendtime() {
        return fendtime;
    }

    public void setFendtime(String fendtime) {
        this.fendtime = fendtime;
    }

    public Integer getFiscancel() {
        return fiscancel;
    }

    public void setFiscancel(Integer fiscancel) {
        this.fiscancel = fiscancel;
    }

    public Integer getFiscomplete() {
        return fiscomplete;
    }

    public void setFiscomplete(Integer fiscomplete) {

        this.fiscomplete = fiscomplete;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
