package BLL.Validators;

import Model.Client;

/**Validates Address*/
public class AddressValidator implements Validator<Client>{
    @Override
    public void validate(Client client) {
        if(client.getAddress().length() < 5){
            throw new IllegalArgumentException("Invalid Address");
        }
    }
}
