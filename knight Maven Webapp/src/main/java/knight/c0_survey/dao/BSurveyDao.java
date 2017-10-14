package knight.c0_survey.dao;

import java.util.List;

import knight.c0_survey.entity.BAns;
import knight.c0_survey.entity.BAnsDetail;
import knight.c0_survey.entity.BOption;
import knight.c0_survey.entity.BQuestion;
import knight.c0_survey.entity.BSurvey;

public interface BSurveyDao {
	
	List<BSurvey> getAllSurvey();
	
	BSurvey getSurvey(int svId);
	
	BQuestion getQuestion(int svId, int num); 

	List<BOption> getOptions(int quesId,int num);
		
	void insertAns(BAns ans);
	
	void insertAnsDetail(BAnsDetail ansDtl);
	
	void setAnsComplete(BAns ans);
}
