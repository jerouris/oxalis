package eu.peppol.start.identifier;

import eu.peppol.identifier.ParticipantId;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * User: andy
 * Date: 4/11/12
 * Time: 11:19 AM
 */
public class ParticipantIdTest {

    @Test
    public void isValidOrganisationNumber() {

        // a valid orgNo
        assertTrue(ParticipantId.isValidNorwegianOrganisationNumber("968218743"));
    }

    @Test
    public void isNotvalidOrganisationNumber() {

        // not valid
        assertFalse(ParticipantId.isValidNorwegianOrganisationNumber("123456789"));
    }

    @Test
    public void nullIsInvalid() throws Exception {
        // null
        assertFalse(ParticipantId.isValidNorwegianOrganisationNumber((String) null));
    }

    @Test
    public void emptyStringIsInvalid() throws Exception {
        // empty String
        assertFalse(ParticipantId.isValidNorwegianOrganisationNumber(""));
    }

    @Test
    public void modulus0IsValid() {
        // modulus on sums = 0
        assertTrue(ParticipantId.isValidNorwegianOrganisationNumber("961329310"));
    }

    @Test
    public void lengthExceeds10isInvalid() {
        assertFalse(ParticipantId.isValidNorwegianOrganisationNumber("9020177699"));
        assertFalse(ParticipantId.isValidParticipantIdentifier("9908:9020177699"));
    }

}
