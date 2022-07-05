import java.util.*;
import java.util.stream.Collectors;
public class TestMain{
	
	
    public static HashMap<String,ArrayList<String>> retrieveStudentInfo(ArrayList<Student> al) {
       // implement the required business logic
    	    	
    	HashMap<String, ArrayList<String>> mapped_students = new HashMap<String, ArrayList<String>>();
    	String key = null;
    	ArrayList<String> values = new ArrayList<String>();
    	ArrayList<String> unique_values;
    	
    	for(Student student : al) {
    		
    		int count = 0;
    		
    		for(Student student1 : al) {
    			
    			String school_name = student.getSchoolName();
    			String student_name = student.getStudName();
    			
    			if(school_name.equals(student1.getSchoolName())) {
    				
    				
    				if(!student_name.equals(student1.getStudName())) {
        				
    					count++;
    					
    					key = student.getSchoolName();
        				values.add(student1.getStudName());
        				
        	    		unique_values = (ArrayList<String>) values.stream().distinct().collect(Collectors.toList());
        	    		
        	    		mapped_students.put(key, unique_values);	
    					
    				}
    				
    			}
    			
				if(count == 0) {
					
					ArrayList<String> names = new ArrayList<String>();
					names.add(student_name);
					
					mapped_students.put(school_name, names);
					
				}
    			
    		}
    		
    		
    	}
    	
    	
    	return mapped_students;
    }
    
    public static void main(String[] args)
    {
        Student s1=new Student();
        s1.setStudId(1);
        s1.setStudName("John");
        s1.setSchoolName("ZEE");
        Student s2=new Student();
        s2.setStudId(2);
        s2.setStudName("Tom");
        s2.setSchoolName("ZEE");
        Student s3=new Student();
        s3.setStudId(3);
        s3.setStudName("Peter");
        s3.setSchoolName("BEE");
        Student s4=new Student();
        s4.setStudId(4);
        s4.setStudName("Rose");
        s4.setSchoolName("OX-FO");
        Student s5=new Student();
        s5.setStudId(5);
        s5.setStudName("Alice");
        s5.setSchoolName("ZEE");
       
       //invoke the retrieveStudentInfo method and display the result
       ArrayList<Student> students = new ArrayList<Student>();
        
       students.add(s1);
       students.add(s2);
       students.add(s3);
       students.add(s4);
       students.add(s5);
       
       HashMap<String, ArrayList<String>> retrieveStudentInfo = retrieveStudentInfo(students);
       System.out.println(retrieveStudentInfo.keySet());
       System.out.println(retrieveStudentInfo.values());
        
    }
    
    
}