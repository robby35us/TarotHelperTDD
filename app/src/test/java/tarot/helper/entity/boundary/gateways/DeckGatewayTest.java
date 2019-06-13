package tarot.helper.entity.boundary.gateways;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import tarot.helper.entity.boundary.actions.RetrieveStoredCard;
import tarot.helper.entity.boundary.actions.StoreCard;
import tarot.helper.entity.boundary.datatransferobjects.card.Card;
import tarot.helper.entity.boundary.datatransferobjects.info.CardInfo;
import tarot.helper.entity.boundary.datatransferobjects.info.MajorCardInfo;
import tarot.helper.entity.boundary.datatransferobjects.info.MinorCardInfo;
import tarot.helper.entity.boundary.gateways.DeckGateway;
import tarot.helper.entity.deck.DummyDeck;
import tarot.helper.entity.definitions.Number;
import tarot.helper.entity.definitions.Rank;
import tarot.helper.entity.definitions.Suit;

public class DeckGatewayTest {
    private static final CardInfo TEST_INFO_1;
    private static final CardInfo TEST_INFO_2;
    private static final CardInfo TEST_INFO_3;
    private static final Card TEST_CARD_1;
    private static final Card TEST_CARD_2;
    private static final Card TEST_CARD_3;

    static{
        TEST_INFO_1 = new MajorCardInfo(Number.SEVENTEEN);
        TEST_CARD_1 = new Card(TEST_INFO_1);

        TEST_INFO_2 = new MinorCardInfo(Suit.WANDS, Rank.QUEEN);
        TEST_CARD_2 = new Card(TEST_INFO_2);

        TEST_INFO_3 = new MinorCardInfo(Suit.PENTACLES, Rank.ACE);
        TEST_CARD_3 = new Card(TEST_INFO_3);

    }
    private DeckGateway gateway;

    @Before
    public void initializeGateway() {
        gateway = new DeckGateway(new DummyDeck());
    }

    @Test
    public void retrieveUnStoredCard_SendsBackNull() {
        gateway.handleRequest(new RetrieveStoredCard.RequestData(TEST_INFO_1), returnNull);
    }

    @Test
    public void storingCard_SendsBackTrue() {
        gateway.handleRequest(new StoreCard.RequestData(TEST_CARD_1), returnSuccessful);
    }

    @Test
    public void storingCardTwice_ReturnsFalse() {

        gateway.handleRequest(new StoreCard.RequestData(TEST_CARD_1), returnSuccessful);
        gateway.handleRequest(new StoreCard.RequestData(TEST_CARD_1), returnUnSuccessful);

    }

    @Test
    public void requestingStoredCard_SendsBackCard() {
        gateway.handleRequest(new StoreCard.RequestData(TEST_CARD_1), callRetrieveStoredCard);
    }

    @Test
    public void insertMultipleCards_Successful() {
        gateway.handleRequest(new StoreCard.RequestData(TEST_CARD_1), returnSuccessful);
        gateway.handleRequest(new StoreCard.RequestData(TEST_CARD_2), returnSuccessful);
        gateway.handleRequest(new StoreCard.RequestData(TEST_CARD_3), returnSuccessful);
    }

    private StoreCard.ResultHandler returnSuccessful = new StoreCard.ResultHandler() {
        @Override
        public void handleResult(StoreCard.ResultData result) {
            assertThat(result.wasSuccessful(), is(true));
        }
    };

    private StoreCard.ResultHandler returnUnSuccessful = new StoreCard.ResultHandler() {
        @Override
        public void handleResult(StoreCard.ResultData result) {
            assertThat(result.wasSuccessful(), is(false));
        }
    };

    private StoreCard.ResultHandler callRetrieveStoredCard = new StoreCard.ResultHandler() {
        @Override
        public void handleResult(StoreCard.ResultData result) {
            gateway.handleRequest(new RetrieveStoredCard.RequestData(TEST_INFO_1), returnTestCard1);
        }
    };

    private RetrieveStoredCard.ResultHandler returnNull = new RetrieveStoredCard.ResultHandler() {
        @Override
        public void handleResult(RetrieveStoredCard.ResultData result) {
            assertThat(result.getCard(), is(nullValue()));
        }
    };

    private RetrieveStoredCard.ResultHandler returnTestCard1 = new RetrieveStoredCard.ResultHandler() {
        @Override
        public void handleResult(RetrieveStoredCard.ResultData result) {
            assertThat(result.getCard().getInfo(), equalTo(TEST_CARD_1.getInfo()));
        }
    };

}
