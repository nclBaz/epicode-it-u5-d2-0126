package riccardogulin.u5d2.dao;

import org.springframework.stereotype.Component;

@Component
public class StudentsDAO {
	public void findById(int id) {
		System.out.println("Ecco lo studente");
	}

	public void save() {
		System.out.println("Studente salvato!");
	}

	public void findUserByTesseraId(int tesseraId) {
	}
}
