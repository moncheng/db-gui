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
		questions.add("1. List a company's workers by names.");
		questions.add("2. List a company's staff by salary in descending order.");
		questions.add("3. List companies' labor cost (total salaries and wage rates by 1920 hours) in descending order.");
		questions.add("4. Find all the jobs a person is currently holding.");
		questions.add("5. List all the workers who are working for a specific project.");
		questions.add("6. List a person's knowledge/skills in a readable format.");
		questions.add("7. List the skill gap of a worker between his/her job(s) and his/her skills.");
		questions.add("8. List the required knowledge/skills of a job profile in a readable format.");
		questions.add("9. List a person's missing knowledge/skills for a specific job in a readable format.");
		questions.add("10. Find the courses each of which alone can cover a given skill set.");
		questions.add("11. List the courses (course id and title) that each alone teaches all the missing knowledge/skills for a person to pursue a specific job.");
		questions.add("12. Suppose the skill gap of a worker and the requirement of a desired job can be covered by one course. Find the 'quickest' solution for this worker. Show the course and the completing date.");
		questions.add("13. If query #10 returns nothing, then find the course sets with the minimum number of courses that their combination covers the given skill set. The considered course sets will not include more than three courses.");
		questions.add("14. List the course sets that their combinations cover all the missing knowledge/skills for a person to pursue a specific job. The considered course sets will not include more than three courses.");
		questions.add("15. Find the cheapest course choices to make up one's skill gap by showing the courses to take and the total cost. The considered course sets will not include more than three courses.");
		questions.add("16. List all the job profiles that a person is qualified.");
		questions.add("17. Find the job with the highest pay rate for a person according to his/her skill qualification.");
		questions.add("18. List all the names along with the emails of the persons who are qualified for a job profile.");
		questions.add("19. When a company cannot find any qualified person for a job, a secondary solution is to find a person who is almost qualified to the job. Make a 'missing-one' list that lists people who miss only one skill for a specified job profile.");
		questions.add("20. List the skillID and the number of people in the missing-one list for a given job profile in the ascending order of the people counts.");
		questions.add("21. Suppose there is a new job profile that has nobody qualified. List the persons who miss the least number of skills and report the 'least number'.");
		questions.add("22. For a specified job profile and a given small number k, make a 'missing-k' list that lists the people's IDs and the number of missing skills for the people who miss only up to k skills in the ascending order of missing skills.");
		questions.add("23. Given a job profile and its corresponding missing-k list specified in Question 22. Find every skill that is needed by at least one person in the given missing-k list. List each skillID and the number of people who need it in the descending order of the people counts.");
		questions.add("24. In a local or national crisis, we need to find all the people who once held a job of the special job-profile identifier.");
		questions.add("25. Find all the unemployed people who once held a job of the given job-profile identifier.");
		questions.add("26. Find out the biggest employer in terms of number of employees or the total amount of salaries and wages paid to employees.");
		questions.add("Create all tables");
		questions.add("Drop all tables");
		questions.add("Insert all tables");
		
	}
	public void addQueries()
	{
		queries.add("SELECT DISTINCT name FROM person NATURAL JOIN job WHERE company_id = 2");
		//1
		queries.add("SELECT name, job_title, salary FROM person NATURAL JOIN job NATURAL JOIN job_profile "
				+ "WHERE company_id=2 AND job_type='full-time' ORDER BY salary DESC");
		//2
		queries.add("SELECT company_name,(SUM(salary)+SUM(wage_rate*1920)) AS total "
				+ "FROM company NATURAL JOIN job NATURAL JOIN job_profile GROUP BY (company_name)");
		//3
		queries.add("SELECT name, job_title FROM person NATURAL JOIN job NATURAL JOIN job_profile WHERE person_id = 1");
		//4
		queries.add("SELECT name FROM work_on NATURAL JOIN person NATURAL JOIN job WHERE project_id = 1");
		//5
		queries.add("SELECT name, skill_title, description FROM person NATURAL JOIN knows_skill NATURAL JOIN skill "
				+ "WHERE person_id = 1");
		//6
		queries.add("SELECT skill_id FROM "
				+ "(SELECT skill_id FROM SKILL_REQUIRE NATURAL JOIN job_profile NATURAL JOIN job "
				+ "WHERE job_id = (SELECT job_id FROM job WHERE person_id = 2) )"
				+ "MINUS (SELECT skill_id FROM knows_skill WHERE person_id = 2)");
		//7
		queries.add("SELECT skill_title FROM job NATURAL JOIN skill_require NATURAL JOIN skill WHERE job_id = 1");
		//8
		queries.add("SELECT skill_id FROM "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 1) "
				+ "MINUS "
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 2)");
		//9
		//not correct : queries.add("SELECT course_id, title FROM course c WHERE NOT EXISTS( SELECT skill_id FROM skill MINUS SELECT skill_id FROM course_skill cs WHERE cs.course_id = c.course_id )");
		queries.add("");
		//10
		queries.add("SELECT course_id, course_title FROM( "
				+ "WITH missing_skill AS( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 1) "
				+ "MINUS "
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 1) ) "
				+ "SELECT course_id, course_title FROM course c "
				+ "WHERE NOT EXISTS( SELECT skill_id FROM missing_skill "
				+ "MINUS "
				+ "SELECT skill_id FROM course_skill cs "
				+ "WHERE cs.course_id = c.course_id ))");//11
		queries.add("SELECT course_id, section_id, end_date FROM ( "
				+ "WITH missing_skill AS ( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 1)"
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
				+ "FETCH FIRST 1 ROWS ONLY )");	//12

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
				+ "WHERE siz = (SELECT MIN(siz) FROM Cover_CSet) )");//13
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
				+ "FROM Cover_CSet NATURAL JOIN CourseSet) ");//14
		queries.add("SELECT * FROM CourseSet NATURAL JOIN ( "
				+ "SELECT csetID, total FROM ("
				+ "WITH missing_skill AS ( "
				+ "(SELECT skill_id FROM skill_require WHERE pos_code = 1) "
				+ "MINUS "
				+ "(SELECT skill_id FROM knows_skill WHERE person_id = 2 ) ), "
				+ "CourseSet_Skill(csetID, skill_id) AS ( "
				+ "SELECT csetID, skill_id "
				+ "FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id1=CS.course_id "
				+ "UNION "
				+ "SELECT csetID, skill_id FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id2=CS.course_id "
				+ "UNION "
				+ "SELECT csetID, skill_id FROM CourseSet CSet JOIN course_skill CS ON CSet.course_id3=CS.course_id ), "
				+ "/* use division to find those course sets that cover missing skills */"
				+ " Cover_CSet(csetID, siz) AS ( "
				+ "SELECT csetID, siz FROM CourseSet CSet WHERE NOT EXISTS ( "
				+ "SELECT skill_id FROM Missing_Skill "
				+ "MINUS "
				+ "SELECT skill_id FROM CourseSet_Skill CSSk WHERE CSSk.csetID = Cset.csetID ) ), "
				+ "total_cost AS ( SELECT csetID, ( "
				+ "(SELECT retail_price FROM Course C1 WHERE CS.course_id1 = C1.course_id) + "
				+ "(SELECT retail_price FROM Course C2 WHERE CS.course_id2 = C2.course_id) + "
				+ "(SELECT retail_price FROM Course C3 WHERE CS.course_id3 = C3.course_id)  )AS total "
				+ "FROM CourseSet CS NATURAL JOIN Cover_CSEt ) "
				+ "/* to find the cheapest sets */ "
				+ "SELECT * FROM total_cost ORDER BY total DESC FETCH FIRST 3 ROWS ONLY))");//15
		queries.add("SELECT j.pos_code, j.job_title "
				+ "FROM job_profile j WHERE NOT EXISTS (   "
				+ "( SELECT R.skill_id  FROM skill_require R  WHERE R.pos_code=J.pos_code )"
				+ " MINUS "
				+ "( SELECT skill_id  FROM  knows_skill WHERE person_id=5 ) )");//16
		queries.add("SELECT j.pos_code, MAX(salary+(wage_rate*1920)) AS max_income FROM job_profile j WHERE NOT EXISTS ( ( SELECT R.skill_id  FROM skill_require R  WHERE J.pos_code=R.pos_code) MINUS ( SELECT skill_id  FROM  knows_skill WHERE person_id=4 ) ) GROUP BY (pos_code)");
		//17
		queries.add("SELECT name,email FROM person P  WHERE NOT EXISTS( ( SELECT skill_id FROM skill_require WHERE pos_code=1 ) MINUS ( SELECT skill_id FROM knows_skill K WHERE P.person_id = K.person_id) )");
		//18
		queries.add("SELECT person_id FROM knows_skill NATURAL JOIN skill_require WHERE pos_code=1 GROUP BY(person_id) HAVING  (SELECT COUNT(*) FROM skill_require Where pos_code=1)- COUNT(person_id)=1");
		//19
		queries.add("WITH missing_one AS  ( SELECT skill_id  FROM knows_skill NATURAL JOIN skill_require GROUP BY(skill_id) HAVING  (SELECT COUNT(*) FROM skill_require WHERE pos_code=1  )- COUNT(person_id) =1)  SELECT skill_id, COUNT(*) AS personsMissing_count FROM missing_one  GROUP BY (skill_id) ORDER BY personsMissing_count ASC");
		//20
		queries.add("WITH number_needs(person_id,needs) AS (  (SELECT person_id,((SELECT COUNT(*) FROM skill_require WHERE pos_code=1)-count(person_id)) as needs FROM knows_skill natural join skill_require GROUP BY (person_id) ) ) SELECT person_id,needs FROM  number_needs WHERE needs= (SELECT MIN(needs)  FROM number_needs)");
		//21
		queries.add("WITH number_needs(person_id,needs) AS ( (SELECT person_id,((SELECT COUNT(*) FROM skill_require WHERE pos_code=1)-count(person_id)) as needs FROM knows_skill natural join skill_require GROUP BY (person_id) ) ) SELECT person_id,needs FROM number_needs WHERE needs <=2 ORDER BY needs ASC");
		//22
		queries.add("WITH missing_one AS  ( SELECT skill_id  FROM knows_skill NATURAL JOIN skill_require GROUP BY(skill_id) HAVING  (SELECT COUNT(*) FROM skill_require WHERE pos_code=1  )- COUNT(person_id) =1) SELECT skill_id, COUNT(*) AS personsMissing_count FROM missing_one  GROUP BY (skill_id) ORDER BY personsMissing_count DESC");
		//23
		queries.add("SELECT person_id,name FROM job_profile NATURAL JOIN job JOIN person USING(person_id) WHERE job_title= 'virus analyst'");
		//24
		queries.add("SELECT person_id,name FROM person NATURAL JOIN job JOIN job_profile using(pos_code) WHERE end_date <= to_date('08-NOV-15') AND title ='virus analyst'");
		//25
		queries.add("WITH number_jobs(company_id,job_count) AS (SELECT company_id, COUNT(*) FROM job GROUP BY (company_id) ) SELECT company_id FROM number_jobs WHERE job_count = (SELECT MAX(job_count)  FROM number_jobs)");
		//26


		
		
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
