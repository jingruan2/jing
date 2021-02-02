package com.jingruan.weighsystem.util;


public class PageHelper {
    private int pageNo;//当前页号

    private int pageCount;//每页记录数

    private int totalCount;//总记录数

    private int totalPageNo;//总页数

    //private boolean hasPerv = false;//是否有上一页

    //private boolean hasNext = false;//是否有下一页

    private int skipRowNum = 0;//mysql 默认值是0，其它数据库默认值是1




    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {

        //设置记录数
        this.totalCount = totalCount;

        //分页条件
        //skipRowNum=(pageNo-1)*pageCount;

        //设置总页数
        totalPageNo=(int) Math.ceil(totalCount*1.0/pageCount);

        //是否有下页
        //hasPerv=1<pageNo;

        //是否有上页
        //hasNext=pageNo<totalPageNo;
    }

    public int getTotalPageNo() {
        return totalPageNo;
    }

    public void setTotalPageNo(int totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    /*public boolean isHasPerv() {
        return hasPerv;
    }

    public void setHasPerv(boolean hasPerv) {
        this.hasPerv = hasPerv;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }*/

    public int getSkipRowNum() {
        return skipRowNum;
    }

    public void setSkipRowNum(int skipRowNum) {
        this.skipRowNum = skipRowNum;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

}

