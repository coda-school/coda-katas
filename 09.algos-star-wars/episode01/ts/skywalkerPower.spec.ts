import { describe, it, expect } from 'vitest'
import {Jedi, skywalkerPower} from "./skywalkerPower";

const tree: Jedi = {
    name: "Anakin",
    power: 100,
    children: [
        {
            name: "Luke",
            power: 120,
            children: [
                { name: "Rey", power: 100, children: [] }
            ]
        },
        {
            name: "Leia",
            power: 90,
            children: []
        }
    ]
}

describe("Episode 1 : la puissance de Skywalker", () => {
    it("calculates total power of the bloodline", () => {
        expect(skywalkerPower(tree)).toBe(410);
    })
})
