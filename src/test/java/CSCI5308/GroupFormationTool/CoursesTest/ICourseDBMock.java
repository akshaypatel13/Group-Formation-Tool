package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.ICourse;

import java.util.List;

public interface ICourseDBMock {
    public List<ICourse> loadAllCoursesTest();
    public void loadCourseByIDTest(long id, ICourse course);
    public boolean createCourseTest(ICourse course);
    public boolean deleteCourseTest(long id);
}
