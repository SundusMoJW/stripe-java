package com.stripe.model.issuing;

import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Address;
import com.stripe.model.HasId;
import com.stripe.model.MetadataStore;
import com.stripe.model.StripeObject;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;

import java.util.Map;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Cardholder extends ApiResource implements MetadataStore<Cardholder>, HasId {
  @Getter(onMethod = @__({@Override})) String id;
  String object;
  Billing billing;
  Long created;
  String email;
  Boolean livemode;
  @Getter(onMethod = @__({@Override})) Map<String, String> metadata;
  String name;
  String phoneNumber;
  String status;
  String type;

  // <editor-fold desc="create">
  /**
   * Create an issuing cardholder.
   */
  public static Cardholder create(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      ApiConnectionException, CardException, ApiException {
    return create(params, null);
  }

  /**
   * Create an issuing cardholder.
   */
  public static Cardholder create(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      ApiConnectionException, CardException, ApiException {
    return request(RequestMethod.POST, classUrl(Cardholder.class), params,
      Cardholder.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="list">
  /**
   * List all issuing cardholders.
   */
  public static CardholderCollection list(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      ApiConnectionException, CardException, ApiException {
    return list(params, null);
  }

  /**
   * List all issuing cardholders.
   */
  public static CardholderCollection list(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException, ApiConnectionException,
      CardException, ApiException {
    return requestCollection(classUrl(Cardholder.class), params,
      CardholderCollection.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="retrieve">
  /**
   * Retrieve an issuing cardholder.
   */
  public static Cardholder retrieve(String id) throws AuthenticationException,
      InvalidRequestException, ApiConnectionException, CardException,
      ApiException {
    return retrieve(id, null);
  }

  /**
   * Retrieve an issuing cardholder.
   */
  public static Cardholder retrieve(String id, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      ApiConnectionException, CardException, ApiException {
    return request(RequestMethod.GET, instanceUrl(Cardholder.class, id), null,
      Cardholder.class, options);
  }

  /**
   * Retrieve an issuing cardholder.
   */
  public static Cardholder retrieve(String id, Map<String, Object> params,
      RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      ApiConnectionException, CardException, ApiException {
    return request(RequestMethod.GET, instanceUrl(Cardholder.class, id), params,
      Cardholder.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="update">
  /**
   * Update an issuing cardholder.
   */
  @Override
  public Cardholder update(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      ApiConnectionException, CardException, ApiException {
    return update(params, null);
  }

  /**
   * Update an issuing cardholder.
   */
  @Override
  public Cardholder update(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      ApiConnectionException, CardException, ApiException {
    return request(RequestMethod.POST, instanceUrl(Cardholder.class, this.id), params,
      Cardholder.class, options);
  }
  // </editor-fold>

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public final class Billing extends StripeObject {
    Address address;
    String name;
  }
}
