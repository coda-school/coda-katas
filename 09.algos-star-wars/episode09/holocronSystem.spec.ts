import { describe, it, expect } from 'vitest';
import {calculateForceAverage, hqsToDecimal} from "./holocronSystem";

describe('Episode 10: Le Mystère du Système Holocron', () => {
    describe('hqsToDecimal', () => {
        it('converts single symbols', () => {
            expect(hqsToDecimal('⚫')).toBe(-2);
            expect(hqsToDecimal('⚪')).toBe(-1);
            expect(hqsToDecimal('0')).toBe(0);
            expect(hqsToDecimal('⭐')).toBe(1);
            expect(hqsToDecimal('💫')).toBe(2);
        });

        it('converts two-digit numbers', () => {
            expect(hqsToDecimal('💫0')).toBe(10);
            expect(hqsToDecimal('⭐⭐')).toBe(6);
            expect(hqsToDecimal('⚪⚫')).toBe(-7);
        });

        it('converts three-digit numbers', () => {
            expect(hqsToDecimal('💫⭐⭐')).toBe(56);
            expect(hqsToDecimal('💫⭐0⚪')).toBe(274);
        });

        it('converts larger numbers', () => {
            expect(hqsToDecimal('⭐0000')).toBe(625);
            expect(hqsToDecimal('💫💫💫💫💫')).toBe(3906);
        });

        it('handles negative results', () => {
            expect(hqsToDecimal('⚫⚫')).toBe(-12);
            expect(hqsToDecimal('⚪0')).toBe(-5);
        });
    });

    describe('calculateForceAverage', () => {
        it('calculates average from example', () => {
            const measurements = ['💫0', '⭐', '⚪', '⚫', '💫⭐⭐'];
            expect(calculateForceAverage(measurements)).toBe(12.8);
        });

        it('handles single measurement', () => {
            expect(calculateForceAverage(['💫0'])).toBe(10);
        });

        it('handles all positive measurements', () => {
            const measurements = ['⭐', '💫', '⭐⭐'];
            expect(calculateForceAverage(measurements)).toBe(3);
        });

        it('handles all negative measurements', () => {
            const measurements = ['⚫', '⚪', '⚪⚫'];
            expect(calculateForceAverage(measurements)).toBeCloseTo(-3.333, 2);
        });

        it('handles mixed positive and negative', () => {
            const measurements = ['💫💫', '⚫⚫', '0'];
            expect(calculateForceAverage(measurements)).toBe(0);
        });

        it('handles larger dataset', () => {
            const measurements = [
                '⭐', '💫', '💫⭐', '⭐⭐', '💫💫',
                '⚪', '⚫', '0', '⭐0', '💫0'
            ];
            expect(calculateForceAverage(measurements)).toBe(4.4);
        });

        it('handles empty array', () => {
            expect(calculateForceAverage([])).toBe(0);
        });
    });
});