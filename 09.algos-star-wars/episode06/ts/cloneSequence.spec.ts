import { describe, it, expect } from 'vitest';
import {cloneSequence} from "./cloneSequence";

describe('Episode 6: La Séquence des Clones', () => {
    it('generates first 10 Fibonacci numbers', () => {
        expect(cloneSequence(10))
            .toEqual([0, 1, 1, 2, 3, 5, 8, 13, 21, 34]);
    });

    it('handles n = 0', () => {
        expect(cloneSequence(0)).toEqual([]);
    });

    it('handles n = 1', () => {
        expect(cloneSequence(1)).toEqual([0]);
    });

    it('handles n = 2', () => {
        expect(cloneSequence(2)).toEqual([0, 1]);
    });

    it('handles larger sequence', () => {
        expect(cloneSequence(15))
            .toEqual([0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377]);
    });
});