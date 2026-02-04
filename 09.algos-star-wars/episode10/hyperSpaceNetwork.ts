type Planet = string;

export type HyperspaceNetwork = {
    [planet: Planet]: Planet[]
}

const dfs = (network: HyperspaceNetwork,
             current: Planet,
             destination: Planet,
             visited: Set<Planet>) => {
    if (current == destination) return true;
    if (visited.has(current)) return false;

    for (const neighbor of network[current] || []) {
        if (dfs(network, neighbor, destination, visited)) return true;
    }
    return false;
}

export const canReach = (
    network: HyperspaceNetwork,
    start: Planet,
    destination: Planet): boolean => dfs(network, start, destination, new Set<Planet>())