package bg.tuplovdiv.cookingrecipes;

//import bg.tuplovdiv.cookingrecipes.models.dtos.AddressDTO;
//import bg.tuplovdiv.cookingrecipes.models.dtos.CreateEmployeeDTO;
//import bg.tuplovdiv.cookingrecipes.models.dtos.EmployeeNameAndSalaryDTO;
import bg.tuplovdiv.cookingrecipes.services.RecipeService;
import bg.tuplovdiv.cookingrecipes.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class AppMain implements CommandLineRunner {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final Scanner scanner;

    @Autowired
    public AppMain(RecipeService recipeService, IngredientService ingredientService, Scanner scanner) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {

//        createAddress(scanner);
//        createEmployee(scanner);
//        printAllEmployees();
//        printEmployeeNames();
//        printEmployeeNameAndSalary();
    }

//    private void printEmployeeNameAndSalary() {
//        EmployeeNameAndSalaryDTO result = this.ingredientService.findNameAndSalaryById(1L);
//
//        System.out.println();
//    }
//
//    private void printEmployeeNames() {
//        System.out.println(this.ingredientService.findNamesById(1L));
//    }
//
//    private void printAllEmployees() {
//        this.ingredientService.findAll()
//            .forEach(System.out::println);
//    }
//
//    private void createEmployee() {
//        String firstName = scanner.nextLine();
//        BigDecimal salary = new BigDecimal(scanner.nextLine());
//        LocalDate birthday = LocalDate.parse(scanner.nextLine());
//
////        long addressId = Long.parseLong(scanner.nextLine());
//
//        String country = scanner.nextLine();
//        String city = scanner.nextLine();
//
//        AddressDTO address = new AddressDTO(country, city);
//
//        CreateEmployeeDTO employeeDTO =
//            new CreateEmployeeDTO(firstName, null, salary, birthday, address);
//
//        Employee employee = this.ingredientService.create(employeeDTO);
//
//        System.out.println(employee);
//    }
//
//    private void createAddress() {
//        String country = scanner.nextLine();
//        String city = scanner.nextLine();
//
//        AddressDTO data = new AddressDTO(country, city);
//
//        Address address = recipeService.create(data);
//
//        System.out.println(address);
//    }
}
