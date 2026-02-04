import {beforeEach, describe, expect, it} from "vitest"
import {DroidStack} from "./droidStack";

describe("Episode 3 : le réveil des Droïdes", () => {
    let stack: DroidStack<string>;

    beforeEach(() => {
        stack = new DroidStack();
    });

    it("manages droïdes correctly", () => {
        ["R2D2", "C3PO", "BB8", "K2SO", "IG-88", "D-O", "Chopper", "L3-37", "BD-1", "HK-47"]
            .forEach(droid => stack.push(droid));

        expect(stack.pop()).toBe("HK-47");
        expect(stack.pop()).toBe("BD-1");
        expect(stack.pop()).toBe("L3-37");
    });

    it("return undefined when no droid", () => {
        expect(stack.pop()).toBeUndefined();
    });

    it('push -> pop -> pop -> undefined', () => {
        stack.push("R2D2");
        expect(stack.pop()).toBe("R2D2");
        expect(stack.pop()).toBeUndefined();
    });
})