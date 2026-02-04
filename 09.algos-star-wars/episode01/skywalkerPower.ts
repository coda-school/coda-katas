export type Jedi = {
    name: string
    power: number
    children: Jedi[]
}

export const skywalkerPower = (root: Jedi): number => {
    if (!root) return 0;

    let total = root.power;
    for (const child of root.children) {
        total += skywalkerPower(child);
    }
    return total;
};

const skywalkerPowerFor = (jedis: Jedi[]) => jedis.reduce(
    (power, child) => power + skywalkerPower(child),
    0);

export const skywalkerPowerWithoutFor = (root: Jedi): number => {
    if (!root) return 0;
    return root.power + skywalkerPowerFor(root.children);
};