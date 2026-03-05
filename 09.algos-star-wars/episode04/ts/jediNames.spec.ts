import { describe, it, expect } from 'vitest';
import {uniqueJediNames} from "./jediNames";

describe('Episode 4: L\'unicité de la Force', () => {
    it('removes duplicate Jedi names', () => {
        expect(uniqueJediNames(['Luke', 'Yoda', 'Luke', 'Obi-Wan', 'Yoda']))
            .toEqual(['Luke', 'Yoda', 'Obi-Wan']);
    });

    it('handles empty array', () => {
        expect(uniqueJediNames([])).toEqual([]);
    });

    it('handles array with no duplicates', () => {
        expect(uniqueJediNames(['Luke', 'Yoda', 'Obi-Wan']))
            .toEqual(['Luke', 'Yoda', 'Obi-Wan']);
    });

    it('handles array with all same names', () => {
        expect(uniqueJediNames(['Yoda', 'Yoda', 'Yoda']))
            .toEqual(['Yoda']);
    });
});