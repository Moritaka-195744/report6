package jp.ac.uryukyu.ie.e195744;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    @Test
    void judgement() {
        Judge judge = new Judge();
        judge.judgement(0,0);
        assertEquals(1,judge.getDraw());
    }
}