/*
package lesson6.server.controllers;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Route(value = "loginu")
public class RegistrationController extends VerticalLayout {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    public RegistrationController() {
        add(getLoginForm());
        setAlignItems(Alignment.CENTER);
    }

    private static LoginForm getLoginForm(){
        LoginForm result = new LoginForm();
        result.addLoginListener(event -> {

            String username = event.getUsername();
            String password = event.getPassword();

            LOG.debug(String.format("Trying to login username = \"%s\" with password = \"%s\"", username, password));

        });
        return result;
    }
}*/

