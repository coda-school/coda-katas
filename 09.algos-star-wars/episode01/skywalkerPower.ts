export type Jedi = {
    name: string
    power: number
    children: Jedi[]
}

export const skywalkerPowerWithFor = (root: Jedi): number => {
    if (!root) return 0;

    let total = root.power;
    for (const child of root.children) {
        total += skywalkerPowerWithFor(child);
    }
    return total;
};

const skywalkerPowerForPadawans = (jedis: Jedi[]) => jedis.reduce(
    (power, child) => power + skywalkerPower(child),
    0);

export const skywalkerPower = (root: Jedi): number => {
    if (!root) return 0;
    return root.power + skywalkerPowerForPadawans(root.children);
};