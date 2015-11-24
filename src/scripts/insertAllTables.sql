INSERT INTO company VALUES (1, 'Gigaclub', '89431', 'Shelley', 'Akron', 'Ohio', '44393', 'nhs.uk');
INSERT INTO company VALUES (2, 'Photospace', '5', 'Lakeland', 'Sacramento', 'California', '95818', 'businessinsider.com');
INSERT INTO company VALUES (3, 'Realfire', '7', 'Pleasure', 'El Paso', 'Texas', '79955', 'japanpost.jp');
INSERT INTO company VALUES (4, 'Izio', '13', 'Fordem', 'Providence', 'Rhode Island', '02912', 'fastcompany.com');
INSERT INTO company VALUES (5, 'Skinder', '86', 'Little Fleur', 'Fresno', 'California', '93726', 'pagesperso-orange.fr');
INSERT INTO company VALUES (6, 'Fiveclub', '8', 'Johnson', 'Saint Paul', 'Minnesota', '55146', 'odnoklassniki.ru');
INSERT INTO company VALUES (7, 'Bubblebox', '25120', '3rd', 'Lubbock', 'Texas', '79452', 'reddit.com');
INSERT INTO company VALUES (8, 'Tazz', '4166', 'Hooker', 'Louisville', 'Kentucky', '40225', 'archive.org');
INSERT INTO company VALUES (9, 'Voonder', '4', 'Melby', 'Louisville', 'Kentucky', '40205', 'samsung.com');
INSERT INTO company VALUES (10, 'Edgeclub', '61', 'American', 'Chicago', 'Illinois', '60686', 'google.it');	

INSERT INTO person VALUES (1, 'Julia Hicks', '96', 'Comanche', 'London', 'Kentucky', '40745', 'Male', 'jhicks0@scientificamerican.com');
INSERT INTO person VALUES (2, 'Mark Lee', '97', 'Kipling', 'Cincinnati', 'Ohio', '45999', 'Female', 'mlee1@qq.com');
INSERT INTO person VALUES (3, 'Keith Martinez', '81538', 'Buena Vista', 'Reno', 'Nevada', '89510', 'Female', 'kmartinez2@tmall.com');
INSERT INTO person VALUES (4, 'Jacqueline Nichols', '7519', 'Thierer', 'Harrisburg', 'Pennsylvania', '17140', 'Male', 'jnichols3@cdc.gov');
INSERT INTO person VALUES (5, 'William Ray', '56703', 'Coolidge', 'Hampton', 'Virginia', '23668', 'Male', 'wray4@smh.com.au');
INSERT INTO person VALUES (6, 'Kathy Jenkins', '120', 'Jackson', 'El Paso', 'Texas', '79977', 'Female', 'kjenkins5@hud.gov');
INSERT INTO person VALUES (7, 'Christina Bowman', '809', 'Luster', 'Greensboro', 'North Carolina', '27425', 'Female', 'cbowman6@hatena.ne.jp');
INSERT INTO person VALUES (8, 'Annie Brooks', '504', 'Shoshone', 'Seattle', 'Washington', '98121', 'Female', 'abrooks7@ca.gov');
INSERT INTO person VALUES (9, 'Bonnie Boyd', '6', 'Cottonwood', 'Shawnee Mission', 'Kansas', '66276', 'Male', 'bboyd8@deliciousdays.com');
INSERT INTO person VALUES (10, 'Deborah Watkins', '71577', 'Forster', 'Fairbanks', 'Alaska', '99790', 'Male', 'dwatkins9@cyberchimps.com');
insert into person values (11, 'Gary King', '0352', 'Blackbird', 'Cincinnati', 'Ohio', '45218', 'Male', 'gkinga@jugem.jp');
insert into person values (12, 'Brenda Gutierrez', '99981', 'Monument', 'Youngstown', 'Ohio', '44555', 'Female', 'bgutierrezb@ibm.com');
insert into person values (13, 'Adam Chapman', '3', 'Delladonna', 'Springfield', 'Missouri', '65898', 'Female', 'achapmanc@dion.ne.jp');
insert into person values (14, 'Andrea Franklin', '7417', 'Ludington', 'Jacksonville', 'Florida', '32204', 'Male', 'afranklind@symantec.com');
insert into person values (15, 'Larry Nelson', '22', 'Parkside', 'Boston', 'Massachusetts', '02283', 'Male', 'lnelsone@xinhuanet.com');
insert into person values (16, 'Ernest Dunn', '570', 'Golf Course', 'Baton Rouge', 'Louisiana', '70820', 'Female', 'edunnf@scribd.com');
insert into person values (17, 'Andrew Olson', '726', 'Oak Valley', 'Young America', 'Minnesota', '55557', 'Female', 'aolsong@nationalgeographic.com');
insert into person values (18, 'Lori Parker', '5625', 'Stang', 'Indianapolis', 'Indiana', '46216', 'Female', 'lparkerh@bigcartel.com');
insert into person values (19, 'Carolyn Cooper', '97230', 'Algoma', 'Houston', 'Texas', '77005', 'Male', 'ccooperi@nasa.gov');
insert into person values (20, 'Margaret Ramos', '60895', 'Hintze', 'Jeffersonville', 'Indiana', '47134', 'Male', 'mramosj@github.com');
insert into person values (21, 'Barbara Little', '29597', 'Debs', 'Paterson', 'New Jersey', '07522', 'Male', 'blittlek@globo.com');
insert into person values (22, 'Nicholas Perry', '92', 'Buhler', 'Washington', 'District of Columbia', '20310', 'Female', 'nperryl@sciencedirect.com');
insert into person values (23, 'Jean Harvey', '42', 'Buhler', 'New York City', 'New York', '10115', 'Male', 'jharveym@desdev.cn');
insert into person values (24, 'Gerald Meyer', '957', 'Dunning', 'Van Nuys', 'California', '91499', 'Male', 'gmeyern@surveymonkey.com');
insert into person values (25, 'Albert Garza', '95', 'Emmet', 'San Francisco', 'California', '94177', 'Female', 'agarzao@discovery.com');

