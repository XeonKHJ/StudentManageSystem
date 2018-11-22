package com.StudentManageSystem.bean;

class Course
{
    private String courseId;
    private String name;

    Course(String courseId, String name)
    {
        this.courseId = courseId;
        this.name = name;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}