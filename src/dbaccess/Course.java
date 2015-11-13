package dbaccess;

import java.lang.Double;

public class Course{

    private int course_id;
    private String course_title;
    private String description;
    private String status;
    private Double retail_price;

    public Course(int id, String course_title, String description, String status,
                  Double retail_price){
        this.course_id = id;
        this.course_title = course_title;
        this.description = description;
        this.status = status;
        this.retail_price = retail_price;

    }

    public void addCourse(){

    }

    public void deleteCourse(){


    }
}