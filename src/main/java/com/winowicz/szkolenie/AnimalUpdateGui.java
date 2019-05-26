package com.winowicz.szkolenie;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Route("gui/update")
@Component
public class AnimalUpdateGui extends VerticalLayout {


    private AnimalRepo animalRepo;

    @Autowired
    public AnimalUpdateGui(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;

        add(textField1);
        add(textField2);
        add(textField3);
        add(button);
        add(label);

        button.addClickListener(click -> animalRepo.save(new Animal(textField1.getValue(), Integer.parseInt(textField2.getValue()), Long.parseLong(textField3.getValue()))));
    }


    private TextField textField1 = new TextField("Animal name");
    private TextField textField2 = new TextField("Animal age");
    private TextField textField3 = new TextField("Animal id");


    private Button button = new Button("Update Animal with id" + textField3.getValue());
    private Label label = new Label();



}
