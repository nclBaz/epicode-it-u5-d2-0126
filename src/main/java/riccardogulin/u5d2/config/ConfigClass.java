package riccardogulin.u5d2.config;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import riccardogulin.u5d2.entities.BackendStudent;
import riccardogulin.u5d2.entities.FrontendStudent;
import riccardogulin.u5d2.entities.FullStackStudent;

import java.util.Locale;

@Configuration
/*
Grazie a questa annotazione, questa sarà una classe speciale all'interno di quest'applicazione.
Essa conterrà difatti tutte le dichiarazioni dei BEAN (cioè oggetti gestiti da Spring)
ciò significa che possiamo chiedere a Spring di creare e gestire determinati oggetti seguendo
le istruzioni che daremo in questa classe.
Ogni metodo annotato con @Bean serve per definire un oggetto diverso.
*/
@PropertySource("application.properties") // Serve per specificare in che file andare a cercare
// i valori delle variabile che vogliamo iniettare con @Value
public class ConfigClass {

	@Bean
	public int getNumber() {
		return 42;
	}

	@Bean
	public String getAdminName(@Value("${admin.name}") String adminName) {
		return adminName;
	}

	@Bean
	public String getAdminName2() {
		return "Ajeje";
	}

	@Bean
	public FrontendStudent getFEStudent() {
		return new FrontendStudent("Aldo", "Baglio");
	}

	@Bean(name = "giova")
	@Primary // Annotazione opzionale che permette di risolvere le ambiguità
	// E' una sorta di caso di default perché se Spring non sa chi scegliere
	// sceglierà questo come "ultima spiaggia"
	public BackendStudent getBEStudent() {
		return new BackendStudent("Giovanni", "Storti");
	}

	@Bean
	@Scope("prototype") // Di default sono tutti SINGLETON
	// SINGLETON = esiste UNA SOLA COPIA DELL'OGGETTO in tutta l'applicazione. Ogni volta che faccio .getBean()
	// mi torna sempre lo stesso
	// PROTOTYPE = ogni volta che faccio .getBean() mi torna una NUOVA COPIA dell'oggetto
	public FullStackStudent getFSStudent(@Value("${admin.name}") String name, @Value("${postgres.username}") String surname) {
		return new FullStackStudent(name, surname);
	}

//	@Bean
//	public FullStackStudent getFSStudent2() {
//		return new FullStackStudent("Giacomo", "Poretti");
//	}

//	@Bean
//	public Interviewer getInterviewer(Student student) {
//		// Il parametro Student è una DIPENDENZA di Interviewer
//		// Spring pertanto non è che solo crea oggetti semplici, ma è anche
//		// in grado di risolvere le dipendenze andando a ricercare nello
//		// scatolone se ci siano dei Bean compatibili (in questo caso per tipo)
//		// se li trova li passa ad Interviewer
//
//		// Se di Bean compatibili ne dovesse trovare zero, ci darebbe errore
//		// in partenza (cioè APPLICATION FAILED TO START)
//
//		// Anche se dovesse trovarne più di uno compatibile, ci darebbe un errore
//		// analogo
//
//		return new Interviewer(student);
//	}

	@Bean
	// Per quanto riguarda Bean basati su classi provenienti da librerie
	// esterne, non posso usare @Component ma devo per forza usare
	// la classe di configurazione
	public Faker getITFaker() {
		return new Faker(Locale.ITALIAN);
	}

}
