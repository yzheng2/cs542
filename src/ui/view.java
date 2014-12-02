package ui;
import java.util.*;

import javax.swing.JFrame;

import vo.Events;
import factory.DAOFactory;
public class view{

    public static void main(String[] args) throws Exception {
    	
    	Login_frame lo = new Login_frame();
    	lo.setVisible(true);
    	
    }
   
} 

class newThread implements Runnable{
	 public int i=0;
	 private String UserID;
	 User_Frame my;
	
	@Override
	public void run() {
		try {
			
			my=new User_Frame(UserID);
			my.setVisible(true);
	    	my.setResizable(false);
	        my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		controller.setUi(my.getUserInof());
		while(true){
			try {
				Thread.sleep(10000);
				Events event = DAOFactory.getIEventsInstance().getRandomEvent();
				controller.setEvent(event);
				my.getTotals().updata();
				my.getTotals().updateUI();
				my.getstockpanel().updata();
				my.getstockpanel().updateUI();
				//my.getUserInof().update();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	}	
	
	void setUserID(String UserID){
		this.UserID = UserID;
	}
}
