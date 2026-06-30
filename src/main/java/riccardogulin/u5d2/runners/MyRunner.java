package riccardogulin.u5d2.runners;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import riccardogulin.u5d2.dao.StudentsDAO;

@Component
@Order(2)
public class MyRunner implements CommandLineRunner {

	private Faker faker;
	private StudentsDAO studentsDAO;

	public MyRunner(Faker faker, StudentsDAO studentsDAO) {
		this.faker = faker;
		this.studentsDAO = studentsDAO;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CIAO DAL RUNNER");
		System.out.println(this.faker.backToTheFuture().character());

		this.studentsDAO.save();
	}
}
