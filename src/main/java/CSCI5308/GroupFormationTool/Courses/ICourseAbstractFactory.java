package CSCI5308.GroupFormationTool.Courses;

public interface ICourseAbstractFactory {

    public ICourse createCourseInstance();

    public ICoursePersistence createCourseDBInstance();

    public ICourseUserRelationship courseUserInstance();

    public ICourseUserRelationshipPersistence courseUserRelationshipDBInstance();

}
