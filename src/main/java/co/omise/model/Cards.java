package co.omise.model;

import co.omise.exception.*;

import java.io.IOException;
import java.util.List;

public class Cards extends OmiseList {
	protected String customer_id = null;
	protected List<Card> data = null;

	public List<Card> getData() {
		return data;
	}

	protected Cards setCustomerID(String id) {
		customer_id = id;
		for(Card card : data) {
			card.customer_id = id;
		}

		return this;
	}

	/**
	 * @param id Cannot be {@code null}.
	 * @return
	 * @throws OmiseAPIException
	 * @throws OmiseKeyUnsetException
	 * @throws OmiseUnknownException
	 * @throws IOException
	 * @throws OmiseAPIConnectionException
	 * @throws OmiseInvalidRequestException
	 */
	public Card retrieve(String id) throws OmiseAPIException, OmiseKeyUnsetException, OmiseUnknownException, OmiseAPIConnectionException, OmiseInvalidRequestException ,IOException {
		Card card = (Card)request(OmiseURL.API, String.format("%s/%s/%s/%s", Customer.ENDPOINT, customer_id, Card.ENDPOINT, id), RequestMethod.GET, null, Card.class);
		card.customer_id = customer_id;

		return card;
	}
}
