package tarot.helper.entity.boundary.actions;

import tarot.helper.entity.boundary.datatransferobjects.card.Card;

public interface StoreCard {

    public interface ResultHandler {
        void handleResult(StoreCard.ResultData result);
    }

    public interface RequestHandler {
        void handleRequest(StoreCard.RequestData input, StoreCard.ResultHandler resultHandler);
    }

    public class RequestData {
        private Card card;

        public RequestData(Card card) {
            this.card = card;
        }

        public Card getCard() {
            return card;
        }
    }

    public class ResultData {
        private boolean successful;

        public ResultData(Boolean successful) {
            this.successful = successful;
        }

        public boolean wasSuccessful() {
            return successful;
        }
    }
}


