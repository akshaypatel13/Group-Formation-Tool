package CSCI5308.GroupFormationTool.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.Question;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionType;

public class ResponseDBMock implements IResponsePersistence
{


    @Override
    public List<IQuestion> loadQuestionsWithoutOptions(long courseId) {
        List<IQuestion> questions = new ArrayList<IQuestion>();

        Question q = new Question();
        q.setId(1);
        q.setTitle("Text Title");
        q.setText("Text Question");
        q.setType(QuestionType.TEXT);
        questions.add(q);

        q = new Question();
        q.setId(1);
        q.setTitle("Numeric Title");
        q.setText("Numeric Question");
        q.setType(QuestionType.NUMERIC);
        questions.add(q);

        return questions;    }

    @Override
    public List<IQuestion> loadQuestionsWithOptions(long courseId) {
        List<IQuestion> questions = new ArrayList<IQuestion>();
        Question q = new Question();
        q.setId(1);
        q.setTitle("Mcqone Title");
        q.setText("Mcqone Question");
        q.setType(QuestionType.MCQONE);
        questions.add(q);

        q = new Question();
        q.setId(1);
        q.setTitle("Mcqmultiple Title");
        q.setText("Mcqmultiple Question");
        q.setType(QuestionType.MCQMULTIPLE);
        questions.add(q);

        return questions;    }

    @Override
    public List<IQuestion> loadQuestionsOptions(List<IQuestion> quesions) {
        List<IQuestion> questions = new ArrayList<IQuestion>();
        ArrayList<String> options = new ArrayList<String>();

        options.add("1");
        options.add("2");

        Question q = new Question();
        q.setId(1);
        q.setTitle("Mcqone Title");
        q.setText("Mcqone Question");
        q.setOptions(options);
        q.setType(QuestionType.MCQONE);
        questions.add(q);

        q = new Question();
        q.setId(1);
        q.setTitle("Mcqmultiple Title");
        q.setText("Mcqmultiple Question");
        q.setOptions(options);
        q.setType(QuestionType.MCQMULTIPLE);
        questions.add(q);

        return questions;    }

    @Override
    public boolean saveResponse(HashMap<String, String> answer, String bannerId) {
        if(answer.isEmpty())
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkIsMCQMultiple(String questionId) {
        if(questionId.isEmpty()) {
            return false;
        }
        return true;
    }


}
