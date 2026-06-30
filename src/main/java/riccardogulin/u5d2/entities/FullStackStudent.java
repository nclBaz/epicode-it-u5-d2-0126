package riccardogulin.u5d2.entities;

public class FullStackStudent extends Student {
	public FullStackStudent(String name, String surname) {
		super(name, surname);
	}

	@Override
	public void answerQuestion() {
		System.out.println("Ciao sono uno studente FULLSTACK, ecco la risposta alla domanda...blablabla");
	}

	@Override
	public String toString() {
		return "FullStackStudent{} " + super.toString();
	}
}
