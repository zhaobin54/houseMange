package com.house.util;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	//��ǰҳ��  
    private int cunrrentPage;  
    //ȫ��ҳ��  
    private int totalPage;  
    //ȫ������  
    private int totalCount;  
    //ÿҳ��������  
    private int pageSize;  
    //��ѯ���ؽ��  
    private List<T> list=new ArrayList<T>();  
    //��ҳ����  
    private String url;  
      
    public String getUrl()  
    {  
        return url;  
    }  
  
    public void setUrl(String url)  
    {  
        this.url = url;  
    }  
  
    public int getCunrrentPage()  
    {  
        return cunrrentPage;  
    }  
  
    public void setCunrrentPage(int cunrrentPage)  
    {  
        if(cunrrentPage<0){  
            cunrrentPage=0;  
        }  
        this.cunrrentPage = cunrrentPage;  
    }  
  
    public int getTotalPage()  
    {  
        if(totalCount%pageSize==0){  
            totalPage=totalCount/pageSize;  
        }else{  
            totalPage=totalCount/pageSize+1;  
        }  
        return totalPage;  
    }  
  
    public void setTotalPage(int totalPage)  
    {  
        if(totalPage<0){  
            totalPage=0;  
        }  
        this.totalPage = totalPage;  
    }  
  
    public int getTotalCount()  
    {  
        return totalCount;  
    }  
  
    public void setTotalCount(int totalCount)  
    {  
        if(totalCount<0){  
            totalCount=0;  
        }  
        this.totalCount = totalCount;  
    }  
  
    public int getPageSize()  
    {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize)  
    {  
        if(pageSize<20){  
            pageSize=20;  
        }  
        this.pageSize = pageSize;  
    }  
  
    public List<T> getList()  
    {  
        return list;  
    }  
  
    public void setList(List<T> list)  
    {  
        this.list = list;  
    }  
}
