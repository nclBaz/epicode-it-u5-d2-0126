package riccardogulin.u5d2.entities;

import lombok.*;

import java.util.UUID;

@ToString
@Getter
@Setter
// @AllArgsConstructor
@NoArgsConstructor
public abstract class Student {
	@Setter(AccessLevel.NONE) // Non crearmi il setter automaticamente su questo campo
	private UUID id;
	private String name;
	private String surname;

	public Student(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public abstract void answerQuestion();

}
