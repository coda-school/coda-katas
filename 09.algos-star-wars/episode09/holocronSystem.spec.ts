import {describe, expect, it} from 'vitest';
import {hqsToDecimal} from "./holocronSystem";
import {readFileSync} from "node:fs";
import {join} from "path";

describe('Episode 09: Le Mystère du Système Holocron', () => {
    describe('hqsToDecimal', () => {
        it('converts single symbols', () => {
            expect(hqsToDecimal('⚫')).toBe(-2);
            expect(hqsToDecimal('⚪')).toBe(-1);
            expect(hqsToDecimal('0')).toBe(0);
            expect(hqsToDecimal('⭐')).toBe(1);
            expect(hqsToDecimal('Y')).toBe(2);
        });

        it('converts two-digit numbers', () => {
            expect(hqsToDecimal('Y0')).toBe(10);
            expect(hqsToDecimal('⭐⭐')).toBe(6);
            expect(hqsToDecimal('⚪⚫')).toBe(-7);
        });

        it('converts three-digit numbers', () => {
            expect(hqsToDecimal('Y⭐⭐')).toBe(56);
            expect(hqsToDecimal('Y⭐0⚪')).toBe(274);
        });

        it('converts larger numbers', () => {
            expect(hqsToDecimal('⭐0000')).toBe(625);
            expect(hqsToDecimal('YYYYY')).toBe(1562);
        });

        it('handles negative results', () => {
            expect(hqsToDecimal('⚫⚫')).toBe(-12);
            expect(hqsToDecimal('⚪0')).toBe(-5);
        });
    });

    describe('calculateForceAverage', () => {
        it('for hqs file', () => {
            const measurements: string[] = readFileSync(join(__dirname, "hqs"), "utf-8")
                .trim()
                .split(/\r?\n/);

            expect(measurements
                .map(hqsToDecimal)
                .reduce((acc, val) => acc + val, 0) / measurements.length).toBe(401.1026);
        });
    });
});