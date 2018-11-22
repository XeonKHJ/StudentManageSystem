package com.StudentManageSystem.bean;

import java.util.Calendar;

class Person
{
    protected String id;
    protected String name;
    protected Calendar birthday;
    protected String iconPath;

    //构造器
    Person (String id)
    {
        this.id = id;
    }
    Person (String id, String name)
    {
        this.id = id;
        this.name = name;
    }
    Person (String id, String name, Calendar birthday)
    {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) 
    {
        this.id = id;
    }

    /**
     * @param iconPath the iconPath to set
     */
    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the birthday
     */
    public Calendar getBirthday() {
        return birthday;
    }

    /**
     * @return the iconPath
     */
    public String getIconPath() {
        return iconPath;
    }
}