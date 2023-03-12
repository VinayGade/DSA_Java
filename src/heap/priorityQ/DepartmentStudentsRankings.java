package heap.priorityQ;

import heap.beans.Employee;
import heap.beans.Student;

import java.util.*;

public class DepartmentStudentsRankings {

    public List<Student> findRankings(List<Student> allStudents){
        List<Student> studentRankingsDept = new ArrayList<>();
        Queue<Student> rankingsTop3 = new PriorityQueue<>(allStudents.size(),
                (Student s1, Student s2)->Float.compare(s1.getPercent(),s2.getPercent())
        );

        Queue<Student> rankingsDeptWise = new PriorityQueue<>(allStudents.size(),
                Comparator.comparing(Student::getPercent)
                        .thenComparing(Student::getDepartment)
        );

        rankingsDeptWise.addAll(allStudents);

        // 3 departments : CM, IT, EXTC    3 rankings.  ...Hence 3*3 = 9 students
        int k = 9;
        for(int i = 0; i<k; i++){
            studentRankingsDept.add(rankingsDeptWise.poll());
        }

        return studentRankingsDept;
    }

    public static void main(String[] args) {

        DepartmentStudentsRankings studentsRankings = new DepartmentStudentsRankings();

        List<Student> allStudents = new ArrayList<>();
        Student s1 = new Student();
        s1.setName("Vinay");
        s1.setDepartment("CM");
        s1.setPercent(65.38f);

        Student s2 = new Student();
        s2.setName("Rahul");
        s2.setDepartment("CM");
        s2.setPercent(70.04f);

        Student s3 = new Student();
        s3.setName("Sushant");
        s3.setDepartment("CM");
        s3.setPercent(82.08f);

        Student s4 = new Student();
        s4.setName("Vivek");
        s4.setDepartment("CM");
        s4.setPercent(80.06f);

        Student s5 = new Student();
        s5.setName("Ganesh");
        s5.setDepartment("CM");
        s5.setPercent(81.53f);

        Student s6 = new Student();
        s6.setName("Amrut");
        s6.setDepartment("EXTC");
        s6.setPercent(68.46f);

        Student s7 = new Student();
        s7.setName("Vikas");
        s7.setDepartment("EXTC");
        s7.setPercent(75.38f);

        Student s8 = new Student();
        s8.setName("Siddhesh");
        s8.setDepartment("EXTC");
        s8.setPercent(67.03f);

        Student s9 = new Student();
        s9.setName("Ketan");
        s9.setDepartment("EXTC");
        s9.setPercent(72.84f);

        Student s10 = new Student();
        s10.setName("Ankit");
        s10.setDepartment("EXTC");
        s10.setPercent(79.84f);

        Student s11 = new Student();
        s11.setName("Anil");
        s11.setDepartment("IT");
        s11.setPercent(85.38f);

        Student s12 = new Student();
        s12.setName("Dinesh");
        s12.setDepartment("IT");
        s12.setPercent(81.03f);

        Student s13 = new Student();
        s13.setName("Vinod");
        s13.setDepartment("IT");
        s13.setPercent(89.68f);

        Student s14 = new Student();
        s14.setName("Ajay");
        s14.setDepartment("IT");
        s14.setPercent(75.38f);

        Student s15 = new Student();
        s15.setName("Kunal");
        s15.setDepartment("IT");
        s15.setPercent(72.91f);

        allStudents.add(s1);
        allStudents.add(s2);
        allStudents.add(s3);
        allStudents.add(s4);
        allStudents.add(s5);

        allStudents.add(s6);
        allStudents.add(s7);
        allStudents.add(s8);
        allStudents.add(s9);
        allStudents.add(s10);

        allStudents.add(s11);
        allStudents.add(s12);
        allStudents.add(s13);
        allStudents.add(s14);
        allStudents.add(s15);

        List<Student> studentRankingsDept = studentsRankings.findRankings(allStudents);
       // studentRankingsDept.forEach(System.out::println);

        for(Student student : studentRankingsDept)
            System.out.println(student.toString());
    }
}
