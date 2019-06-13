package tarot.helper.entity.boundary;

import tarot.helper.entity.card.Card;
import tarot.helper.entity.card.info.CardInfo;


public interface RetrieveStoredCard {

    public interface ResultHandler {
        void handleResult(ResultData result);
    }

    public interface RequestHandler {
        void handleRequest(RequestData input, ResultHandler resultHandler);
    }

    public class ResultData {
        private Card card;

        public ResultData(Card card) {
            this.card = card;
        }

        public Card getCard() {
            return card;
        }
    }

    public class RequestData {
        private CardInfo info;

        public RequestData(CardInfo info) {
            this.info = info;
        }

        public CardInfo getInfo() {
            return info;
        }
    }
}
