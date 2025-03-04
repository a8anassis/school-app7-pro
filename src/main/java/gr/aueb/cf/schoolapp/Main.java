package gr.aueb.cf.schoolapp;

import gr.aueb.cf.schoolapp.view_controller.*;

import java.awt.EventQueue;

public class Main {
	private static final LandingPage landingPage = new LandingPage();
	private static final LoginPage loginPage = new LoginPage();
	private static final Dashboard dashboard =  new Dashboard();
	private static final ViewTeachersPage viewTeachersPage = new ViewTeachersPage();
	private static final TeacherView teacherView = new TeacherView();
	private static final UpdateTeacherPage updateTeacherPage = new UpdateTeacherPage();
	private static final InsertTeacherPage insertTeacherPage = new InsertTeacherPage();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					landingPage.setVisible(true);
					landingPage.setLocationRelativeTo(null);
					
					loginPage.setVisible(false);
					loginPage.setLocationRelativeTo(null);
					
					dashboard.setVisible(false);
					dashboard.setLocationRelativeTo(null);
					
					viewTeachersPage.setVisible(false);
					viewTeachersPage.setLocationRelativeTo(null);
					
					insertTeacherPage.setVisible(false);
					insertTeacherPage.setLocationRelativeTo(null);
					
					teacherView.setVisible(false);
					teacherView.setLocationRelativeTo(null);
					
					updateTeacherPage.setVisible(false);
					updateTeacherPage.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static LandingPage getLandingPage() {
		return landingPage;
	}

	public static LoginPage getLoginPage() {
		return loginPage;
	}

	public static Dashboard getDashboard() {
		return dashboard;
	}

	public static ViewTeachersPage getViewTeachersPage() {
		return viewTeachersPage;
	}

	public static TeacherView getTeacherView() {
		return teacherView;
	}

	public static UpdateTeacherPage getUpdateTeacherPage() {
		return updateTeacherPage;
	}

	public static InsertTeacherPage getInsertTeacherPage() {
		return insertTeacherPage;
	}
	
	
}
