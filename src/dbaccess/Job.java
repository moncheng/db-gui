package dbaccess;

import java.util.Date;

public class Job{

    private int job_id;
    private int pos_code;
    private int company_id;
    private int person_id;
    private String job_type;
    private int salary;
    private double wage_rate;
    private Date start_date;
    private Date end_date;

    public Job(int job_id, int pos_code, int company_id, int person_id, String job_type, int salary, double wage_rate, Date start_date, Date end_date) {
        this.job_id = job_id;
        this.pos_code = pos_code;
        this.company_id = company_id;
        this.person_id = person_id;
        this.job_type = job_type;
        this.salary = salary;
        this.wage_rate = wage_rate;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public void addCompany(){

    }

    public void deleteCompany(){


    }
}