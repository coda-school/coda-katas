export type Planet = {
    name: string
    satellites: Planet[]
}

export const findPlanet = (root: Planet, target: string): boolean => {
    if (root.name === target) return true
    for (const satellite of root.satellites) {
        if (findPlanet(satellite, target)) return true
    }
    return false
};

export const findPlanetWithoutFor = (root: Planet, target: string): boolean => {
    if (root.name === target) return true
    return root.satellites.find(satellite => findPlanet(satellite, target)) !== undefined;
};