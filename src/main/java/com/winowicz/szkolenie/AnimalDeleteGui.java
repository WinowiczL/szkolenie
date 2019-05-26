package com.winowicz.szkolenie;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Route("gui/delete")
@Component
public class AnimalDeleteGui extends VerticalLayout {


    private AnimalRepo animalRepo;

    @Autowired
    public AnimalDeleteGui(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
        add(textField1);
        add(button);
        add(label);

        button.addClickListener(click -> animalRepo.deleteById(Long.parseLong(textField1.getValue())));
    }


    private TextField textField1 = new TextField("Animal id");

    private Button button = new Button("Delete Animal");
    private Label label = new Label();




}
