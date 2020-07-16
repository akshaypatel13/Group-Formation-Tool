package CSCI5308.GroupFormationTool.Courses;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import CSCI5308.GroupFormationTool.AccessControl.IUser;

public class StudentCSVParser implements IStudentCSVParser {
	private static final Logger LOG = LogManager.getLogger();
	private MultipartFile uploadedFile;
	private List<IUser> studentList = new ArrayList<>();

	public StudentCSVParser(MultipartFile file) {
		this.uploadedFile = file;

	}

	@Override
	public List<IUser> parseCSVFile(List<String> failureResults) {
		try {
			Reader reader = new InputStreamReader(uploadedFile.getInputStream());
			CSVReader csvReader = new CSVReaderBuilder(reader).build();
			List<String[]> records = csvReader.readAll();
			Iterator<String[]> iter = records.iterator();
			IUser u;
			while (iter.hasNext()) {
				String[] record = iter.next();

				String bannerID = record[0];
				String firstName = record[1];
				String lastName = record[2];
				String email = record[3];

				u = UserAbstractFactory.instance().createUserInstance();
				u.setBannerID(bannerID);
				u.setFirstName(firstName);
				u.setLastName(lastName);
				u.setEmail(email);
				studentList.add(u);
			}
			LOG.info("CSV Upload operation successful for File = " + uploadedFile.getName());
		} catch (IOException e) {
			LOG.error("CSV Upload operation failed for File = " + uploadedFile.getName());
			failureResults.add("Failure reading uploaded file: " + e.getMessage());
		} catch (Exception e) {
			LOG.error("CSV parse operation failed for File = " + uploadedFile.getName());
			failureResults.add("Failure parsing CSV file: " + e.getMessage());
		}

		return studentList;
	}

}
