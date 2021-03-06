	 CREATE TABLE company
	(company_id		number(10),
	 company_name   varchar(30) NOT null,
	 street_number	number(10),
	 street_name		varchar(40),
	 city			varchar(20),
	 state 			varchar(20),
	 zip_code 		varchar(10),
	 website		varchar(40),
	 primary key (company_id)
	);
  CREATE TABLE speciality
	(speciality_id		number(10), 
	 spec_title			    varchar(30) NOT null, 
	 primary key (speciality_id)
	);
CREATE TABLE specialize
	(speciality_id		number(10), 
	 company_id			number(10), 
	 primary key (speciality_id,company_id),
   foreign key (speciality_id) references speciality,
   foreign key (company_id) references company
	);


CREATE TABLE person
	(person_id		number(10), 
	 name 			varchar(30) NOT null,
	 street_number   number(10),
	 street_name		varchar(30),
	 city			varchar(20),
	 state 			varchar(20),
	 zip_code		varchar(10),
	 gender			varchar(10),
	 email			varchar(40),
	 primary key (person_id)
	);

	CREATE TABLE worksFor
		(person_id number(10),
		 company_id number(10),
		 primary key (person_id, company_id),
     foreign key (person_id) references person,
     foreign key (company_id) references company
		 );

	CREATE TABLE phone_number
	(
	 phone_id		number(7),
	 country_code	number(3),
	 area_code		number(3) NOT null, 
	 phone_number	number(7) NOT null, 
	 primary key (phone_id)
	);
  
  CREATE TABLE owns_phone
	(person_id		number(10), 
	 phone_id		number(7), 
	 primary key (person_id,phone_id),
   foreign key (person_id) references person,
   foreign key (phone_id) references phone_number
	);
CREATE TABLE job_profile
	(pos_code		number(10), 
	 job_title			varchar(30) NOT null,
	 description	varchar(255),  
	 primary key (pos_code)
	);
CREATE TABLE job
	(job_id			number(10), 
	 pos_code		number(10) NOT null,
	 company_id     number(10),
	 person_id		number(10),
	 job_type		varchar(20),
	 income			number(10,2),
	 start_date		date,
	 end_date		date,
	 primary key (job_id),
   foreign key (pos_code) references job_profile
	);



CREATE TABLE project
	(project_id		number(10), 
     company_id		number(10),
     project_name	varchar(30) NOT null,
	 primary key (project_id),
   foreign key (company_id) references company
	);


CREATE TABLE course
	(course_id		number(10), 
	 course_title			varchar(30) NOT null,
	 description	varchar(255),
	 status			varchar(30),
	 retail_price	number(5,2),
	 primary key (course_id)
	);

CREATE TABLE work_on
	(job_id			number(10), 
	 project_id		number(10),
	 primary key (job_id,project_id),
   foreign key (job_id) references job,
   foreign key (project_id) references project
	);

CREATE TABLE skill
	(skill_id		number(10), 
	 skill_title			varchar(30) NOT null, 
	 description	varchar(255), 
	 skill_level			varchar(20) NOT null,
	 primary key (skill_id)
	);

CREATE TABLE knows_skill 
	(person_id		number(10), 
	 skill_id		number(10), 
	 primary key (person_id,skill_id),
   foreign key (person_id) references person,
   foreign key (skill_id) references skill
  );
CREATE TABLE skill_require
	(pos_code		number(10) NOT null, 
	 skill_id		number(10) NOT null,
	 primary key (pos_code,skill_id),
   foreign key (skill_id) references skill,
   foreign key (pos_code) references job_profile
	);

CREATE TABLE course_skill
	(skill_id			number(10),
	 course_id			number(10),
	 primary key (skill_id,course_id),
   foreign key (skill_id) references skill,
   foreign key (course_id) references course
	);

CREATE TABLE learn
	(person_id		number(10),
	 course_id		number(10),
	 learn_from		varchar(20),
	 primary key (person_id,course_id),
   foreign key (person_id) references person,
   foreign key (course_id) references course
	);
				
	CREATE TABLE section
	(section_id		number(10), 
	 course_id    number(10),
	 start_time		interval day (0) to second(0) NOT null,
	 end_time		interval day (0) to second(0) NOT null,
	 start_date		date,
	 end_date		date,
	 offer_by		varchar(50),
	 primary key (section_id, course_id),
   foreign key (course_id) references course
	);

	CREATE TABLE prerequisite
	(course_id				number(10), 
	 required_course_id		number(10),
	 primary key (course_id, required_course_id),
   foreign key (course_id) references course,
   foreign key (required_course_id) references course
	);


/* a sequence to generate course set ID */
CREATE SEQUENCE CourseSet_seq
				START WITH 1
				INCREMENT BY 1
				MAXVALUE 999999
				NOCYCLE;
        
        
CREATE TABLE CourseSet (
					csetID NUMBER(10, 0) PRIMARY KEY,
					course_id1 NUMBER(6, 0), 
          course_id2 NUMBER(6, 0), 
          course_id3 NUMBER(6, 0),
					siz NUMBER(2, 0) /* number of courses */
					);






