package org.multibit.hd.ui.fest.use_cases.hardware_wallet;

import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.timing.Timeout;
import org.multibit.hd.ui.fest.use_cases.AbstractFestUseCase;
import org.multibit.hd.ui.languages.Languages;
import org.multibit.hd.ui.languages.MessageKey;
import org.multibit.hd.ui.views.wizards.welcome.WelcomeWizardState;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>Use case to provide the following to FEST testing:</p>
 * <ul>
 * <li>Verify the Trezor "press confirm wipe device" screen</li>
 * </ul>
 *
 * <p>Require the panel view to be showing (event triggered earlier)</p>
 *
 * @since 0.0.5
 */
public class TrezorConfirmWipeUseCase extends AbstractFestUseCase {

  public TrezorConfirmWipeUseCase(FrameFixture window) {
    super(window);
  }

  @Override
  public void execute(Map<String, Object> parameters) {

    // Check that the Trezor press confirm to wipe panel view is showing
    window
      .label(MessageKey.TREZOR_PRESS_CONFIRM_TITLE.getKey())
      .requireVisible();

    window
      .textBox(WelcomeWizardState.TREZOR_CREATE_WALLET_CONFIRM_CREATE_WALLET.name() + ".trezor_display")
      .requireText(Languages.safeText(MessageKey.TREZOR_WIPE_CONFIRM_DISPLAY))
      .requireVisible();

    // Check the 'Next' button is present and click it
    window
      .button(MessageKey.NEXT.getKey())
      .requireEnabled(Timeout.timeout(3, TimeUnit.SECONDS))
      .click();

  }
}