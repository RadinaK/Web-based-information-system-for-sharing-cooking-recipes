package bg.tuplovdiv.cookingrecipes.services;


import bg.tuplovdiv.cookingrecipes.repositories.RecipeRepository;
import bg.tuplovdiv.cookingrecipes.repositories.IngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final ModelMapper mapper;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, ModelMapper mapper) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.mapper = mapper;
    }

//    @Override
//    @Transactional
//    public Employee create(CreateEmployeeDTO employeeDTO) {
//        Employee employee = mapper.map(employeeDTO, Employee.class);
//
//        Optional<Address> address = this.recipeRepository.findByCountryAndCity(
//                employeeDTO.getAddress().getCountry(),
//                employeeDTO.getAddress().getCity());
//
//        address.ifPresent(employee::setAddress);
//
//        return this.ingredientRepository.save(employee);
//    }
//
//    @Override
//    public List<EmployeeDTO> findAll() {
//        return this.ingredientRepository.findAll()
//            .stream()
//            .map(e -> mapper.map(e, EmployeeDTO.class))
//            .collect(Collectors.toList());
//    }
//
//    @Override
//    public EmployeeNamesDTO findNamesById(long id) {
//        return this.ingredientRepository.findNamesById(id);
//    }
//
//    @Override
//    public EmployeeNameAndSalaryDTO findNameAndSalaryById(long id) {
//        return this.ingredientRepository.findFirstNameAndSalaryById(id);
//    }
}
