package riccardogulin.u5d2.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import riccardogulin.u5d2.dao.StudentsDAO;

@Component
@Order(1)
public class MyRunner2 implements CommandLineRunner {

	private StudentsDAO studentsDAO;

	public MyRunner2(StudentsDAO studentsDAO) {
		this.studentsDAO = studentsDAO;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CIAO DAL RUNNER 2");
		this.studentsDAO.save();
		this.studentsDAO.findById(2);
	}
}
