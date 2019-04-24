package com.curou.oa.entity;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/3/26 0026
 * @email 200890949@qq.com
 */
public class UserSearch extends SearchBase{

    private String name;

    private String mobilePhone;

    private String sex;

    private String department;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
