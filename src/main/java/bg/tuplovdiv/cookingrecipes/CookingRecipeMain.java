package bg.tuplovdiv.cookingrecipes;

//import bg.tuplovdiv.cookingrecipes.models.dtos.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;

//@Component
public class CookingRecipeMain implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ModelMapper mapper = new ModelMapper();

//        PropertyMap<Employee, EmployeeDTO> propertyMap = new PropertyMap<>() {
//            @Override
//            protected void configure() {
//                map().setCity(source.getAddress().getCity());
//            }
//        };
//        mapper.addMappings(propertyMap);
//        mapper.validate();

//        TypeMap<Employee, EmployeeDTO> typeMap = mapper.createTypeMap(Employee.class, EmployeeDTO.class);
//        typeMap.addMappings(mapping -> mapping.map(
//                source -> source.getAddress().getCity(),
//                EmployeeDTO::setAddressCity)
//        );
////        typeMap.validate();
//
//        Address address = new Address("Bulgaria", "Sofia");
//        Employee employee = new Employee("First", BigDecimal.TEN, address);
//
//        EmployeeDTO employeeDTO = typeMap.map(employee);
//
//        System.out.println(employeeDTO);
    }
}
