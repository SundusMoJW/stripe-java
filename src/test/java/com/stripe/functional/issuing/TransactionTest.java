package com.stripe.functional.issuing;

import static org.junit.Assert.assertNotNull;

import com.stripe.BaseStripeTest;
import com.stripe.exception.StripeException;
import com.stripe.model.issuing.Transaction;
import com.stripe.model.issuing.TransactionCollection;
import com.stripe.net.ApiResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class TransactionTest extends BaseStripeTest {
  public static final String TRANSACTION_ID = "ipi_123";

  @Test
  public void testRetrieve() throws IOException, StripeException {
    final Transaction transaction = Transaction.retrieve(TRANSACTION_ID);

    assertNotNull(transaction);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/issuing/transactions/%s", TRANSACTION_ID)
    );
  }

  @Test
  public void testUpdate() throws IOException, StripeException {
    final Transaction transaction = Transaction.retrieve(TRANSACTION_ID);

    final Map<String, String> metadata = new HashMap<String, String>();
    metadata.put("key", "value");
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put("metadata", metadata);

    final Transaction updatedTransaction = transaction.update(params);

    assertNotNull(updatedTransaction);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        String.format("/v1/issuing/transactions/%s", transaction.getId()),
        params
    );
  }

  @Test
  public void testList() throws IOException, StripeException {
    final Map<String, Object> params = new HashMap<String, Object>();
    params.put("limit", 1);

    TransactionCollection transactions = Transaction.list(params);

    assertNotNull(transactions);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/issuing/transactions"),
        params
    );
  }
}
