package com.StudentManageSystem.bean;

import java.util.Calendar;

class Teacher extends Person
{
    Teacher (String id)
    {
        super(id);
    }

    Teacher (String id, String name)
    {
        super(id, name);
    }

    Teacher (String id, String name, Calendar birthday)
    {
        super(id, name, birthday);
    }
}