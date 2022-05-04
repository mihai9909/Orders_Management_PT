package BLL;

import BLL.Validators.*;
import DataAccess.ClientDAO;
import Model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {

    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new ClientAgeValidator());
        validators.add(new AddressValidator());
        validators.add(new NameValidator());

        clientDAO = new ClientDAO();
    }

    public Client findClientById(int id) {
        Client st = clientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The Client with id =" + id + " was not found!");
        }
        return st;
    }

    public void createNewClient(Client c){
        for (Validator<Client> v: validators) {
            v.validate(c);
        }
        clientDAO.createClient(c);
    }

    public void editClient(Client p){
        if(findClientById(p.getId()) == null){
            throw new NoSuchElementException("Client with id = "+ p.getId() +"does not exist");
        }
        for (Validator<Client> v: validators) {
            v.validate(p);
        }
        clientDAO.updateClient(p);
    }

    public void deleteClient(int id){
        clientDAO.deleteById(id);
    }
}

