export function countPlanets(planets: string[]): Record<string, number> {
    const count: Record<string, number> = {};

    for (const planet of planets)
        count[planet] = (count[planet] || 0) + 1;

    return count;
}

export function countPlanetsWithMap(planets: string[]): Record<string, number> {
    const map = new Map<string, number>();
    for (const planet of planets)
        map.set(planet, (map.get(planet) || 0) + 1);
    return Object.fromEntries(map);
}

export function countPlanetsReduce(planets: string[]): Record<string, number> {
    return planets.reduce((acc, planet) => {
        acc[planet] = (acc[planet] || 0) + 1;
        return acc;
    }, {} as Record<string, number>);
}