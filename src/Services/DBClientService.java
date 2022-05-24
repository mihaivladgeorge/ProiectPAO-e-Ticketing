package Services;

import Cards.Card;
import Cards.CreditCard;
import Clients.Client;
import Entities.CardEntity;
import Entities.ClientEntity;
import Repositories.ClientRepository;

import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DBClientService {
    public static List<Client> getAllClients() throws ParseException {

        List<ClientEntity> clientEntities = ClientRepository.findAll();
        List<Client> result = new ArrayList<>();

        for(ClientEntity cliE:clientEntities) {
            Card crd = DBCardService.getCard(cliE.getId());
            result.add(new Client(cliE.getLastName(),
                    cliE.getFirstName(),
                    new SimpleDateFormat("dd-MM-yyyy").parse(cliE.getBirthday()),
                    cliE.getAddress(),
                    cliE.getId(),
                    crd));
        }
    return result;
    }

    public static void AddClient(Client cli, Card crd) throws ParseException {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(cli.getId());
        clientEntity.setLastName(cli.getLastName());
        clientEntity.setFirstName(cli.getFirstName());
        clientEntity.setBirthday(new SimpleDateFormat("dd-MM-yyyy").format(cli.getBirthday()));
        clientEntity.setAddress(cli.getAddress());
        clientEntity.setCardId(crd.getId());

        ClientRepository.addClient(clientEntity);
    }

    public static void updateClient(Client cli, String last, String first) throws ParseException {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(cli.getId());
        clientEntity.setLastName(cli.getLastName());
        clientEntity.setFirstName(cli.getFirstName());
        clientEntity.setBirthday(new SimpleDateFormat("dd-MM-yyyy").format(cli.getBirthday()));
        clientEntity.setAddress(cli.getAddress());
        Card crd = DBCardService.getCard(cli.getId());
        clientEntity.setCardId(crd.getId());

        ClientRepository.updateClient(clientEntity, last, first);
    }

    public static void deleteClient(Client cli) throws ParseException {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(cli.getId());
        clientEntity.setLastName(cli.getLastName());
        clientEntity.setFirstName(cli.getFirstName());
        clientEntity.setBirthday(new SimpleDateFormat("dd-MM-yyyy").format(cli.getBirthday()));
        clientEntity.setAddress(cli.getAddress());
        Card crd = DBCardService.getCard(cli.getId());
        clientEntity.setCardId(crd.getId());

        DBCardService.deleteCard(crd, clientEntity.getId());

        ClientRepository.deleteClient(clientEntity);
    }

}