INSERT INTO skill VALUES (0,'Java beginner','high level programming language','entry');	
INSERT INTO skill VALUES (1, 'leadership', null, 3);
INSERT INTO skill VALUES (2, 'java II', null, 3);
INSERT INTO skill VALUES (3, 'computaion', null, 1);
INSERT INTO skill VALUES (4, 'research', null, 3);
INSERT INTO skill VALUES (5, 'teaching', null, 2);
INSERT INTO skill VALUES (6, 'environment', null, 2);
INSERT INTO skill VALUES (7, 'marketing', null, 2);
INSERT INTO skill VALUES (8, 'Information Technology', null, 2);



-- INSERT INTO skill (skill_id, skill_title, description, skill_level); 

/*who knows what skills*/--;
INSERT INTO knows_skill VALUES(1,0);	/*julia hicks knows beginning java*/
INSERT INTO knows_skill VALUES(1,1);	/*julia hicks knows leadership*/
INSERT INTO knows_skill VALUES(1,2);	/*julia hicks knows java II*/
INSERT INTO knows_skill VALUES(1,3);	/*julia hicks knows computation*/
INSERT INTO knows_skill VALUES(1,8);	/*julia hicks knows information technology*/

INSERT INTO knows_skill VALUES(25,0);	/*Albert Garza knows beginning java*/
INSERT INTO knows_skill VALUES(25,1);	/*Albert Garza knows leadership*/
INSERT INTO knows_skill VALUES(25,2);	/*Albert Garza knows java II*/
INSERT INTO knows_skill VALUES(25,3);	/*Albert Garza knows computation*/
INSERT INTO knows_skill VALUES(25,8);	/*Albert Garza knows information technology*/

INSERT INTO knows_skill VALUES(24,0);	/*Gerald Meyer knows beginning java*/
INSERT INTO knows_skill VALUES(24,1);	/*Gerald Meyer knows leadership*/
INSERT INTO knows_skill VALUES(24,2);	/*Gerald Meyer knows java II*/
INSERT INTO knows_skill VALUES(24,3);	/*Gerald Meyer knows computation*/
INSERT INTO knows_skill VALUES(24,8);	/*Gerald Meyer knows information technology*/

INSERT INTO knows_skill VALUES(23,0);	/*Gerald Meyer knows beginning java*/
INSERT INTO knows_skill VALUES(23,4);	/*Gerald Meyer knows research*/
INSERT INTO knows_skill VALUES(23,1);	/*Gerald Meyer knows leadership*/
INSERT INTO knows_skill VALUES(23,3);	/*Gerald Meyer knows computation*/
INSERT INTO knows_skill VALUES(23,8);	/*Gerald Meyer knows information technology*/

INSERT INTO knows_skill VALUES(22,0);	/*Gerald Meyer knows beginning java*/
INSERT INTO knows_skill VALUES(22,4);	/*Gerald Meyer knows research*/
INSERT INTO knows_skill VALUES(22,1);	/*Gerald Meyer knows leadership*/
INSERT INTO knows_skill VALUES(22,3);	/*Gerald Meyer knows computation*/
INSERT INTO knows_skill VALUES(22,8);	/*Gerald Meyer knows information technology*/


