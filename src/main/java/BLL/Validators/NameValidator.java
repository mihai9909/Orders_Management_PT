package BLL.Validators;

import Model.Client;

public class NameValidator implements Validator<Client>{
    @Override
    public void validate(Client client) {
        if(client.getName().length() < 2){
            throw new IllegalArgumentException("Name is not valid");
        }
    }
}
