import {describe, expect, it} from 'vitest';
import {countPlanets, countPlanetsReduce, countPlanetsWithMap} from "./planets";

describe('Episode 5: Le Recensement Galactique', () => {
    it('counts planet occurrences', () => {
        const planets = ['Tatooine', 'Hoth', 'Tatooine', 'Naboo', 'Hoth', 'Tatooine'];
        expect(countPlanets(planets)).toEqual({'Tatooine': 3, 'Hoth': 2, 'Naboo': 1});
        expect(countPlanetsWithMap(planets)).toEqual({'Tatooine': 3, 'Hoth': 2, 'Naboo': 1});
        expect(countPlanetsReduce(planets)).toEqual({'Tatooine': 3, 'Hoth': 2, 'Naboo': 1});
    });

    it('handles empty array', () => {
        expect(countPlanets([])).toEqual({});
    });

    it('handles single planet repeated', () => {
        expect(countPlanets(['Coruscant', 'Coruscant', 'Coruscant']))
            .toEqual({'Coruscant': 3});
    });

    it('handles all different planets', () => {
        expect(countPlanets(['Tatooine', 'Hoth', 'Naboo']))
            .toEqual({
                'Tatooine': 1,
                'Hoth': 1,
                'Naboo': 1
            });
    });
});