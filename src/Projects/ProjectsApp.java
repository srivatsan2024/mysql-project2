package projects.exception;

import java.util.Objects;
import java.util.Scanner;

private ProjectService projectService = new ProjectService();
public class ProjectsApp {
	private List<string> operations = List.of(
			"1) add a project"
	);
	
	private Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		new ProjectsApp().processUserSelections();
	}
	
	private void processUserSelections() {
		boolean done = false;
		while (!done) {
			try {
				int selection = getUserSelection();
				switch (selection) {
					case -1:
						done = exitMenu();
						break;
						
					case 1: 
						createProject();
						break;
						
					default:
						System.out.println("Not a valid solution");
						break;
				}
			}
			catch (Exception e) {
				System.out.println("/nError: " + e + "Try again.");
			}
		}
	}
	
	
	private int getUserSelection() {
		printOperations();
		Integer input = getIntInput("Enter a menu selection: ");
		return Objects.isNull(input) ? -1 : input;
	}
	
	private void printOperations() {
		System.out.println("/nThere are the available sections. Press the Enter key to quit: ");
		
		operations.forEach(line -> System.out.println(" " + line));
	}
	
	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);
		
		if(Objects.isNull(input)) {
			return null;
		}
		try {
			return Integer.valueOf(input);
		}
		catch (NumberFormatException e) {
			throw new DbException(input + "is not valid");
		}
	}
	
	private String getStringInput(String prompt) {
		System.out.println(prompt + ":");
		String input = scanner.nextLine();
		
		return input.isBlank() ? null : input.trim();
		
	}
	
	private void createProject() {
	    String projectName = getStringInput("Enter the project name");
	    BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours");
	    BigDecimal actualHours = getDecimalInput("Enter the actual hours");
	    Integer difficulty = getIntInput("Enter the project difficulty (1-5)");
	    String notes = getStringInput("Enter the project notes");

	    Project project = new Project(); // Ensure Project is imported from projects.entity

	    project.setProjectName(projectName);
	    project.setEstimatedHours(estimatedHours);
	    project.setActualHours(actualHours);
	    project.setDifficulty(difficulty);
	    project.setNotes(notes);

	    Project dbProject = projectService.addProject(project);

	    System.out.println("You have successfully created project: " + dbProject);
	}
	
	private BigDecimal getDecimalInput(String prompt) {
		String input = getStringInput(prompt);
		
		if(Objects.isNull(input)) {
			return null;
		}
		try {
			return Integer.valueOf(input);
		}
		catch (NumberFormatException e) {
			throw new DbException(input + "is not valid");
		}
	} 

	
	
	
}
