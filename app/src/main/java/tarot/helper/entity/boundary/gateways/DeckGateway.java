package tarot.helper.entity.boundary.gateways;

import tarot.helper.entity.boundary.actions.RetrieveStoredCard;
import tarot.helper.entity.boundary.actions.StoreCard;
import tarot.helper.entity.boundary.datatransferobjects.card.Card;
import tarot.helper.entity.deck.Deck;

public class DeckGateway implements RetrieveStoredCard.RequestHandler,
                                    StoreCard.RequestHandler {
    private static DeckGateway gateway;

    private Deck deck;

    public static DeckGateway getInstance() {
        if(gateway == null)
            gateway = new DeckGateway(Deck.getInstance());
        return gateway;
    }

    DeckGateway (Deck deck) {
        this.deck = deck;
    }

    @Override
    public void handleRequest(RetrieveStoredCard.RequestData requestData, RetrieveStoredCard.ResultHandler resultHandler) {
        Card card = deck.getCard(requestData.getInfo());
        RetrieveStoredCard.ResultData resultData = new RetrieveStoredCard.ResultData(card);
        resultHandler.handleResult(resultData);
    }

    @Override
    public void handleRequest(StoreCard.RequestData requestData, StoreCard.ResultHandler resultHandler) {
        boolean successful = deck.addCard(requestData.getCard());
        StoreCard.ResultData resultData = new StoreCard.ResultData(successful);
        resultHandler.handleResult(resultData);
    }
}
