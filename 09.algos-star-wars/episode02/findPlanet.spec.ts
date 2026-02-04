import { describe, it, expect } from "vitest"
import {findPlanet, Planet} from "./findPlanet";

const galaxy: Planet = {
    name: "Coruscant",
    satellites: [
        { name: "Tatooine", satellites: [{ name: "Naboo", satellites: [{ name: "Alderaan", satellites: [] }] }] },
        { name: "Hoth", satellites: [{ name: "Dagobah", satellites: [] }, { name: "Endor", satellites: [] }] },
        { name: "Mustafar", satellites: [{ name: "Geonosis", satellites: [] }] }
    ]
}

describe("Episode 2 : l'arbre des Planètes", () => {
    it("finds planets in the galaxy", () => {
        const targets = ["Naboo","Endor","Geonosis","Coruscant","Hoth","Tatooine","Dagobah","Alderaan","Mustafar","Yavin"]
        const expected = [true,true,true,true,true,true,true,true,true,false];
        targets.forEach((t,i)=> expect(findPlanet(galaxy,t)).toBe(expected[i]));
    })
})