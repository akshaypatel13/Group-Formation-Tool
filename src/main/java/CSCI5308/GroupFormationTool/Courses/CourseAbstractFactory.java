package CSCI5308.GroupFormationTool.Courses;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;
import org.springframework.web.multipart.MultipartFile;

public class CourseAbstractFactory{

    private static CourseAbstractFactory uniqueInstance = null;
    private static ICoursePersistence courseDB;
    private static ICourseUserRelationship courseUserRelationship;
    private static ICourseUserRelationshipPersistence courseUserRelationshipDB;

    public static CourseAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new CourseAbstractFactory();
        }
        return uniqueInstance;
    }

    private CourseAbstractFactory(){
        courseDB = new CourseDB();
        courseUserRelationship = new CourseUserRelationship();
        courseUserRelationshipDB = new CourseUserRelationshipDB();
    }

    public ICourse createCourseInstance() {
        return new Course();
    }

    public ICoursePersistence createCourseDBInstance() {
        return courseDB;
    }

    public ICourseUserRelationship courseUserInstance() {
        return courseUserRelationship;
    }

    public ICourseUserRelationshipPersistence courseUserRelationshipDBInstance() {
        return courseUserRelationshipDB;
    }

    public IStudentCSVParser createStudentCSVParserInstance(MultipartFile file){
        return new StudentCSVParser(file);
    }

    public IStudentCSVImport createStudentCSVImportInstance(IStudentCSVParser parser, ICourse course){
        return new StudentCSVImport(parser,course);
    }

}
