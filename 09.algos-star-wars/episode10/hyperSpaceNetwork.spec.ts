import {describe, expect, it} from 'vitest';
import {canReach, HyperspaceNetwork} from "./hyperSpaceNetwork";

describe('Episode 10: Les Routes de l\'Hyperespace', () => {
    const network: HyperspaceNetwork = {
        'Coruscant': ['Tatooine', 'Naboo'],
        'Tatooine': ['Hoth'],
        'Naboo': ['Alderaan'],
        'Hoth': ['Dagobah'],
        'Alderaan': [],
        'Dagobah': [],
        'Mustafar': ['Geonosis'],
        'Geonosis': []
    };

    it('finds path between connected planets', () => {
        expect(canReach(network, 'Coruscant', 'Dagobah')).toBe(true);
        expect(canReach(network, 'Coruscant', 'Alderaan')).toBe(true);
    });

    it('detects when planets are not connected', () => {
        expect(canReach(network, 'Coruscant', 'Mustafar')).toBe(false);
        expect(canReach(network, 'Tatooine', 'Mustafar')).toBe(false);
    });

    it('handles same start and destination', () => {
        expect(canReach(network, 'Coruscant', 'Coruscant')).toBe(true);
    });

    it('handles non-existent planets', () => {
        expect(canReach(network, 'Unknown', 'Tatooine')).toBe(false);
        expect(canReach(network, 'Coruscant', 'Unknown')).toBe(false);
    });

    it('handles cyclic graphs', () => {
        const cyclicNetwork: HyperspaceNetwork = {
            'A': ['B'],
            'B': ['C'],
            'C': ['A']
        };
        expect(canReach(cyclicNetwork, 'A', 'C')).toBe(true);
        expect(canReach(cyclicNetwork, 'B', 'A')).toBe(true);
    });
});