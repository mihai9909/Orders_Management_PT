package DataAccess;

import Model.Client;

import java.util.List;

public class ClientDAO extends AbstractDAO<Client> {

    // uses basic CRUD methods from superclass

    // TODO: create only client specific queries

    public Client find(int id){
        return findById(id);
    }

    public List<Client> find(){
        return findAll();
    }

    public void createClient(Client p){
        insert(p);
    }

    public void updateClient(Client p){
        update(p);
    }

    public void deleteClient(int id){
        deleteById(id);
    }
}
