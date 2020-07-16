package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationshipPersistence;

public class CourseAbstractFactoryTest {

	private static CourseAbstractFactoryTest uniqueInstance = null;
	private ICoursePersistence courseDBMock;
	private ICourseUserRelationshipPersistence courseUserRelationshipPersistence;
	private ICSVReaderMock csvReaderMock;

	public static CourseAbstractFactoryTest instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new CourseAbstractFactoryTest();
		}
		return uniqueInstance;
	}

	private CourseAbstractFactoryTest() {
		courseDBMock = new CourseDBMock();
		courseUserRelationshipPersistence = new CourseUserRelationshipDBMock();
		csvReaderMock = new CSVReaderMock();
	}

	public ICoursePersistence getCourseDBMock() {
		return courseDBMock;
	}

	public ICourseUserRelationshipPersistence getCourseUserRelationshipPersistence() {
		return courseUserRelationshipPersistence;
	}

	public ICSVReaderMock getCsvReaderMock() {
		return csvReaderMock;
	}
}
