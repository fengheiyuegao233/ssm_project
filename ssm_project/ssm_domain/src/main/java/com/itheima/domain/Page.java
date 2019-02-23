package com.itheima.domain;

import java.util.List;
import java.util.Objects;

public class Page<T> {
   private Integer page=1;
   private Integer pageSize=3;
   private List<T> list;
   private Integer totelSize;
   private Integer totelPage;

    public Integer getPage() {
        if (page==null||page==0){
            page=1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        if (pageSize==0||pageSize==null){
            pageSize=3;
        }
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
