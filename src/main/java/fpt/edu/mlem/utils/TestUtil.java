package fpt.edu.mlem.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fpt.edu.mlem.entities.Question;
import fpt.edu.mlem.entities.QuestionAnswer;
import fpt.edu.mlem.response.QuestionRes;
import fpt.edu.mlem.response.TestRes;

public class TestUtil {
	
	public static TestRes TestQuestionFormat(List<Question> questionList) {
		
		TestRes testRes = new TestRes();
		List<QuestionRes> questionResList = new ArrayList<QuestionRes>();
		List<Integer> correctAnwserList = new ArrayList<>();
		for (Question question : questionList) {
			QuestionRes questionRes = new QuestionRes();
			//set questin
			questionRes.setContent(question.getContent());
			if (question.getImageUrl()!=null) {
				questionRes.setImageUrl(question.getImageUrl());
			}
			
			//set content question anwser
			Set<String> anwserSet = new HashSet<>();
			int indexCorrectAnwser = 1;
			for (QuestionAnswer questionAnswer : question.getAnwserSet()) {
				anwserSet.add(questionAnswer.getContent());
				if(questionAnswer.isCorrect()) {
					//set corrent anwser
					correctAnwserList.add(indexCorrectAnwser);
				}
				indexCorrectAnwser++;
			}
			String anwserString = anwserQuestionFormat(anwserSet);
			questionRes.setAnwserSet(anwserString);
			questionResList.add(questionRes);
		}
		testRes.setQuestionList(questionResList);
		String correctAnwserString = correctAnwserFormat(correctAnwserList);
		testRes.setCorrectAnwserList(correctAnwserString);
		return testRes;
	}
	
	public static String anwserQuestionFormat(Set<String> anwserSet) {
		String anwserString = anwserSet.toString();
		anwserString = anwserString.replace("[", "[\"");
		anwserString = anwserString.replace("]", "\"]");
		anwserString = anwserString.replace(", ", "\",\"");
		System.out.println(anwserString);
		return anwserString;
	}
	public static String correctAnwserFormat(List<Integer> correctAnwserList) {
		String correctAnwserString ="";
		for (int i = 0; i < correctAnwserList.size()-1; i++) {
			correctAnwserString += correctAnwserList.get(i) +",";		
		}
		correctAnwserString += correctAnwserList.get(correctAnwserList.size()-1);
		System.out.println(correctAnwserString);
		return correctAnwserString;
	}

}
