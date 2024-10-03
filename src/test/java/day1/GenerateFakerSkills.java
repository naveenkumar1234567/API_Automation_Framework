package day1;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class GenerateFakerSkills {

	
	

	    private static final Faker faker = new Faker();

	    // Generate a random skill and related skills
	    public static void main(String[] args) {
	        String skill = generateSkill();
	        List<String> relatedSkills = generateRelatedSkills(skill);

	        System.out.println("Main Skill: " + skill);
	        System.out.println("Related Skills: " + relatedSkills);
	    }

	    // Method to generate a random skill (can use job title or programming language as a skill)
	    public static String generateSkill() {
	        return faker.job().title(); // or faker.programmingLanguage().name(); for programming languages
	    }

	    // Method to generate a list of related skills based on the main skill
	    public static List<String> generateRelatedSkills(String skill) {
	        List<String> relatedSkills = new ArrayList<>();

	        // Based on the skill, generate related skills. This can be hardcoded or randomly generated.
	        switch (skill.toLowerCase()) {
	            case "developer":
	                relatedSkills.add("Java");
	                relatedSkills.add("Python");
	                relatedSkills.add("JavaScript");
	                break;
	            case "data scientist":
	                relatedSkills.add("Machine Learning");
	                relatedSkills.add("Python");
	                relatedSkills.add("R");
	                break;
	            case "devops engineer":
	                relatedSkills.add("Docker");
	                relatedSkills.add("Kubernetes");
	                relatedSkills.add("CI/CD");
	                break;
	            default:
	                // For any random skill, generate random programming languages or job-related terms
	                relatedSkills.add(faker.programmingLanguage().name());
	                relatedSkills.add(faker.programmingLanguage().name());
	                relatedSkills.add(faker.programmingLanguage().name());
	                break;
	        }

	        return relatedSkills;
	    }
	}

	

