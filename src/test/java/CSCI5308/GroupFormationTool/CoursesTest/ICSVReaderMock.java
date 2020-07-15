package CSCI5308.GroupFormationTool.CoursesTest;

import java.io.Reader;
import java.util.List;

public interface ICSVReaderMock {
    public List<String[]> readAll(Reader reader);
}