INSERT INTO knows_skill VALUES(2,1);/*mark lee knows leadership*/
INSERT INTO knows_skill VALUES(2,4);/*mark lee knows research*/
	
INSERT INTO knows_skill VALUES(3,2);	/*keith martinez knows java*/
INSERT INTO knows_skill VALUES(3,4);	/*keith martinez knows research*/

INSERT INTO knows_skill VALUES(4,7);	/*jaqueline nichols knows marketing*/
INSERT INTO knows_skill VALUES(4,4);	/*jaqueline nichols knows research*/
INSERT INTO knows_skill VALUES(4,1);  /*jaqueline nichols knows leadership*/

INSERT INTO knows_skill VALUES(5,0);	/*william ray knows beginner's java*/
INSERT INTO knows_skill VALUES(5,4);	/*william ray knows research*/
INSERT INTO knows_skill VALUES(5,1);	/*william ray knows leadership*/
INSERT INTO knows_skill VALUES(5,2);	/*william ray knows java*/
INSERT INTO knows_skill VALUES(5,3);	/*william ray knows computation*/
INSERT INTO knows_skill VALUES(5,5);	/*william ray knows teaching*/
INSERT INTO knows_skill VALUES(5,7);	/*william ray knows marketing*/
INSERT INTO knows_skill VALUES(5,8);	/*william ray knows information technology*/

/*which jobs require which skills*/--;

/*all jobs require java for beginners*/
INSERT INTO skill_require VALUES(1,0);	
INSERT INTO skill_require VALUES(2,0);	
INSERT INTO skill_require VALUES(3,0);	
INSERT INTO skill_require VALUES(4,0);	
INSERT INTO skill_require VALUES(5,0);	
INSERT INTO skill_require VALUES(6,0);	
INSERT INTO skill_require VALUES(7,0);	
INSERT INTO skill_require VALUES(8,0);	
INSERT INTO skill_require VALUES(9,0);	
INSERT INTO skill_require VALUES(10,0);	


INSERT INTO skill_require VALUES(1,2);	/*research assistant requires java*/
INSERT INTO skill_require VALUES(1,4);	/*research assistant requires research*/
INSERT INTO skill_require VALUES(1,8);	/*research assistant requires Information Technology*/

INSERT INTO skill_require VALUES(2,2);	/*general Manager requires java*/
INSERT INTO skill_require VALUES(2,4);	/*general Manager requires research*/
INSERT INTO skill_require VALUES(2,8);	/*general Manager requires Information Technology*/
INSERT INTO skill_require VALUES(2,1);	/*general Manager requires Leadership*/
INSERT INTO skill_require VALUES(2,5);	/*general Manager requires Teaching*/
INSERT INTO skill_require VALUES(2,3);	/*general Manager requires computation*/

INSERT INTO skill_require VALUES(5,7);	/*marketing Manager requires marketing*/
INSERT INTO skill_require VALUES(5,1);	/*marketing Manager requires leadership*/

INSERT INTO skill_require VALUES(6,2);	/*Web Developer II requires java*/
INSERT INTO skill_require VALUES(6,3);	/*Web Developer II requires computation*/
INSERT INTO skill_require VALUES(6,8);	/*Web Developer II requires information technology*/

INSERT INTO skill_require VALUES(10,5);	/*Teacher requires teaching*/


INSERT INTO job_profile (pos_code, job_title, description) VALUES (1, 'Research Assistant I', 'ajob');
INSERT INTO job_profile (pos_code, job_title, description) VALUES (2, 'General Manager', 'ajob');
INSERT INTO job_profile (pos_code, job_title, description) VALUES (3, 'Business Development Analyst', 'ajob');
INSERT INTO job_profile (pos_code, job_title, description) VALUES (4, 'Systems Administrator III', 'ajob');
INSERT INTO job_profile (pos_code, job_title, description) VALUES (5, 'Marketing Manager', 'ajob');
INSERT INTO job_profile (pos_code, job_title, description) VALUES (6, 'Web Developer II', 'ajob');
INSERT INTO job_profile (pos_code, job_title, description) VALUES (7, 'Environmental Specialist', 'ajob');
INSERT INTO job_profile (pos_code, job_title, description) VALUES (8, 'Help Desk Technician', 'ajob');
INSERT INTO job_profile (pos_code, job_title, description) VALUES (9, 'Information Systems Manager', 'ajob');
INSERT INTO job_profile (pos_code, job_title, description) VALUES (10, 'Teacher', 'ajob');


