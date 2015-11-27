package dbaccess;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectQueries {
	private ArrayList<String> questions;
	private ArrayList<String> queries;
	HashMap<String,String> map;
	public ProjectQueries()
	{
		this.questions=new ArrayList();
		this.queries=new ArrayList();
		this.map=new HashMap();
		addQuestions();
		addQueries();
		createMap();
	}
	
	public void addQuestions()
	{
		questions.add("1a. List a company's workers by names.");
		questions.add("2a. List a company's staff by salary in descending order.");
		questions.add("3a. List companies' labor cost (total salaries and wage rates by 1920 hours) in descending order.");
		questions.add("4a. Find all the jobs a person is currently holding.");
		questions.add("5a. List all the workers who are working for a specific project.");
		questions.add("6a. List a person's knowledge/skills in a readable format.");
		questions.add("7a. List the skill gap of a worker between his/her job(s) and his/her skills.");
		questions.add("8a. List the required knowledge/skills of a job profile in a readable format.");
		questions.add("9a. List a person's missing knowledge/skills for a specific job in a readable format.");
		questions.add("10a. Find the courses each of which alone can cover a given skill set.");
		questions.add("11a. List the courses (course id and title) that each alone teaches all the missing knowledge/skills for a person to pursue a specific job.");
		questions.add("12a. Suppose the skill gap of a worker and the requirement of a desired job can be covered by one course. Find the 'quickest' solution for this worker. Show the course and the completing date.");
		questions.add("13a. If query #10 returns nothing, then find the course sets with the minimum number of courses that their combination covers the given skill set. The considered course sets will not include more than three courses.");
		questions.add("14a. List the course sets that their combinations cover all the missing knowledge/skills for a person to pursue a specific job. The considered course sets will not include more than three courses.");
		questions.add("15a. Find the cheapest course choices to make up one's skill gap by showing the courses to take and the total cost. The considered course sets will not include more than three courses.");
		questions.add("16a. List all the job profiles that a person is qualified.");
		questions.add("17a. Find the job with the highest pay rate for a person according to his/her skill qualification.");
		questions.add("18a. List all the names along with the emails of the persons who are qualified for a job profile.");
		questions.add("19a. When a company cannot find any qualified person for a job, a secondary solution is to find a person who is almost qualified to the job. Make a 'missing-one' list that lists people who miss only one skill for a specified job profile.");
		questions.add("20a. List the skillID and the number of people in the missing-one list for a given job profile in the ascending order of the people counts.");
		questions.add("21a. Suppose there is a new job profile that has nobody qualified. List the persons who miss the least number of skills and report the 'least number'.");
		questions.add("22a. For a specified job profile and a given small number k, make a 'missing-k' list that lists the people's IDs and the number of missing skills for the people who miss only up to k skills in the ascending order of missing skills.");
		questions.add("23a. Given a job profile and its corresponding missing-k list specified in Question 22. Find every skill that is needed by at least one person in the given missing-k list. List each skillID and the number of people who need it in the descending order of the people counts.");
		questions.add("24a. In a local or national crisis, we need to find all the people who once held a job of the special job-profile identifier.");
		questions.add("25a. Find all the unemployed people who once held a job of the given job-profile identifier.");
		questions.add("26a. Find out the biggest employer in terms of number of employees or the total amount of salaries and wages paid to employees.");
		questions.add("1b. List a company's workers by names.");
		questions.add("2b. List a company's staff by salary in descending order.");
		questions.add("3b. List companies' labor cost (total salaries and wage rates by 1920 hours) in descending order.");
		questions.add("4b. Find all the jobs a person is currently holding.");
		questions.add("5b. List all the workers who are working for a specific project.");
		questions.add("6b. List a person's knowledge/skills in a readable format.");
		questions.add("7b. List the skill gap of a worker between his/her job(s) and his/her skills.");
		questions.add("8b. List the required knowledge/skills of a job profile in a readable format.");
		questions.add("9b. List a person's missing knowledge/skills for a specific job in a readable format.");
		questions.add("10b. Find the courses each of which alone can cover a given skill set.");
		questions.add("11b. List the courses (course id and title) that each alone teaches all the missing knowledge/skills for a person to pursue a specific job.");
		questions.add("12b. Suppose the skill gap of a worker and the requirement of a desired job can be covered by one course. Find the 'quickest' solution for this worker. Show the course and the completing date.");
		questions.add("13b. If query #10 returns nothing, then find the course sets with the minimum number of courses that their combination covers the given skill set. The considered course sets will not include more than three courses.");
		questions.add("14b. List the course sets that their combinations cover all the missing knowledge/skills for a person to pursue a specific job. The considered course sets will not include more than three courses.");
		questions.add("15b. Find the cheapest course choices to make up one's skill gap by showing the courses to take and the total cost. The considered course sets will not include more than three courses.");
		questions.add("16b. List all the job profiles that a person is qualified.");
		questions.add("17b. Find the job with the highest pay rate for a person according to his/her skill qualification.");
		questions.add("18b. List all the names along with the emails of the persons who are qualified for a job profile.");
		questions.add("19b. When a company cannot find any qualified person for a job, a secondary solution is to find a person who is almost qualified to the job. Make a 'missing-one' list that lists people who miss only one skill for a specified job profile.");
		questions.add("20b. List the skillID and the number of people in the missing-one list for a given job profile in the ascending order of the people counts.");
		questions.add("21b. Suppose there is a new job profile that has nobody qualified. List the persons who miss the least number of skills and report the 'least number'.");
		questions.add("22b. For a specified job profile and a given small number k, make a 'missing-k' list that lists the people's IDs and the number of missing skills for the people who miss only up to k skills in the ascending order of missing skills.");
		questions.add("23b. Given a job profile and its corresponding missing-k list specified in Question 22. Find every skill that is needed by at least one person in the given missing-k list. List each skillID and the number of people who need it in the descending order of the people counts.");
		questions.add("24b. In a local or national crisis, we need to find all the people who once held a job of the special job-profile identifier.");
		questions.add("25b. Find all the unemployed people who once held a job of the given job-profile identifier.");
		questions.add("26b. Find out the biggest employer in terms of number of employees or the total amount of salaries and wages paid to employees.");

		
	}
	public void addQueries()
	{
		queries.add("SELECT DISTINCT name FROM job NATURAL JOIN person WHERE company_id = 2");
		//1a
		queries.add("SELECT name, job_title, salary FROM person NATURAL JOIN job NATURAL JOIN job_profile "
				+ "WHERE company_id=2 AND job_type='full-time' ORDER BY salary DESC");
		//2a
		queries.add("SELECT company_name,(SUM(salary)+SUM(wage_rate*1920)) AS total "
				+ "FROM company NATURAL JOIN job GROUP BY (company_name)");
		//3a
		queries.add("SELECT name, job_title FROM person NATURAL JOIN job NATURAL JOIN job_profile WHERE person_id = 1");
		//4a
		queries.add("SELECT name FROM work_on NATURAL JOIN person NATURAL JOIN job WHERE project_id = 1");
		//5a
		queries.add("SELECT name, skill_title, description FROM person NATURAL JOIN knows_skill NATURAL JOIN skill "
				+ "WHERE person_id = 1");
		//6a
		queries.add("SELECT skill_id FROM "
				+ "(SELECT skill_id FROM SKILL_REQUIRE NATURAL JOIN job_profile NATURAL JOIN job "
				+ "WHERE job_id = (SELECT job_id FROM job WHERE person_id = 2) )"
				+ "MINUS (SELECT skill_id FROM knows_skill WHERE person_id = 2)");
		//7a
		queries.add("SELECT skill_title FROM job NATURAL JOIN skill_require NATURAL JOIN skill WHERE job_id = 1");
		//8a
		queries.add("SELECT skill_id FROM "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 1) "
				+ "MINUS "
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 2)");
		//9a
		
		queries.add("SELECT course_id, course_title FROM( "
				+ "WITH missing_skill AS( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 3) )"
				+ "SELECT course_id, course_title FROM course c "
				+ "WHERE NOT EXISTS( SELECT skill_id FROM missing_skill "
				+ "MINUS "
				+ "SELECT skill_id FROM course_skill cs "
				+ "WHERE cs.course_id = c.course_id ))");
		//moved 
		//10a
		
		queries.add("SELECT course_id, course_title FROM( "
				+ "WITH missing_skill AS( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 1) "
				+ "MINUS "
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 1) ) "
				+ "SELECT course_id, course_title FROM course c "
				+ "WHERE NOT EXISTS( SELECT skill_id FROM missing_skill "
				+ "MINUS "
				+ "SELECT skill_id FROM course_skill cs "
				+ "WHERE cs.course_id = c.course_id ))");
		
		
		//11a
		queries.add("SELECT course_id, section_id, end_date FROM ( "
				+ "WITH missing_skill AS ( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 3)"
				+ " MINUS"
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 1 ) ), "
				+ "possible_courses AS ( "
				+ "SELECT course_id FROM course c "
				+ "WHERE NOT EXISTS( "
				+ "(SELECT skill_id FROM missing_skill) "
				+ "MINUS "
				+ "(SELECT skill_id FROM course_skill cs "
				+ "WHERE cs.course_id = c.course_id) ) ) "
				+ "SELECT course_id, section_id, end_date "
				+ "FROM possible_courses NATURAL JOIN section "
				+ "ORDER BY end_date ASC "
				+ "FETCH FIRST 1 ROWS ONLY )");	
		//12a

		queries.add("SELECT course_id1, course_id2, course_id3 FROM "
				+ "(WITH missing_skill AS (  "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 1) "
				+ "MINUS  "
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 2 ) ), "
				+ "CourseSet_Skill(csetID, skill_id) AS ( "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id1=CS.course_id "
				+ "UNION "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id2=CS.course_id "
				+ "UNION "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id3=CS.course_id ), "
				+ "/* use division to find those course sets that cover missing skills */ "
				+ "Cover_CSet(csetID, siz) AS ( "
				+ "SELECT csetID, siz FROM CourseSet CSet "
				+ "WHERE NOT EXISTS ( "
				+ "SELECT skill_id FROM Missing_Skill "
				+ "MINUS "
				+ "SELECT skill_id FROM CourseSet_Skill CSSk WHERE CSSk.csetID = Cset.csetID ) ) "
				+ "/* to find the smallest sets */ "
				+ "SELECT course_id1, course_id2, course_id3 "
				+ "FROM Cover_CSet NATURAL JOIN CourseSet "
				+ "WHERE siz = (SELECT MIN(siz) FROM Cover_CSet) )");
		//13a
		queries.add("SELECT course_id1, course_id2, course_id3 FROM "
				+ "(WITH missing_skill AS ( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 1) "
				+ "MINUS"
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 2 ) ), "
				+ "CourseSet_Skill(csetID, skill_id) AS ( "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id1=CS.course_id "
				+ "UNION "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id2=CS.course_id "
				+ "UNION SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id3=CS.course_id ), "
				+ "/* use division to find those course sets that cover missing skills */ "
				+ "Cover_CSet(csetID, siz) AS ( "
				+ "SELECT csetID, siz FROM CourseSet CSet WHERE NOT EXISTS "
				+ "( SELECT skill_id FROM Missing_Skill "
				+ "MINUS "
				+ "SELECT skill_id FROM CourseSet_Skill CSSk "
				+ "WHERE CSSk.csetID = Cset.csetID ) ) "
				+ "/* to find the  sets */ "
				+ "SELECT course_id1, course_id2, course_id3 "
				+ "FROM Cover_CSet NATURAL JOIN CourseSet) ");//14a
		
		
		queries.add("SELECT * FROM CourseSet NATURAL JOIN (SELECT csetID, total FROM (WITH missing_skill AS ((SELECT skill_id FROM skill_require WHERE pos_code = 1) MINUS (SELECT skill_id FROM knows_skill WHERE person_id = 2 ) ), CourseSet_Skill(csetID, skill_id) AS ( SELECT csetID, skill_id FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id1=CS.course_id UNION SELECT csetID, skill_id FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id2=CS.course_id UNION SELECT csetID, skill_id FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id3=CS.course_id ), /* use division to find those course sets that cover missing skills */ Cover_CSet(csetID, siz) AS ( SELECT csetID, siz FROM CourseSet CSet WHERE NOT EXISTS ( SELECT skill_id FROM Missing_Skill MINUS SELECT skill_id FROM CourseSet_Skill CSSk WHERE CSSk.csetID = Cset.csetID ) ), total_cost AS ( SELECT csetID, ( (SELECT coalesce(retail_price,0) FROM Course C1 WHERE coalesce(CS.course_id1,0) = coalesce(C1.course_id,0)) + (SELECT coalesce(retail_price,0)  FROM Course C2 WHERE coalesce(CS.course_id2,0) = coalesce(C2.course_id,0)) + (SELECT coalesce(retail_price,0)  FROM Course C3 WHERE coalesce(CS.course_id3,0) = coalesce(C3.course_id,0) ) )AS total FROM CourseSet CS NATURAL JOIN Cover_CSEt )  /* to find the cheapest sets */ SELECT * FROM total_cost ORDER BY total ASC FETCH FIRST 3 ROWS ONLY))");
