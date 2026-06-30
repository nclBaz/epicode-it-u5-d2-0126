package riccardogulin.u5d2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import riccardogulin.u5d2.dao.StudentsDAO;
import riccardogulin.u5d2.entities.Interviewer;

@SpringBootApplication
public class U5d2Application {

	public static void main(String[] args) {

		SpringApplication.run(U5d2Application.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5d2Application.class);

		Interviewer i = ctx.getBean(Interviewer.class);
		i.askQuestion();

//		StudentsDAO studentsDAO = new StudentsDAO();
//		studentsDAO.findById(2);

		StudentsDAO studentsDAO = ctx.getBean(StudentsDAO.class);
		studentsDAO.findById(2);

	}

}
