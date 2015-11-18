package JavaClasses;

public class Company{

    private int company_id;
    private String company_name;
    private String street_number;
    private String street_name;
    private String city;
    private String state;
    private int zip_code;
    private String website;


    public Company(int id, String name,
                  String street_number ,String street_name,
                  String city, String state, int zip_code,
                  String website){
        this.company_id = id;
        this.company_name = name;
        this.street_number = street_number;
        this.street_name = street_name;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.website = website;
    }

    public void addCompany(){

    }

    public void deleteCompany(){


    }
}