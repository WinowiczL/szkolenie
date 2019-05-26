package com.winowicz.szkolenie;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Route("gui/get")
@Component
public class AnimalGetGui extends VerticalLayout {


    private AnimalRepo animalRepo;


    @Autowired
    public AnimalGetGui(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
        add(button);


        button.addClickListener(click -> {

                    animalRepo.findAll().forEach(animal -> {
                        Label label = new Label();
                        add(label);
                        label.setText("name:" + animal.getName() + " age:" + animal.getAge() + " id:" + animal.getId());
                    });


                }
        );
    }

    private Button button = new Button("Get Animals");


}


