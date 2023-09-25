package bg.tuplovdiv.cookingrecipes.config;

import bg.tuplovdiv.cookingrecipes.repositories.RecipeRepository;
import bg.tuplovdiv.cookingrecipes.services.RecipeService;
import bg.tuplovdiv.cookingrecipes.services.RecipeServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class Config {

    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Scanner createScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public RecipeService createAddressService(RecipeRepository repo, ModelMapper mapper) {
        return new RecipeServiceImpl(repo, mapper);
    }
}
