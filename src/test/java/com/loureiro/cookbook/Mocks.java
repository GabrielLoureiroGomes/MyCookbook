package com.loureiro.cookbook;

import com.loureiro.cookbook.entity.Cookbook;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;


@Component
public class Mocks {

    Cookbook getMacarraoBolonhesaRecipe() {
        Cookbook cook = new Cookbook();
        cook.setId(new ObjectId("60566ef00f176b6e48d404dd"));
        cook.setTitle("MACARRÃO À BOLONHESA");
        cook.setIngredients(asList("500g de Macarrão",
                "1kg de Carne Moída",
                "2 latas de molho de tomate pronto",
                "5 azeitonas verdes picadas",
                "1/2 Cebola",
                "1 colher de sopa de azeite de oliva"));
        cook.setPreparationSteps(asList("1 - Pique a cebola, refogue por alguns minutos em uma panela com óleo quente até dourar a cebola, mexendo para não queimar.",
                "2 - Misture a carne moída, deixe cozinhar por alguns minutos.",
                "3 - Adicione o caldo, o molho, os tomates picados, a cenoura cortada ao meio e mexa bem, deixe cozinhar por aproximadamente 40minutos em fogo baixo com a panela semi tampada. Descarte a cenoura depois que o molho estiver pronto.",
                "4 - Prepare o macarrão, misture o molho ao macarrão e sirva.",
                "5 - Acompanhamento Sugerido: Queijo Ralado e uma taça de vinho tinto"));
        return cook;
    }

    Cookbook getRisotoDeCamaraoRecipe() {
        Cookbook cook = new Cookbook();
        cook.setId(new ObjectId("6056717095bb770081341eba"));
        cook.setTitle("RISOTO DE CAMARÃO");
        cook.setIngredients(asList("400g de camarão cinza limpo",
                "3 xícaras (chá) de arroz branco",
                "1 cubo de caldo de camarão",
                "1/2 xícara (chá) de pimentão verde cortado em cubos pequenos",
                "1 cheiro-verde picado",
                "2 dentes de alho",
                "1 colher (sopa) de azeite",
                "1/2 limão",
                "Sal à gosto",
                "2 colheres de extrato de tomate"));
        cook.setPreparationSteps(asList("1 - Tempere o camarão com limão e sal, reserve por 10 minutos.",
                "2 - Enquanto isso, faça o arroz, fritando-o muito bem.",
                "3 - Em seguida, coloque água em uma panela, o suficiente para cobrir o arroz (sobrando uns 2 centímetros a mais do que o arroz no fundo da panela).",
                "4 - Coloque pouco sal, pois o molho do camarão levará o cubo de caldo de camarão.",
                "5 - Cozinhe em fogo baixo até que toda água seque.",
                "6 - Retire do fogo e deixe a tampa da panela aberta (para o arroz não passar do ponto).",
                "7 - E uma frigideira grande, que caiba todo o camarão, doure o alho e coloque todo o camarão sem o suco do limão.",
                "8 - Junte o tomate, o pimentão, o cheiro-verde, o extrato de tomate e o cubo de caldo de camarão.",
                "9 - Adicione um pouco de água, para que tenha molho suficiente para encobrir o camarão na frigideira. Cozinhe em fogo baixo por 5 minutos.",
                "10 - Enquanto isso, retire o arroz e coloque-o em um recipiente de cerâmica ou vidro, solte-o bastante com o garfo.",
                "11 - Junte o molho do camarão e misture, usando em uma das mãos um garfo, e em outra mão uma colher.",
                "12 - Decore com camarões grelhados e coentro, sirva bem quente!"
        ));
        return cook;
    }

    List<Cookbook> getListRecipes() {
        return asList(getMacarraoBolonhesaRecipe(), getRisotoDeCamaraoRecipe());
    }

}
