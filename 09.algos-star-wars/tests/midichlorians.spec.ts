import { expect, it } from "vitest"
import {totalMidichlorians} from "../src/midichlorians";

it("sums all midichlorians", () => {
    expect(totalMidichlorians([
        { name: "Luke", midichlorians: 8000 },
        { name: "Yoda", midichlorians: 12000 }
    ])).toBe(20000);
});

it("handles empty list", () => {
    expect(totalMidichlorians([])).toBe(0);
});