/*vacant jobs*/
INSERT INTO job VALUES(50,3,2,0,'full-time', 10001, 0, null ,null);	/*Business Development Analyst for photospace*/
INSERT INTO job VALUES(51,4,2,0,'full-time', 10002, 0, null ,null);	/*Systems Administrator III for photospace*/
INSERT INTO job VALUES(52,7,2,0,'full-time', 10003, 0, null ,null);	/*Environmental Specialist for photospace*/
INSERT INTO job VALUES(53,8,2,0,'full-time', 10004, 0, null ,null);	/*Help Desk Technician for photospace*/
INSERT INTO job VALUES(54,9,2,0,'full-time', 10005, 0, null ,null);	/*Information Systems Manager for photospace*/


/*who holds what job*/--;
INSERT INTO job VALUES(11,10,2,1,'full-time', 30000, 0, '03-APR-2014',null);	/*julia hicks is a teacher for photospace*/
INSERT INTO job VALUES(1,6,2,1,'full-time', 100000, 0, '03-APR-2014',null);	/*julia hicks is a web developer II for photospace*/
INSERT INTO job VALUES(2,2,2,5,'full-time', 350000, 0, '03-APR-2014',null);	/*william ray is general manager for photospace*/
INSERT INTO job VALUES(3,1,2,2,'full-time', 20000, 0, '03-APR-2014',null);	/*mark lee is a research assistant for photospace*/
INSERT INTO job VALUES(4,5,2,4,'full-time', 45000, 0, '03-APR-2014',null);	/*jaqueline nichols is a marketing manager for photospace*/

INSERT INTO work_on VALUES(1,1);	/*HolyGate's developer II for photospace*/
INSERT INTO work_on VALUES(2,1);	/*HolyGate's general manager for photospace*/
INSERT INTO work_on VALUES(3,1);	/*HolyGate's research assistant for photospace*/
INSERT INTO work_on VALUES(4,1);	 /*HolyGate's marketing manager for photospace*/

INSERT INTO work_on VALUES(11,2);	/*teacher works on Photospace Training*/

INSERT INTO project VALUES(1,2,'HolyGate');	
INSERT INTO project VALUES(2,2,'Photospace Training');

--course (course_id, course_title, description, status, retail_price);
INSERT INTO course VALUES (0, 'null', null, 'true', 0.0);
INSERT INTO course VALUES (1, 'Leadership', null, 'true', 19.18);
INSERT INTO course VALUES (2, 'Java II', null, 'false', 81.04);
INSERT INTO course VALUES (3, 'Research Methods', null, 'false', 45.5);
INSERT INTO course VALUES (4, 'Education', null, 'false', 31.79);
INSERT INTO course VALUES (5, 'Environment', null, 'false', 29.57);
INSERT INTO course VALUES (6, 'Algebra', null, 'true', 6.27);
INSERT INTO course VALUES (7, 'Calculus', null, 'true', 45.81);
INSERT INTO course VALUES (8, 'Marketing', null, 'true', 29.62);
INSERT INTO course VALUES (9, 'Intro to IT', null, 'true', 88.54);
INSERT INTO course VALUES (10, 'Advanced Calculus', null, 'false', 91.96);
INSERT INTO course VALUES(11,'Java 101','entry level java course','open',500);
INSERT INTO course VALUES(12,'Java 102','entry level java course','open',500);
--course (course_id, course_title, description, status, retail_price);

/*which course provides which skill, skill_id, course_id*/--;
INSERT INTO course_skill VALUES(1,1);	/*leadership from Leadership*/

INSERT INTO course_skill VALUES(2,2);	/*java from Java II*/
INSERT INTO course_skill VALUES(0,2);	/*java beginner from java II*/
INSERT INTO course_skill VALUES(4,2);	/*research from java II*/

INSERT INTO course_skill VALUES(4,3);	/*research from Research Methods*/
INSERT INTO course_skill VALUES(5,4);	/*teaching from Education*/
INSERT INTO course_skill VALUES(3,7);	/*computation from calculus*/
INSERT INTO course_skill VALUES(8,9);	/*information technology from Intro to IT*/


INSERT INTO section VALUES(10, 2, TO_DSINTERVAL('0 13:00:00'),TO_DSINTERVAL('0 14:00:00'),'03-JAN-2016', '03-JUN-2017','Dr. Tu'); /*Java II from Dr. TU */
INSERT INTO section VALUES(11, 2, TO_DSINTERVAL('0 13:00:00'),TO_DSINTERVAL('0 14:00:00'),'03-JAN-2017', '03-JUN-2018','Dr. Tu'); /*Java II from Dr. TU */
INSERT INTO section VALUES(12, 2, TO_DSINTERVAL('0 13:00:00'),TO_DSINTERVAL('0 14:00:00'),'03-JAN-2018', '03-JUN-2019','Dr. Tu'); /*Java II from Dr. TU */

