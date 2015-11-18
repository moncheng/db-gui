package JavaClasses;


public class Person{

    private int person_id;
    private String name;
    private int street_number;
    private String street_name;
    private String city;
    private String state;
    private String zip_code;
    private String gender;
    private String email;


    public Person(int id, String name,
                  int street_number ,String street_name,
                  String city, String state, String zip_code,
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

    public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStreet_number() {
		return street_number;
	}

	public void setStreet_number(int street_number) {
		this.street_number = street_number;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//	CREATE TABLE person
//
//	(person_id		number(10), 
//
//	 name 			varchar(30) NOT null,
//
//	 street_number   number(10),
//
//	 street_name		varchar(30),
//
//	 city			varchar(20),
//
//	 state 			varchar(20),
//
//	 zip_code		varchar(10),
//
//	 gender			varchar(10),
//
//	 email			varchar(40),
	public String addPerson(){
		String str = "INSERT INTO person VALUES ("+person_id+",'" + name +"', " + street_number +", '" +
	street_name +"', '" +city +"', '" +state +"', '" +zip_code +"', '" +gender +"', '" +email +"')";
		return str;
    }

    public void deletePerson(){


    }
}