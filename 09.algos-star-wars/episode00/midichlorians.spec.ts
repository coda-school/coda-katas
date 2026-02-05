import {describe, expect, it} from "vitest"
import {
    totalMidichlorians,
    totalMidichloriansRecursively,
    totalMidichloriansRecursivelyWithIndex,
    totalMidichloriansWithForeach,
    totalMidichloriansWithReducer
} from "./midichlorians";

let jedis = [
    {name: "Luke", midichlorians: 8000},
    {name: "Yoda", midichlorians: 12000}
];

describe('Episode 0: les Midichloriens', () => {
    it("sums all midichlorians", () => {
        expect(totalMidichlorians(jedis)).toBe(20000);
        expect(totalMidichloriansWithForeach(jedis)).toBe(20000);
        expect(totalMidichloriansRecursively(jedis)).toBe(20000);
        expect(totalMidichloriansRecursivelyWithIndex(jedis)).toBe(20000);
        expect(totalMidichloriansWithReducer(jedis)).toBe(20000);
    });

    it("handles empty list", () => {
        expect(totalMidichlorians([])).toBe(0);
        expect(totalMidichloriansWithForeach([])).toBe(0);
        expect(totalMidichloriansRecursively([])).toBe(0);
        expect(totalMidichloriansWithReducer([])).toBe(0);
    });
});