//15a
		
				
		
		queries.add("SELECT j.pos_code, j.job_title "
				+ "FROM job_profile j WHERE NOT EXISTS (   "
				+ "( SELECT R.skill_id  FROM skill_require R  WHERE R.pos_code=J.pos_code )"
				+ " MINUS "
				+ "( SELECT skill_id  FROM  knows_skill WHERE person_id=5 ) )");
		//16a
		queries.add("SELECT job_id, salary FROM job NATURAL JOIN (SELECT j.job_id FROM job j WHERE NOT EXISTS ( ( SELECT R.skill_id  FROM skill_require R  WHERE J.pos_code=R.pos_code) MINUS ( SELECT skill_id FROM  person NATURAL JOIN knows_skill WHERE name = 'William Ray' ) ) ) ORDER BY (SALARY) DESC FETCH FIRST 1 ROWS ONLY");
//17a
		queries.add("SELECT name,email FROM person P  WHERE NOT EXISTS( ( SELECT skill_id FROM skill_require WHERE pos_code=1 ) MINUS ( SELECT skill_id FROM knows_skill K WHERE P.person_id = K.person_id) )");
		//18a
		queries.add("SELECT person_id FROM knows_skill NATURAL JOIN skill_require WHERE pos_code=1 GROUP BY(person_id) HAVING  (SELECT COUNT(*) FROM skill_require Where pos_code=1)- COUNT(person_id)=1");
		//19a
		queries.add("WITH missing_one AS( SELECT person_id FROM knows_skill NATURAL JOIN skill_require WHERE pos_code=1 GROUP BY(person_id) HAVING  (SELECT COUNT(*) FROM skill_require WHERE pos_code=1  )- COUNT(person_id) =1)  select skill_id, count(*) as num_person from skill,missing_one M WHERE skill_id= (Select skill_id from(  (select skill_id from skill_require where pos_code=1) minus ( select K.skill_id  from knows_skill K where K.person_id = M.person_id)) ) GROUP BY (skill_id) order by num_person asc");
		//20a
		queries.add("WITH number_needs(person_id,needs) AS (  (SELECT person_id,((SELECT COUNT(*) FROM skill_require WHERE pos_code=1)-count(person_id)) as needs FROM knows_skill natural join skill_require WHERE pos_code = 13 GROUP BY (person_id) ) ) SELECT person_id,needs FROM  number_needs WHERE needs= (SELECT MIN(needs)  FROM number_needs)");

		//21a
		queries.add("WITH number_needs(person_id,needs) AS (  (SELECT person_id,((SELECT COUNT(*) FROM skill_require WHERE pos_code=1)-count(person_id)) as needs FROM knows_skill NATURAL JOIN skill_require WHERE pos_code=1 GROUP BY (person_id) ) ) SELECT * FROM(SELECT person_id,needs FROM number_needs N UNION SELECT person_id, (SELECT count(*) FROM skill_require WHERE pos_code=1) FROM person P WHERE P.person_id not in (SELECT person_id FROM number_needs) ) WHERE needs<=1 ORDER BY needs ASC");
		//22a
		queries.add("WITH number_needs(person_id,needs) AS (  (SELECT person_id,((SELECT COUNT(*) FROM skill_require WHERE pos_code=1)-count(person_id)) as needs FROM knows_skill NATURAL JOIN skill_require WHERE pos_code=1 GROUP BY (person_id) )) SELECT skill_id, count(*) as num_person FROM skill, number_needs M WHERE skill_id in (SELECT skill_id FROM (  (SELECT skill_id FROM skill_require WHERE pos_code=1) minus ( SELECT K.skill_id  FROM knows_skill K WHERE K.person_id = M.person_id)) ) GROUP BY (skill_id) ORDER BY num_person DESC");
		//23a
		queries.add("SELECT person_id,name FROM job_profile NATURAL JOIN job JOIN person USING(person_id) WHERE job_title= 'General Manager'");
		//24a
		queries.add("SELECT person_id,name FROM person NATURAL JOIN job JOIN job_profile using(pos_code) WHERE end_date <= to_date('08-NOV-15') AND job_title ='General Manager'");
		//25a
		queries.add("WITH number_jobs(company_id,job_count) AS (SELECT company_id, COUNT(*) FROM job GROUP BY (company_id) ) SELECT company_id FROM number_jobs WHERE job_count = (SELECT MAX(job_count)  FROM number_jobs)");
		//26a

		queries.add("SELECT DISTINCT name FROM job NATURAL JOIN person WHERE company_id = 3");
		//1b
		queries.add("SELECT name, job_title, salary FROM person NATURAL JOIN job NATURAL JOIN job_profile "
				+ "WHERE company_id=3 AND job_type='full-time' ORDER BY salary DESC");
		//2b
		queries.add("SELECT company_name,(SUM(salary)+SUM(wage_rate*1920)) AS total "
				+ "FROM company NATURAL JOIN job GROUP BY (company_name)");
		//3b
		queries.add("SELECT name, job_title FROM person NATURAL JOIN job NATURAL JOIN job_profile WHERE person_id = 10");
		//4b
		queries.add("SELECT name FROM work_on NATURAL JOIN person NATURAL JOIN job WHERE project_id = 2");
		//5b
		queries.add("SELECT name, skill_title, description FROM person NATURAL JOIN knows_skill NATURAL JOIN skill "
				+ "WHERE person_id = 10");
		//6b
		queries.add("SELECT skill_id FROM "
				+ "(SELECT skill_id FROM SKILL_REQUIRE NATURAL JOIN job_profile NATURAL JOIN job "
				+ "WHERE job_id = (SELECT job_id FROM job WHERE person_id = 13) )"
				+ "MINUS (SELECT skill_id FROM knows_skill WHERE person_id = 13)");
		//7b
		queries.add("SELECT skill_title FROM job NATURAL JOIN skill_require NATURAL JOIN skill WHERE job_id = 2");
		//8b
		queries.add("SELECT skill_id FROM "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 2) "
				+ "MINUS "
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 11)");
		//9b
		
		queries.add("SELECT course_id, course_title FROM( "
				+ "WITH missing_skill AS( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 4) )"
				+ "SELECT course_id, course_title FROM course c "
				+ "WHERE NOT EXISTS( SELECT skill_id FROM missing_skill "
				+ "MINUS "
				+ "SELECT skill_id FROM course_skill cs "
				+ "WHERE cs.course_id = c.course_id ))");
		//10b
		
		queries.add("SELECT course_id, course_title FROM( "
				+ "WITH missing_skill AS( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 3) "
				+ "MINUS "
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 11) ) "
				+ "SELECT course_id, course_title FROM course c "
				+ "WHERE NOT EXISTS( SELECT skill_id FROM missing_skill "
				+ "MINUS "
				+ "SELECT skill_id FROM course_skill cs "
				+ "WHERE cs.course_id = c.course_id ))");
		
		
		//11b
		queries.add("SELECT course_id, section_id, end_date FROM ( "
				+ "WITH missing_skill AS ( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 3)"
				+ " MINUS"
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 11 ) ), "
				+ "possible_courses AS ( "
				+ "SELECT course_id FROM course c "
				+ "WHERE NOT EXISTS( "
				+ "(SELECT skill_id FROM missing_skill) "
				+ "MINUS "
				+ "(SELECT skill_id FROM course_skill cs "
				+ "WHERE cs.course_id = c.course_id) ) ) "
				+ "SELECT course_id, section_id, end_date "
				+ "FROM possible_courses NATURAL JOIN section "
				+ "ORDER BY end_date ASC "
				+ "FETCH FIRST 1 ROWS ONLY )");	
		//12b

		queries.add("SELECT course_id1, course_id2, course_id3 FROM "
				+ "(WITH missing_skill AS (  "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 3) "
				+ "MINUS  "
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 11 ) ), "
				+ "CourseSet_Skill(csetID, skill_id) AS ( "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id1=CS.course_id "
				+ "UNION "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id2=CS.course_id "
				+ "UNION "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id3=CS.course_id ), "
				+ "/* use division to find those course sets that cover missing skills */ "
				+ "Cover_CSet(csetID, siz) AS ( "
				+ "SELECT csetID, siz FROM CourseSet CSet "
				+ "WHERE NOT EXISTS ( "
				+ "SELECT skill_id FROM Missing_Skill "
				+ "MINUS "
				+ "SELECT skill_id FROM CourseSet_Skill CSSk WHERE CSSk.csetID = Cset.csetID ) ) "
				+ "/* to find the smallest sets */ "
				+ "SELECT course_id1, course_id2, course_id3 "
				+ "FROM Cover_CSet NATURAL JOIN CourseSet "
				+ "WHERE siz = (SELECT MIN(siz) FROM Cover_CSet) )");
			//13b
		queries.add("SELECT course_id1, course_id2, course_id3 FROM "
				+ "(WITH missing_skill AS ( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 3) "
				+ "MINUS"
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 11 ) ), "
				+ "CourseSet_Skill(csetID, skill_id) AS ( "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id1=CS.course_id "
				+ "UNION "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id2=CS.course_id "
				+ "UNION SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id3=CS.course_id ), "
				+ "/* use division to find those course sets that cover missing skills */ "
				+ "Cover_CSet(csetID, siz) AS ( "
				+ "SELECT csetID, siz FROM CourseSet CSet WHERE NOT EXISTS "
				+ "( SELECT skill_id FROM Missing_Skill "
				+ "MINUS "
				+ "SELECT skill_id FROM CourseSet_Skill CSSk "
				+ "WHERE CSSk.csetID = Cset.csetID ) ) "
				+ "/* to find the  sets */ "
				+ "SELECT course_id1, course_id2, course_id3 "
				+ "FROM Cover_CSet NATURAL JOIN CourseSet) ");
		//14b
		
		
		queries.add("SELECT * FROM CourseSet NATURAL JOIN (SELECT csetID, total FROM "
				+ "(WITH missing_skill AS ((SELECT skill_id FROM skill_require WHERE pos_code = 3) "
				+ "MINUS (SELECT skill_id FROM knows_skill WHERE person_id = 11 ) ), "
				+ "CourseSet_Skill(csetID, skill_id) AS ( SELECT csetID, skill_id FROM "
				+ "CourseSet CSet JOIN course_skill CS ON CSet.course_id1=CS.course_id "
				+ "UNION SELECT csetID, skill_id FROM CourseSet CSet JOIN course_skill CS "
				+ "ON CSet.course_id2=CS.course_id UNION SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id3=CS.course_id ), "
				+ "/* use division to find those course sets that cover missing skills "
				+ "*/ Cover_CSet(csetID, siz) AS ( SELECT csetID, siz FROM CourseSet CSet WHERE NOT EXISTS "
				+ "( SELECT skill_id FROM Missing_Skill MINUS SELECT skill_id FROM CourseSet_Skill CSSk "
				+ "WHERE CSSk.csetID = Cset.csetID ) ), total_cost AS ( SELECT csetID, ( "
				+ "(SELECT coalesce(retail_price,0) "
				+ "FROM Course C1 WHERE coalesce(CS.course_id1,0) = coalesce(C1.course_id,0)) "
				+ "+ (SELECT coalesce(retail_price,0)  FROM Course C2 WHERE coalesce(CS.course_id2,0) "
				+ "= coalesce(C2.course_id,0)) "
				+ "+ (SELECT coalesce(retail_price,0)  FROM Course C3 WHERE coalesce(CS.course_id3,0) "
				+ "= coalesce(C3.course_id,0) ) )AS total FROM CourseSet CS NATURAL JOIN Cover_CSEt )  "
				+ "/* to find the cheapest sets */ "
				+ "SELECT * FROM total_cost ORDER BY total ASC FETCH FIRST 3 ROWS ONLY))");
