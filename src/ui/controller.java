package ui;

import java.util.ArrayList;

import vo.Events;
import vo.Stock;
import factory.DAOFactory;

public class controller {
	private static UserInformation ui;
	private static boolean transactionresult;
	private static Events event;

	public static Events getEvent() {
		return event;
	}

	public static void setEvent(Events event) {
		controller.event = event;
	}

	public static boolean gettransactionresult() {
		return transactionresult;
	}

	public static void settransactionresult(boolean transactionresult) {
		controller.transactionresult = transactionresult;
	}

	public static UserInformation getUi() {
		return ui;
	}

	public static  void setUi(UserInformation ui) {
		controller.ui = ui;
	}
	
	
}
