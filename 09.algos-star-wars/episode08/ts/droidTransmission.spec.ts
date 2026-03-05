import { describe, it, expect } from 'vitest';
import {droidTransmission} from "./droidTransmission";

describe('Episode 8: La Transmission Droïde', () => {
    it('generates first term', () => {
        expect(droidTransmission(1)).toBe('1');
    });

    it('generates second term', () => {
        expect(droidTransmission(2)).toBe('11');
    });

    it('generates third term', () => {
        expect(droidTransmission(3)).toBe('21');
    });

    it('generates fourth term', () => {
        expect(droidTransmission(4)).toBe('1211');
    });

    it('generates fifth term', () => {
        expect(droidTransmission(5)).toBe('111221');
    });

    it('generates sixth term', () => {
        expect(droidTransmission(6)).toBe('312211');
    });

    it('generates seventh term', () => {
        expect(droidTransmission(7)).toBe('13112221');
    });
});