//15b
		
				
		
		queries.add("SELECT j.pos_code, j.job_title "
				+ "FROM job_profile j WHERE NOT EXISTS (   "
				+ "( SELECT R.skill_id  FROM skill_require R  WHERE R.pos_code=J.pos_code )"
				+ " MINUS "
				+ "( SELECT skill_id  FROM  knows_skill WHERE person_id=13 ) )");
		//16b
		queries.add("SELECT job_id, salary FROM job NATURAL JOIN (SELECT j.job_id FROM job j WHERE NOT EXISTS "
				+ "( ( SELECT R.skill_id  FROM skill_require R  WHERE J.pos_code=R.pos_code) "
				+ "MINUS "
				+ "( SELECT skill_id FROM  person NATURAL JOIN knows_skill WHERE name = 'Gary King' ) ) ) "
				+ "ORDER BY (SALARY) DESC FETCH FIRST 1 ROWS ONLY");
//17b
		queries.add("SELECT name,email FROM person P  WHERE NOT EXISTS( "
				+ "( SELECT skill_id FROM skill_require WHERE pos_code=3 ) "
				+ "MINUS ( SELECT skill_id FROM knows_skill K WHERE P.person_id = K.person_id) )");
		//18b
		queries.add("SELECT person_id FROM knows_skill NATURAL JOIN skill_require WHERE pos_code=5 "
				+ "GROUP BY(person_id) HAVING  (SELECT COUNT(*) FROM skill_require Where pos_code=5)-"
				+ " COUNT(person_id)=1");
		//19b
		queries.add("WITH missing_one AS( SELECT person_id FROM knows_skill "
				+ "NATURAL JOIN skill_require WHERE pos_code=12 "
				+ "GROUP BY(person_id) HAVING  "
				+ "(SELECT COUNT(*) FROM skill_require WHERE pos_code=12  )- COUNT(person_id) =1)  "
				+ "select skill_id, count(*) as num_person from skill,missing_one M "
				+ "WHERE skill_id= (Select skill_id from(  (select skill_id from skill_require where pos_code=12) "
				+ "minus ( select K.skill_id  from knows_skill K where K.person_id = M.person_id)) ) "
				+ "GROUP BY (skill_id) order by num_person asc");
		//20b
		queries.add("WITH number_needs(person_id,needs) AS (  "
				+ "(SELECT person_id,((SELECT COUNT(*) FROM skill_require WHERE pos_code=14)-count(person_id)) "
				+ "as needs FROM knows_skill natural join skill_require WHERE pos_code = 14 GROUP BY (person_id) ) ) "
				+ "SELECT person_id,needs FROM  number_needs WHERE needs= (SELECT MIN(needs)  FROM number_needs)");

		//21b
		queries.add("WITH number_needs(person_id,needs) AS (  "
				+ "(SELECT person_id,((SELECT COUNT(*) FROM skill_require WHERE pos_code=13)"
				+ "-count(person_id)) as needs FROM knows_skill NATURAL JOIN skill_require WHERE pos_code=13 "
				+ "GROUP BY (person_id) ) ) SELECT * FROM(SELECT person_id,needs FROM number_needs N "
				+ "UNION SELECT person_id, (SELECT count(*) FROM skill_require WHERE pos_code=13) "
				+ "FROM person P WHERE P.person_id not in (SELECT person_id FROM number_needs) ) WHERE needs<=6 "
				+ "ORDER BY needs ASC");

		//22b
		queries.add("WITH number_needs(person_id,needs) AS (  (SELECT person_id,((SELECT COUNT(*) "
				+ "FROM skill_require WHERE pos_code=2)-count(person_id)) as needs FROM knows_skill "
				+ "NATURAL JOIN skill_require WHERE pos_code=2 GROUP BY (person_id) )) "
				+ "SELECT skill_id, count(*) as num_person FROM skill, number_needs M "
				+ "WHERE skill_id in (SELECT skill_id FROM (  (SELECT skill_id FROM skill_require WHERE pos_code=2) "
				+ "minus "
				+ "( SELECT K.skill_id  FROM knows_skill K WHERE K.person_id = M.person_id)) ) "
				+ "GROUP BY (skill_id) ORDER BY num_person DESC");
		//23b
		queries.add("SELECT person_id,name FROM job_profile NATURAL JOIN job JOIN person "
				+ "USING(person_id) WHERE job_title= 'Web Developer II'");
		//24b
		queries.add("SELECT person_id,name FROM person NATURAL JOIN job JOIN job_profile "
				+ "using(pos_code) WHERE job_title ='Web Developer II' AND end_date <= to_date('08-NOV-15') ");
		//25b
		queries.add("WITH number_jobs(company_id,job_count) AS "
				+ "(SELECT company_id, COUNT(*) FROM job GROUP BY (company_id) ) "
				+ "SELECT company_id FROM number_jobs WHERE job_count = "
				+ "(SELECT MAX(job_count)  FROM number_jobs)");
		//26b

		
		
	}
	public void createMap()
	{
		for(int i =0; i<queries.size();i++)
		{
			this.map.put(questions.get(i), queries.get(i));
		}
	}
	public String[] getQuestionList()
	{
		String[] ary=new String[1];
		ary=(String[]) this.questions.toArray(ary);
		return ary;
	}
	public String getQuery(String question)
	{
		return (String)map.get(question);
	}
}
