package Repositories;

import Clients.Client;
import Entities.CardEntity;
import Entities.ClientEntity;
import Mapper.ClientEntityMapper;
import Services.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    public static List<ClientEntity> findAll() {
        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from client", new ClientEntityMapper());
        List<ClientEntity> result = new ArrayList<>();

        for(Object o:objects) {
            if(o instanceof ClientEntity) {
                result.add((ClientEntity) o);
            }
            else {
                throw new RuntimeException("exception");
            }
        }
        return result;
    }

    public static void addClient(ClientEntity clientEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("insert into client(id, lastname, firstname, birthday, address, cardId) values('"
        + clientEntity.getId() + "', '"
        + clientEntity.getLastName() + "', '"
        + clientEntity.getFirstName() + "', '"
        + clientEntity.getBirthday() + "', '"
        + clientEntity.getAddress() + "', '"
        + clientEntity.getCardId() + "')");
    }

    public static void updateClient(ClientEntity clientEntity, String replacementLast, String replacementFirst) {
        DatabaseQueryExecutorService.executeUpdateQuery("update client set lastname='" +
                replacementLast + "', firstname='" + replacementFirst + "' where id=" + clientEntity.getId());
    }

    public static void deleteClient(ClientEntity clientEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("delete from client where id=" + clientEntity.getId());
    }
}
