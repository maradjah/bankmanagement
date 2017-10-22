package accountTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.sid.entities.User;
import org.sid.metier.IUserMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
	
	private IUserMetier userMetier;
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		userMetier = (IUserMetier) context.getBean("metieru");

	}

	@Test
	public void test() {
		
		User user = new User("marwane", "661988");
		userMetier.addUser(user);
		String rep2 = userMetier.login("marwane", "661988");
		assertSame(rep2, "ok");
		
	}

}