INSERT INTO section VALUES(1, 1, TO_DSINTERVAL('0 13:00:00'),TO_DSINTERVAL('0 14:00:00'),'03-JAN-2016', '03-JUN-2017','Mr. President'); /*leadership from Mr. President*/
INSERT INTO section VALUES(2, 1, TO_DSINTERVAL('0 14:00:00'),TO_DSINTERVAL('0 15:00:00'),'03-JAN-2016', '03-MAY-2017','Mr. President'); /*leadership from Mr. President*/
INSERT INTO section VALUES(3, 1, TO_DSINTERVAL('0 15:00:00'),TO_DSINTERVAL('0 16:00:00'),'03-JAN-2016', '03-OCT-2017','Mr. President'); /*leadership from Mr. President*/

INSERT INTO speciality VALUES(1,'Finance');	
INSERT INTO speciality VALUES(2,'Software Development');	
INSERT INTO speciality VALUES(3,'Research');	
INSERT INTO speciality VALUES(4,'Training');	
INSERT INTO speciality VALUES(5,'Marketing');	
INSERT INTO speciality VALUES(6,'financing');	
INSERT INTO speciality VALUES(7,'financing');	
INSERT INTO speciality VALUES(8,'financing');	
INSERT INTO speciality VALUES(9,'financing');	
INSERT INTO speciality VALUES(10,'financing');	
INSERT INTO speciality VALUES(11,'financing');	

INSERT INTO specialize VALUES(1,1);
INSERT INTO specialize VALUES(2,2); /*photospace specializes in software development*/
INSERT INTO specialize VALUES(3,3);
INSERT INTO specialize VALUES(4,4);
INSERT INTO specialize VALUES(5,5);

INSERT INTO learn VALUES(1,1,'academy');

INSERT INTO prerequisite VALUES(2,1);	



INSERT INTO owns_phone (person_id,phone_id) VALUES (1,1);
INSERT INTO owns_phone (person_id,phone_id) VALUES (2,2);	
INSERT INTO owns_phone (person_id,phone_id) VALUES (3,3);
INSERT INTO owns_phone (person_id,phone_id) VALUES (4,4);
INSERT INTO owns_phone (person_id,phone_id) VALUES (5,5);
INSERT INTO owns_phone (person_id,phone_id) VALUES (6,6);
INSERT INTO owns_phone (person_id,phone_id) VALUES (7,7);
INSERT INTO owns_phone (person_id,phone_id) VALUES (8,8);
INSERT INTO owns_phone (person_id,phone_id) VALUES (9,9);
INSERT INTO owns_phone (person_id,phone_id) VALUES (10,10);

INSERT INTO phone_number VALUES(1,1,985,2333456);	
INSERT INTO phone_number VALUES(2,1,985,1234234);
INSERT INTO phone_number VALUES(3,1,985,1234234);
INSERT INTO phone_number VALUES(4,1,985,2324213);
INSERT INTO phone_number VALUES(5,1,985,5322341);
INSERT INTO phone_number VALUES(6,1,985,1523674);
INSERT INTO phone_number VALUES(7,1,504,2341236);
INSERT INTO phone_number VALUES(8,1,504,1211009);
INSERT INTO phone_number VALUES(9,1,504,2234552);
INSERT INTO phone_number VALUES(10,1,223,1122343);
INSERT INTO phone_number VALUES(11,1,222,4422533);
INSERT INTO phone_number VALUES(12,1,542,0092887);
INSERT INTO phone_number VALUES(13,1,646,3345551);
INSERT INTO phone_number VALUES(14,1,917,2223333);
INSERT INTO phone_number VALUES(15,1,985,1115522);

/* two-course set */
INSERT INTO CourseSet
				SELECT CourseSet_seq.NEXTVAL, C1.course_id, C2.course_id, null, 2
				FROM Course C1, Course C2
				WHERE C1.course_id < C2.course_id;
/* three-course set */
				INSERT INTO CourseSet
				SELECT CourseSet_seq.NEXTVAL, C1.course_id, C2.course_id, C3.course_id, 3
				FROM Course C1, Course C2, Course C3
				WHERE C1.course_id < C2.course_id AND C2.course_id < C3.course_id; 
