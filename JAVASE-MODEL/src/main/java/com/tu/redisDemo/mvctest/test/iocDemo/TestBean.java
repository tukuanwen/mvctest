package com.tu.redisDemo.mvctest.test.iocDemo;

/**
 * 演示springIOC管理bean
 */

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 构造函数注入&注入特殊字符
 */
class GZBean{
    private String blame;
    private String banter;
    private String bNull;
    private String bLunb;
    public GZBean(String blame, String banter) {
        this.blame = blame;
        this.banter = banter;
    }
    public String getbNull() {
        return bNull;
    }

    public void setbNull(String bNull) {
        this.bNull = bNull;
    }

    public String getbLunb() {
        return bLunb;
    }

    public void setbLunb(String bLunb) {
        this.bLunb = bLunb;
    }
}

/**
 * 外部bean级联注入属性
 */
class InnerBean{

    private String iName;

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
}

/**
 * 注入集合属性
 */
class CollectionBean{

    private String[] str;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;
    private List<InnerBean> innerBeanList;

    public List<InnerBean> getInnerBeanList() {
        return innerBeanList;
    }

    public void setInnerBeanList(List<InnerBean> innerBeanList) {
        this.innerBeanList = innerBeanList;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public String[] getStr() {
        return str;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}

@Component
public class TestBean {

    private String blame;
    private String banter;
    //外部bean方式注入
    private GZBean gzBean;
    //内部bean方式注入
    private InnerBean innerBean;

    public InnerBean getInnerBean() {
        return innerBean;
    }

    public void setInnerBean(InnerBean innerBean) {
        this.innerBean = innerBean;
    }

    public GZBean getGzBean() {
        return gzBean;
    }

    public void setGzBean(GZBean gzBean) {
        this.gzBean = gzBean;
    }


    public String getBlame() {
        return blame;
    }

    public void setBlame(String blame) {
        this.blame = blame;
    }

    public String getBanter() {
        return banter;
    }

    public void setBanter(String banter) {
        this.banter = banter;
    }





}
