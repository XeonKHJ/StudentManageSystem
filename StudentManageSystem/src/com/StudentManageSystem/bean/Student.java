package com.StudentManageSystem.bean;

import java.util.Calendar;

public class Student extends Person
{
    private Calendar entryYear;
    private Calendar birthday;
    public Student (String id)
    {
        super(id);
    }

    public Student (String id, String name)
    {
        super(id, name);
    }

    public Student (String id, String name, Calendar birthday)
    {
        super(id, name, birthday);
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Calendar birthday) 
    {
        this.birthday = birthday;
    }

    /**
     * @param entryYear the entryYear to set
     */
    public void setEntryYear(Calendar entryYear) 
    {
        this.entryYear = entryYear;
    }

    /**
     * @return the birthday
     */
    public Calendar getBirthday() 
    {
        return birthday;
    }

    /**
     * @return the entryYear
     */
    public Calendar getEntryYear() 
    {
        return entryYear;
    }
}