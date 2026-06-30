package riccardogulin.u5d2.entities;

import org.springframework.stereotype.Component;

@Component
public class Interviewer {
	// Esempio di ACCOPPIAMENTO MOLTO MOLTO FORTE
	// private Student student = new BackendStudent("Aldo", "Baglio"); // Questa è una DIPENDENZA nei confronti di un'altra classe

	// FIELD INJECTION - La uso se non voglio il costruttore (però è considerata una BAD PRACTICE)
	// @Autowired // <-- Se voglio che in fase di creazione, mi venga iniettato uno Student (preso dallo scatolone)
	// allora devo usare l'annotazione @Autowired. Se non la usassi, allora student sarebbe null quando l'oggetto
	// viene creato con possibili conseguenze tipo la NullPointerException
	private Student student;

	// CONSTRUCTOR INJECTION (è l'approccio più consigliato)
	// @Autowired è opzionale se abbiamo un unico costruttore
	public Interviewer(Student student) {
		this.student = student;
	}

	public void askQuestion() {
		System.out.println("Buongiorno " + this.student.getName() + " " + this.student.getSurname() + ", mi risponda alla seguente domanda...blablabla");
		this.student.answerQuestion();
	}
}
