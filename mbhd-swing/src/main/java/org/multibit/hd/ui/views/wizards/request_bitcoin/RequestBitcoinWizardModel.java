package org.multibit.hd.ui.views.wizards.request_bitcoin;

import org.bitcoinj.core.Coin;
import com.google.common.base.Optional;
import org.multibit.hd.ui.views.components.enter_amount.EnterAmountModel;
import org.multibit.hd.ui.views.wizards.AbstractWizardModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Model object to provide the following to "request bitcoin" wizard:</p>
 * <ul>
 * <li>Storage of panel data</li>
 * <li>State transition management</li>
 * </ul>
 *
 * @since 0.0.1
 *
 */
public class RequestBitcoinWizardModel extends AbstractWizardModel<RequestBitcoinState> {

  private static final Logger log = LoggerFactory.getLogger(RequestBitcoinWizardModel.class);

  private Optional<String> recipientAddress = Optional.absent();
  private Optional<String> transactionLabel = Optional.absent();

  private Optional<String> notes = Optional.absent();

  private EnterAmountModel enterAmountModel;

  /**
   * @param state The state object
   */
  public RequestBitcoinWizardModel(RequestBitcoinState state) {
    super(state);
  }

  /**
   * @return The Bitcoin amount in coins
   */
  public Optional<Coin> getCoinAmount() {
    return enterAmountModel.getCoinAmount();
  }

  public Optional<String> getRecipientAddress() {
    return recipientAddress;
  }

  public void setRecipientAddress(String recipientAddress) {
    this.recipientAddress = Optional.of(recipientAddress);
  }

  public Optional<String> getTransactionLabel() {
    return transactionLabel;
  }

  public void setTransactionLabel(String transactionLabel) {
    this.transactionLabel = Optional.of(transactionLabel);
  }

  public Optional<String> getNotes() {
    return notes;
  }

  public void setNotes(Optional<String> notes) {
    this.notes = notes;
  }

  /**
   * <p>Reduced visibility for panel models</p>
   *
   * @param enterAmountModel The "enter amount" model
   */
  void setEnterAmountModel(EnterAmountModel enterAmountModel) {
    this.enterAmountModel = enterAmountModel;
  }
}
