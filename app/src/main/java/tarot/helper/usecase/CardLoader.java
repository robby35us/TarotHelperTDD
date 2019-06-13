package tarot.helper.usecase;

import android.content.Context;

import tarot.helper.entity.card.Card;
import tarot.helper.entity.card.info.CardInfo;

public interface CardLoader {

    class Params{
        public Context context;
        public CardInfo info;

        public Params (Context context, CardInfo info) {
            this.context = context;
            this.info = info;
        }
    }

    interface InPort {
        void execute(Params params, OutPort outPort,
                     RequestDAI requestDai);
    }

    interface OutPort {
        void processResult(Card card);
    }

    interface RequestDAI {
        void requestCard(Params params, ResultDAI resultDAI);
    }

    interface ResultDAI {
        void handleResult(Card card);
    }
}
