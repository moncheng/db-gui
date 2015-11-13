package dbaccess;

public class Person{

    private int person_id;
    private String name;
    private String street_number;
    private String street_name;
    private String city;
    private String state;
    private int zip_code;
    private String gender;
    private String email;


    public Person(int id, String name,
                  String street_number ,String street_name,
                  String city, String state, int zip_code,
                  String gender, String email){
        this.person_id = id;
        this.name = name;
        this.street_number = street_number;
        this.street_name = street_name;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.gender = gender;
        this.email = email;
    }

    public void addPerson(){

    }

    public void deletePerson(){


    }
}