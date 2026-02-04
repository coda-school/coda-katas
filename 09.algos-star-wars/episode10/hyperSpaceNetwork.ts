export type HyperspaceNetwork = {
    [planet: string]: string[]
}

export function canReach(
    network: HyperspaceNetwork,
    start: string,
    destination: string
): boolean {
    // TODO: Utiliser DFS pour vérifier si destination est accessible depuis start
    return false;
}