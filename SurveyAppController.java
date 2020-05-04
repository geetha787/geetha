package com.capgemini.surveyapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import org.apache.log4j.Logger;

import com.capgemini.surveyapp.Bean.AdminInfoBean;
import com.capgemini.surveyapp.Bean.CreateSurveyDetailsBean;
import com.capgemini.surveyapp.Bean.RespondentInfoBean;
import com.capgemini.surveyapp.Bean.SurveyorInfoBean;
import com.capgemini.surveyapp.controller.SurveyAppController;
import com.capgemini.surveyapp.dao.SurveyorDAO;
import com.capgemini.surveyapp.factory.FactoryLayer;
import com.capgemini.surveyapp.service.AdminServiceLayer;
import com.capgemini.surveyapp.service.RespondentService;
import com.capgemini.surveyapp.service.SurveyorService;
import com.capgemini.surveyapp.service.SurveyorServiceImplement;
import com.capgemini.surveyapp.controller.SurveyAppController;
import com.capgemini.surveyapp.validation.InputValidation;
import com.capgemini.surveyapp.validation.InputValidationImplement;

public class SurveyAppController {
	static final Logger logg = Logger.getLogger(SurveyAppController.class);

	public static void main(String[] args) {
		InputValidation inputValid = new InputValidationImplement();
		Scanner scann = new Scanner(System.in);
		boolean flag = true;
		SurveyorService surveyorservice = FactoryLayer.getSurveyorServiceInstance();
		surveyorservice.defaultSurveyorSurveyDesc();
		SurveyorService surveyorservice1 = FactoryLayer.getSurveyorServiceInstance();
		surveyorservice1.defaultSurveyLogin();
		AdminServiceLayer adminservice = FactoryLayer.getAdminServicePartInstance();
		adminservice.defaultadminLogin();
		RespondentService respondentservice = FactoryLayer.getRespondentServiceInstance();
		respondentservice.defaultrespondent();
	  P:	do {
			logg.info("------------------------HI WELCOME TO SURVEY APP----------------------");
			logg.info("Please tell us,  Who are you........?");
			logg.info("1.Administrator");
			logg.info("2.Surveyor");
			logg.info("3.Responder");
			logg.info("4.Exit");
			String extractPerson = scann.nextLine();
			while (!inputValid.ChoiceCheckValidate(extractPerson)) {
				logg.info("please enter the valid Option");
				extractPerson = scann.nextLine();
			}
			int surveyorLogin = Integer.parseInt(extractPerson);
			switch (surveyorLogin) {
			case 1:
				logg.info("Please make a login to enter your administrator Account");
				AdminServiceLayer adminServicePart=FactoryLayer.getAdminServicePartInstance();
				adminServicePart.AdminLogin(new AdminInfoBean());
				break;
			case 2:
				logg.info(" Please make a login to enter the your Surveyor account");
				SurveyorService surveyorservice2 = FactoryLayer.getSurveyorServiceInstance();
			    surveyorservice2.surveyorServLogin(new SurveyorInfoBean());
				break;
			case 3:
				logg.info(" Please make a login to enter the your Respondent account");
				RespondentService respondentservice1 = FactoryLayer.getRespondentServiceInstance();
			    respondentservice1.defaultrespondentLogin();
				break;
			case 4:
				break P;
				
			}
		} while (true);
	}
}
