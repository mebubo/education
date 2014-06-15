package c08_object_oriented_design;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BlackJackHandTest {

    @Test
    public void testScore() throws Exception {
        E08_01.BlackJackHand hand = new E08_01.BlackJackHand();
        hand.addCards(Arrays.asList(new E08_01.BlackJackCard(E08_01.Suit.Clubs, E08_01.Rank.Ace),
                new E08_01.BlackJackCard(E08_01.Suit.Spades, E08_01.Rank.King)));
        assertEquals(21, hand.score());
        assertTrue(hand.isBlackJack());
        hand.addCards(Arrays.asList(new E08_01.BlackJackCard(E08_01.Suit.Spades, E08_01.Rank.R4)));
        assertEquals(15, hand.score());
        assertFalse(hand.busted());
        assertFalse(hand.isBlackJack());
        hand.addCards(Arrays.asList(new E08_01.BlackJackCard(E08_01.Suit.Spades, E08_01.Rank.R8)));
        assertEquals(23, hand.score());
        assertTrue(hand.busted());
    }
}