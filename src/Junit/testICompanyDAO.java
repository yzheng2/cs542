package Junit;

import static org.junit.Assert.*;

import org.junit.Test;

import vo.Company;
import factory.DAOFactory;

public class testICompanyDAO {

	@Test
	/*public void test() {
		fail("Not yet implemented");
	}*/
	public void testICompanyDAO() throws Exception{
		 System.out.println("**testICompanyDAO**");
		 Company company = new Company();
		 company.setCid("11");
		 company.setMarketValuation(1111.00);
		 boolean result = DAOFactory.getICompanyDAOInstance().testMethod(company);
		 boolean expResult = true;
		 assertEquals(expResult, result);
	}
}
