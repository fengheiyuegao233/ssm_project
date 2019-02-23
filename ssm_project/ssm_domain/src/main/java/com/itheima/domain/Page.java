package com.itheima.domain;

import java.util.List;

public class Page<T> {
   private Integer page=1;
   private Integer pageSize=3;
   private List<T> list;
   private Integer totelSize;
   private Integer totelPage;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotelSize() {
        return totelSize;
    }

    public void setTotelSize(Integer totelSize) {
        this.totelSize = totelSize;
    }

    public Integer getTotelPage() {
        if (totelPage==null){
            totelPage=totelSize%pageSize==0 ? totelSize/pageSize :totelSize/pageSize+1;
        }
        return totelPage;
    }

    public void setTotelPage(Integer totelPage) {
        this.totelPage = totelPage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", list=" + list +
                ", totelSize=" + totelSize +
                ", totelPage=" + totelPage +
                '}';
    }
}
