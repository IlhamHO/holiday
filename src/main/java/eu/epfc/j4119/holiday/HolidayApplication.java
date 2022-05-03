package eu.epfc.j4119.holiday;

import eu.epfc.j4119.holiday.entities.Holiday;
import eu.epfc.j4119.holiday.repositories.HolidayRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Scanner;

@Transactional
@SpringBootApplication
public class HolidayApplication implements CommandLineRunner {
	private HolidayRepository repository;

	public HolidayApplication(HolidayRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(HolidayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner in = new Scanner(System.in);
		do{
			System.out.println();
			System.out.println("Choisissez parmi les options suivantes:");
			System.out.println("1. lister les demandes de congé");
			System.out.println("2. demander un nouveau congé");
			System.out.println("3. annuler une demande de congé");
			System.out.println("Q. quitter l'application");
			String choice = in.nextLine();
			if(choice.equals("Q")) break;
			switch (choice){
				case "1":
					List<Holiday> holidays = repository.findAll();
					for(Holiday h : holidays) System.out.println(h);
					break;
				case "2":
					Holiday holiday1 = new Holiday();
					String employee = "Sylvie";
					System.out.println("Début: ");
					String start = in.nextLine();
					System.out.println("Fin: ");
					String end = in.nextLine();
					holiday1.setEmployee(employee);
					holiday1.setStart(start);
					holiday1.setEnd(end);
					holiday1.setStatus("REQUESTED");
					repository.save(holiday1);
					break;
				case "3":
					System.out.println("Demander l'id du congé à annuler");
					long id = Long.parseLong(in.nextLine());
					repository.deleteById(id);
					break;
				default:
					System.out.println("Le choix "+ choice+" n'est pas connu");
			}
		}while (true);
	}
}
