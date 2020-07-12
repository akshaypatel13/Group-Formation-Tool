package CSCI5308.GroupFormationTool.Courses;

import java.util.*;

public class DefaultGroupCreator implements IGroupCreator {
    @Override
    public Map<Integer, List<Integer>> createGroups(int courseID, int size) {

        int noOfStudents = 60;
        Map<Integer, List<Integer>> groups = new HashMap<>();
        List<Integer> students = new LinkedList<>();
        for(int i=0;i<noOfStudents;i++){
            students.add(i);
        }

        int groupNumber = 0;
        int studentCount = 0;

        int noOfGroups = (int) Math.ceil(noOfStudents / size);

        while(groupNumber < noOfGroups){

            List<Integer> studentsInGroup = new ArrayList<>();
            for(int i=0;i<size;i++){
                int index = (int) (Math.random() * students.size());
                studentsInGroup.add(students.get(index));
                students.remove(index);
            }
            groups.put(groupNumber, studentsInGroup);
            groupNumber++;

        }
        List<Integer> studentsInGroup = new ArrayList<>();
        for (int student : students){
            studentsInGroup.add(student);
        }
        groups.put(groupNumber, studentsInGroup);

        return groups;
    }
}
