package scene.survey.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by Liu Woon Kit on 12/6/2017.
 */
public class Survey {
    private String surveyTitle;
    private int surveyID;
    private GregorianCalendar submissionDate = new GregorianCalendar();
    private ArrayList<SurveyQuestion> surveyQuestions = new ArrayList<>();

    public void addSurveyQuestions(ResultSet rs) {
        try {
            while(rs.next()) {
                //surveyQuestions.add();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}