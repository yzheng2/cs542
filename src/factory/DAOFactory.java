package factory;

import dao.*;

public class DAOFactory {
	public static ICompanyDAO getICompanyDAOInstance() {// get Dao instance
		return new ICompanyDAO();
	}
}
