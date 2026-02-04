export type HyperspaceNetwork = {
    [planet: string]: string[]
}

export const canReach = (
    network: HyperspaceNetwork,
    start: string,
    destination: string): boolean => dfs(network, start, destination, new Set<string>());

function dfs(network: HyperspaceNetwork,
             planet: string,
             destination: string,
             visited: Set<string>): boolean {

    if (planet === destination) return true;
    if (visited.has(planet)) return false;

    visited.add(planet);

    for (const neighbor of network[planet] || []) {
        if (dfs(network, neighbor, destination, visited)) return true;
    }

    return false;
}