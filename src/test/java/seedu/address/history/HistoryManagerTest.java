package seedu.address.history;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.testutil.HistoryUtil.TYPICAL_SECOND_MODEL_STATE;
import static seedu.address.testutil.HistoryUtil.TYPICAL_START_MODEL_STATE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.history.exceptions.HistoryException;

class HistoryManagerTest {
    private HistoryManager<ModelState> history;
    private BufferedHistoryManager<ModelState> bufferedHistory;

    @BeforeEach
    void setup() {
        history = new HistoryManager<>(TYPICAL_START_MODEL_STATE);
        bufferedHistory = new BufferedHistoryManager<>(TYPICAL_START_MODEL_STATE);
    }

    @Test
    void rollBackState_noPreviousState_exceptionThrown() {
        assertThrows(HistoryException.class, () -> history.rollBackState());
    }
    @Test
    void rollForwardState_noNextState_exceptionThrown() {
        assertThrows(HistoryException.class, () -> history.rollForwardState());
    }
    @Test
    void getCurrState_typicalStartState_successfullyReturnsStartState() {
        ModelState modelState = history.getCurrState();
        assertEquals(modelState, TYPICAL_START_MODEL_STATE);
    }
    @Test
    void addState_typicalSecondState_successfullyReturnsSecondState() {
        history.addState(TYPICAL_SECOND_MODEL_STATE);
        assertEquals(history.getCurrState(), TYPICAL_SECOND_MODEL_STATE);
    }
    @Test
    void rollBackState_typicalSecondState_doesNotThrowExceptions() {
        history.addState(TYPICAL_SECOND_MODEL_STATE);
        assertDoesNotThrow(() -> history.rollBackState());
    }

    @Test
    void getCurrStateHasBuffer_typicalStartState_successfullyReturnsStartState() {
        assertThrows(HistoryException.class, () -> bufferedHistory.getCurrStateHasBuffer());
    }
}
